/* 
 * PlanInfo를 저장하는 js 파일
 */
/* scheduleForm */
var planInfo = document.scheduleForm;
var title = planInfo.title;
var firstDate = planInfo.firstdate;
var lastDate = planInfo.lastdate;
var tagList = planInfo.taglist;
/* writeCheck()에서 초기화 */
var titleValue = "";
var firstValue = "";
var lastValue = "";
var taglistValue = "";
var infoBtn = document.getElementById("makeInfo");

/* plan detail 폼 */
var planDetail = document.makePlanForm;
var p_title = planDetail.p_title;
var p_firstdate = planDetail.p_firstdate;
var p_lastdate = planDetail.p_lastdate;
var t_namelist = planDetail.t_namelist;

/*
* 요소
* */
// 스크롤 용 여백
var blank = document.createElement("div");
blank.classList.add("blank");

// writeSimplePlan 유효성 검사
function writeCheck() {
	var titleCheck = true;
  	var schedule = true;
	var notitle = document.getElementById("notitle");
	var noschedule = document.getElementById("noschedule");

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

	/* 유효성 검사 완료 시 값 받아 옴 */
	titleValue = title.value;
	firstValue = firstDate.value;
	lastValue = lastDate.value;
	taglistValue = tagList.value;

	/*
	* makePlan 페이지의 경우 makeplan()
	* copy, edit 페이지의 경우 editCheck()
	*  */
	var btnName = infoBtn.name;
	if (btnName == "make") makePlanInfo();
	else editCheck();
}

// plan info 저장
function makePlanInfo() {
	/* planDetail 폼에  planInfo 값 세팅 */
	p_title.setAttribute("value", titleValue);
	p_firstdate.setAttribute("value", firstValue);
	p_lastdate.setAttribute("value", lastValue);
	t_namelist.setAttribute("value", taglistValue);
	
	// 제목 저장
	document.querySelector(".plan_sub").children[0].innerHTML = titleValue;
	
	// 작성 갱신 되면서 day tab 계산
	// new date를 이용해 문자열을 날짜형 포맷으로 변경
	var fDate = new Date(firstValue);
	var lDate = new Date(lastValue);
	var day = lDate - fDate;
	var currDay = 24 * 60 * 60 * 1000;
	day = parseInt(day/currDay) + 1;
	
	makeDayTab(day);
	makeDayPlan(day);

	// 모달 종료
	$('.modal_zone').addClass('modal_hidden');
}

function makeDayTab(day) {
	// 날짜 탭 요소 생성
	var day_tab = document.getElementById("day_tab");
	for (var i = 1; i <= day; i++) {
		var tab = document.createElement("li");
		/* tab 클릭 시 해당 탭의 날짜의 플랜으로 스크롤 -> side.js */
		tab.setAttribute("onclick", "tabScroll(this)");
		tab.setAttribute("id", "day" + i);
		tab.innerHTML = "Day" + i;
		if(i == 1) tab.classList.add("active_day");
		day_tab.appendChild(tab);
	}
}
function makeDayPlan(day) {
	var plan_con = document.getElementById("plan_con");
	// 각 날짜 별 plan 추가되는 공간 요소 생성
	for (var i = 1; i <= day; i++) {
		var day_plan = document.createElement("div");
		day_plan.classList.add("day_plan");
		day_plan.classList.add("day_plan" + i);

		var plan_day = "<div class='plan_day'>Day" + i + "</div>"
		var in_day = "<input type='text' name='day" + i
							+ "' value='" + i
							+ "' hidden>"
		var in_btn = "<input type='button' onclick='getSpotContainer(this)'"
							+ " class='plan_btn'"
							+ " id='plan_btn" + i
							+ "' value='+'>"

		day_plan.innerHTML = plan_day + in_day + in_btn;

		plan_con.appendChild(day_plan);
	}
	plan_con.appendChild(blank);
}