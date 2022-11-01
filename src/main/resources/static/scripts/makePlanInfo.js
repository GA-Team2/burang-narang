/* scheduleForm 요소 */
const planInfo = document.scheduleForm;
title = planInfo.title;
firstDate = planInfo.firstdate;
lastDate = planInfo.lastdate;
tagList = planInfo.taglist;
infoBtn = document.getElementById("makeInfo");
cancelBtn = planInfo.cancel;
modalArea = document.getElementById("modal_area");
/* scheduleForm에 대입될 값 */
let titleValue;
let firstValue;
let lastValue;
let taglistValue;

/* plan detail 폼  요소 */
const planDetail = document.makePlanForm;
p_title = planDetail.p_title;
p_firstdate = planDetail.p_firstdate;
p_lastdate = planDetail.p_lastdate;
t_namelist = planDetail.t_namelist;

/**
 * writeSimplePlan 유효성 검사 후 planInfo 값 저장
 *
 * @returns makePlan일 경우 makePlanInfo(); copyPlan, editPlan일 경우 editCheck()
 */
function writeCheck() {
    let titleCheck = true;
    let schedule = true;
    const notitle = document.getElementById("notitle");
    const noschedule = document.getElementById("noschedule");

    if (title.value.length === 0) {
        notitle.className = "";
        titleCheck = false;
    } else {
        notitle.className = "hidden";
    }

    if (firstDate.value.length === 0) {
        noschedule.className = "";
        schedule = false;
    } else {
        noschedule.className = "hidden";
    }

    if (titleCheck === false || schedule === false) {
        return;
    }

    titleValue = title.value;
    firstValue = firstDate.value;
    lastValue = lastDate.value;
    taglistValue = tagList.value;

    /*
    * makePlan 페이지의 경우 makeplan()
    * copy, edit 페이지의 경우 editCheck()
    */
    const btnName = infoBtn.name;
    if (btnName == "make") return makePlanInfo();
    else return editCheck();
}

/**
 * plan Info를 makePlanForm에 저장
 */
function makePlanInfo() {
    p_title.setAttribute("value", titleValue);
    p_firstdate.setAttribute("value", firstValue);
    p_lastdate.setAttribute("value", lastValue);
    t_namelist.setAttribute("value", taglistValue);
    document.getElementById("plan_title").children[0].innerHTML = titleValue;

    /* 총 trip day 계산 */
    const fDate = new Date(firstValue);
    const lDate = new Date(lastValue);
    const currDay = 24 * 60 * 60 * 1000;
    const day = parseInt((lDate - fDate) / currDay) + 1;

    initSpotSequence(day);
    makeDayTab(day);
    makeDayPlan(day);
    closeEdit();
}

/**
 * 날짜 탭 요소 생성
 *
 * @param 총 여행 날짜 (1박 2일의 경우 2 대입)
 */
function makeDayTab(day) {
    const dayTabContainer = document.getElementById("day_tab_con");
    for (let i = 1; i <= day; i++) {
        const dayTab = document.createElement("li");
        /* tab 클릭 시 해당 탭의 날짜의 플랜으로 스크롤 -> side.js */
        dayTab.setAttribute("onclick", "tabScroll(this)");
        dayTab.setAttribute("id", "day" + i);
        dayTab.innerHTML = "Day" + i;
        if (i == 1) dayTab.classList.add("active_day");
        dayTabContainer.appendChild(dayTab);
    }
}

/**
 * 플랜 작성이 이루어질 container를 날짜별로 생성
 *
 * @param 총 여행 날짜 (1박 2일의 경우 2 대입)
 */
function makeDayPlan(day) {
    const planListsContainer = document.getElementById("plan_lists_container");
    // 각 날짜 별 plan 추가되는 공간 요소 생성
    for (let i = 1; i <= day; i++) {
        const dayPlanContainer = document.createElement("div");
        dayPlanContainer.setAttribute("id", "day_plan" + i);

        const planDayTitle = `<div class='plan_day_title'>Day${i}</div>`;
        const addPlanButton = `<input type='button' onclick='getSpotContainer(this)' class='add_plan_button' id='add_plan${i}' value='+'>`;

        dayPlanContainer.innerHTML = planDayTitle + addPlanButton;
        planListsContainer.appendChild(dayPlanContainer);
    }

    const scroll = document.createElement("div");
    scroll.classList.add("blank");
    planListsContainer.appendChild(scroll);
}