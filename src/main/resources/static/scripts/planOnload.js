/*
* makePlan, editPlan, copyPlan 페이지 로드 시 day 쿠키 리셋 및 세팅
* */
window.onload = function () {
    /* trip day 쿠키 초기화 */
    resetDay();
    /*
    * 하나 이상의 날짜가 존재 시
    * editPlan과 copyPlan이므로, 페이지에 맞춰 쿠키 세팅 및 페이지 요소 수정
    * */
    if (document.getElementById("day_plan1") != null) {
        sessionCheck();
        setDays();
        setPlaces();
        editScheduleForm();
    } else return;
}

function sessionCheck() {
    if (planDetail.m_nickname.value == "") {
        location.href = "/login";
    }
}

/*
* editPlan, copyPlan의 경우 writeSimplePlan 수정
* */
function editScheduleForm() {
    title.value = p_title.value;
    const fdate = p_firstdate.value.substring(0, 10);
    const ldate = p_lastdate.value.substring(0, 10);
    p_firstdate.value = fdate;
    p_lastdate.value = ldate;
    firstDate.value = fdate;
    lastDate.value = ldate;
    tagList.value = t_namelist.value;

    setTagList();

    const url = window.document.location.href;
    let rownum = url.substring(url.indexOf("rownum=")).substring(7);
    let pop = null;

    if (url.includes("pop")) {
        pop = 0;
        rownum = rownum.substring(0, rownum.indexOf("&"));
    }

    infoBtn.name = "edit";

    if (pop == null) {
        const scheduleTitle = planInfo.children[0].children[0];
        scheduleTitle.innerHTML = "플랜 수정";
        infoBtn.setAttribute("value", "수정");
        cancelBtn.setAttribute("value", "취소");
        cancelBtn.setAttribute("onclick", "location.href='detail?mypage=true&rownum=" + rownum + "'");
    } else {
        cancelBtn.setAttribute("onclick", "location.href='detail?rownum=" + rownum + "&pop=true'");
        document.title = "새 플랜 작성"
    }
}

/*
* writeSimplePlan에 tag 세팅
* */
function setTagList() {
    // tag 세팅
    const tagArea = document.getElementById("tag_area");
    const tagArr = tagList.value.split(" ");

    // 공백 하나 더 인식 되서 length-1
    for (let j = 0; j < tagArr.length - 1; j++) {
        const addTag = document.createElement("span");
        const tagId = tagArr[j] + "_in";

        addTag.id = tagId;
        addTag.className = "highlight";
        addTag.innerText = tagArr[j];
        addTag.onclick = function () {
            removeTag(tagId);
        };

        tagArea.appendChild(addTag);
    }
}


/*
* 여행 일자와 플랜에 맞춰 장소 노드 생성
* */
function setPlaces() {
    let tday = 0;
    let seq = [];
    let spots = [];

    while (getDay(tday + 1) != null) {
        seq[tday] = getDay(tday + 1) - 1;
        tday++;
    }

    // 각 tripday의 sequence의 spot 정보 받아와 지도에 세팅
    for (let i = 1; i <= tday; i++) {
        for (let j = 1; j <= seq[i - 1]; j++) {
            const spot = {
                spotLocation: document.getElementById("s_loc" + i + "_" + j).value,
                tripDay: i,
                tripSequence: j
            }
            spots.push(spot);
        }
    }

    initSpotSequence(spots[spots.length - 1].tripDay);

    spots.forEach(spot => setSpotSequence(spot.tripDay, spot.tripSequence));

    (async () => {
        try {
            for (let spot of spots) {
                const result = await addressSearch(spot.spotLocation);
                setMapSpot(result, spot.tripDay, spot.tripSequence);
            }
        } catch (e) {
            console.log(e);
        }
    })();

    setMapZoom();
}