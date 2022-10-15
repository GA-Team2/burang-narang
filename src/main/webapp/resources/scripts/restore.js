/**
 * makePlan.jsp, copyPlan.jsp
 */
function restore_plan() {
	// 유효성 검사
	var day = 0;
	while(true){
		var dayPlan = document.querySelector(".day_plan" + (day + 1));
		if(dayPlan != null) day++;
		else break;
	}

	for(var i = 1; i <= day; i++){
		// tripday에 플랜이 하나도 없으면 alert 띄움
		var plan = document.getElementById("p_list"+i+"_"+1);
		if(plan == null){
			alert("day" + i + "의 계획을 작성해 주세요.");
			return;
		}
	}

	var p = 1;
	// 플랜 저장 시 공개 여부 설정
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	var f = document.makePlanForm;
	if(f == null) f = document.editPlanForm;
	
	// restorePlan.jsp로 이동
	f.action = "RestorePlan.jsp?p_public=" + p;
	f.submit();
}

// editPlan.jsp 
function editPlan(rownum) {
	// 위와 동일
	var day = 0;
	while(true){
		var dayPlan = document.querySelector(".day_plan" + (day + 1));
		if(dayPlan != null) day++;
		else break;
	}
	
	for(var i = 1; i <= day; i++){
		// 날짜에 플랜이 하나도 없으면 alert 띄움
		var plan = document.getElementById("p_list" + i + "_" + 1);
		if(plan == null){
			alert("day" + i + "의 계획을 작성해 주세요.");
			return;
		}
	}
	
	var p = 1;
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	// editPlan_ok로 이동
	document.editPlanForm.action = "EditPlan_Ok.jsp?p_rownum=" + rownum + "&p_public=" + i;
	document.editPlanForm.submit();
}