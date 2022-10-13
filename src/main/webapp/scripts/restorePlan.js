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
	if(url.includes("rownum")) {
		const rownum = url.substring(url.indexOf("=") + 1).substring(0);
		return editPlan(rownum);
	} else return restorePlan();
}

/*
 * makePlan, copyPlan 페이지의 플랜 작성 결과 restorePlan으로 보내는 메서드
 */
function restorePlan() {
	let p;
	// 플랜 저장 시 공개 여부 설정
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	// restorePlan.jsp로 이동
	planDetail.action = "RestorePlan.jsp?p_public=" + p;
	planDetail.submit();
}

/*
 * editPlan, copyPlan 페이지의 플랜 작성 결과 editPlanOk으로 보내는 메서드
 */
function editPlan(rownum) {
	var p = 1;
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	// editPlan_ok로 이동
	planDetail.action = "EditPlan_Ok.jsp?p_rownum=" + rownum + "&p_public=" + i;
	planDetail.submit();
}