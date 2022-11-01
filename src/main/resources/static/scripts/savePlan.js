/**
 * 플랜 저장 시 유효성 체크 메서드
 */
function planCheck() {
    let day = 0;
    while (true) {
        const dayPlan = document.getElementById("day_plan" + (day + 1));
        if (dayPlan != null) day++;
        else break;
    }

    for (var i = 1; i <= day; i++) {
        // tripday에 플랜이 하나도 없으면 alert 띄움
        const plan = document.getElementById("plan_list" + i + "_1");
        if (plan == null) {
            alert("day" + i + "의 계획을 작성해 주세요.");
            return;
        }
    }

    const url = window.document.location.href;
    if (url.includes("rownum") && !url.includes("pop")) {
        const rownum = url.substring(url.indexOf("rownum=")).substring(7);
        return saveEditPlanInfo(rownum);
    } else {
        savePlanInfo();
    }
}

/**
 * makePlan, copyPlan 페이지의 플랜 인포 저장
 */
function savePlanInfo() {
    let p;
    // 플랜 저장 시 공개 여부 설정
    if (window.confirm("플랜을 공개하시겠습니까?")) p = 1;
    else p = 0;

    const xhr = new XMLHttpRequest();

    const planInfoDTO = {
        "memberNickName": planDetail.m_nickname.value,
        "planTitle": titleValue,
        "planFirstDate": new Date(firstValue),
        "planLastDate": new Date(lastValue),
        "tagNameList": taglistValue,
        "planPublic": p
    }

    xhr.open('POST', '/new/planinfo', true);
    xhr.responseType = "json";
    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.onreadystatechange = () => { // Call a function when the state changes.
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            savePlanDetail();
        }
    }

    xhr.send(JSON.stringify(planInfoDTO));
}

/**
 * makePlan, copyPlan 페이지의 플랜 디테일 저장
 */
function savePlanDetail() {
    let planDetailDTOList = [];

    let date1 = new Date(firstValue);
    let date2 = new Date(lastValue);
    let tripDays = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1;

    let seq = 1;
    for (let i = 1; i <= tripDays; i++) {
        while (document.getElementById("p_seq" + i + "_" + seq) != null) {

            let tripDate = new Date(firstValue);
            if (i > 1) tripDate.setDate(tripDate.getDate() + (i - 1));

            const planDetailDTO = {
                "planTripDay": i,
                "planTripDate": tripDate,
                "planSequence": seq,
                "spotSerialNumber": document.getElementById("s_snum" + i + "_" + seq).value,
                "planSpotName": document.getElementById("s_name" + i + "_" + seq).value
            }
            planDetailDTOList.push(planDetailDTO);
            seq++;
        }
        seq = 1;
    }
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/new/plandetail', true);
    xhr.responseType = "json";
    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.onreadystatechange = () => { // Call a function when the state changes.
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            const rownum = xhr.response;
            location.href = "/detail?mypage=true&rownum=" + rownum;
        }
    }
    xhr.send(JSON.stringify(planDetailDTOList));
}

/**
 * editPlan 페이지의 플랜 인포 수정
 *
 * @param rownum 게시물 번호
 */
function saveEditPlanInfo(rownum) {
    let p;
    if (window.confirm("플랜을 공개하시겠습니까?")) p = 1;
    else p = 0;

    const xhr = new XMLHttpRequest();

    const planInfoDTO = {
        "planRowNumber": rownum,
        "memberNickName": planDetail.m_nickname.value,
        "planTitle": titleValue,
        "planFirstDate": new Date(firstValue),
        "planLastDate": new Date(lastValue),
        "tagNameList": taglistValue,
        "planPublic": p
    }

    xhr.open('POST', '/detail/planinfo', true);
    xhr.responseType = "json";
    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.onreadystatechange = () => { // Call a function when the state changes.
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            saveEditPlanDetail(rownum);
        }
    }
    xhr.send(JSON.stringify(planInfoDTO));
}

/**
 * EditPlan 페이지의 플랜 디테일 수정
 *
 * @param rownum 게시물 번호
 */
function saveEditPlanDetail(rownum) {
    let planDetailDTOList = [];
    let date1 = new Date(firstValue);
    let date2 = new Date(lastValue);
    let tripDays = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1;

    let seq = 1;
    for (let i = 1; i <= tripDays; i++) {
        while (document.getElementById("p_seq" + i + "_" + seq) != null) {

            let tripDate = new Date(firstValue);
            if (i > 1) tripDate.setDate(tripDate.getDate() + (i - 1));

            const planDetailDTO = {
                "planRowNumber": rownum,
                "planTripDay": i,
                "planTripDate": tripDate,
                "planSequence": seq,
                "spotSerialNumber": document.getElementById("s_snum" + i + "_" + seq).value,
                "planSpotName": document.getElementById("s_name" + i + "_" + seq).value
            }
            planDetailDTOList.push(planDetailDTO);
            seq++;
        }
        seq = 1;
    }
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/detail/plandetail', true);
    xhr.responseType = "json";
    xhr.setRequestHeader('Content-type', 'application/json');

    xhr.onreadystatechange = () => { // Call a function when the state changes.
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            location.href = "/detail?mypage=true&rownum=" + rownum;
        }
    }
    xhr.send(JSON.stringify(planDetailDTOList));
}