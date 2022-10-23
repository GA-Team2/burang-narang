/*
* 플랜 유효성 체크 메서드
* */
function planCheck() {
	// 유효성 검사
	let day = 0;
	while(true){
		const dayPlan = document.getElementById("day_plan" + (day + 1));
		if(dayPlan != null) day++;
		else break;
	}

	for(var i = 1; i <= day; i++){
		// tripday에 플랜이 하나도 없으면 alert 띄움
		const plan = document.getElementById("plan_list"+i+"_1");
		if(plan == null){
			alert("day" + i + "의 계획을 작성해 주세요.");
			return;
		}
	}

	const url = window.document.location.href;
	if(url.includes("rownum") && !url.includes("pop")) {
		const rownum = url.substring(url.indexOf("=") + 1).substring(0);
		return editPlan(rownum);
	} else return savePlan();
}

/*
 * makePlan, copyPlan 페이지의 플랜 작성 결과 restorePlan으로 보내는 메서드
 */
function savePlan() {
	let p;
	// 플랜 저장 시 공개 여부 설정
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;

	const xhr = new XMLHttpRequest();

	const planInfoData = {
		memberNickname: planDetail.m_nickname.value,
		planTitle: titleValue,
		planFirstDate: new Date(firstValue),
		planLastDate: new Date(lastValue),
		tagNameList: taglistValue,
		planPublic: p
	}

	xhr.open('POST', '/new/formdata');
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.parse(planInfoData));
	
	// restorePlan.jsp로 이동

	//planDetail.action = "RestorePlan.jsp?p_public=" + p;
	//planDetail.submit();

	let tripDays = 0;
	let i = 1;
	while(document.getElementById("day"+i) != null) {
		tripDays++;
		i++;
	}

	let planDetailDataList = new FormData()

	for (const planDetailDataListKey in planDetailDataList) {
		
	}
	for (let d = 1; d <= tripDays; d++) {
		const seq = document.getElementsByName("p_seq" + d);
		const snum = document.getElementsByName("s_snum" + d);
		const sname = document.getElementsByName("s_name" + d);

		seq.forEach(function (value){
			const planDetailData = {
				planTripDay: d,
				//planTripDate;
				planSequence: seq.value,
				spotSerialNumber: snum.value,
				planSpotName: sname.value
			}
		});

	}

}

/*
 * editPlan, copyPlan 페이지의 플랜 작성 결과 editPlanOk으로 보내는 메서드
 */
function editPlan(rownum) {
	let p;
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	// editPlan_ok로 이동
	planDetail.action = "EditPlanOk.jsp?p_rownum=" + rownum + "&p_public=" + p;
	planDetail.submit();
}