/**
 * 
 */

function restore_plan() {
	var day=0;
	// day 개수
	while(true){
		var dayPlan = document.querySelector(".day_plan"+(day+1));
		if(dayPlan != null) day++;
		else break;
	}
	
	for(var i=1; i<=day; i++){
		// 날짜에 플랜이 하나도 없으면 alert 띄움
		var plan = document.getElementById("p_list"+i+"_"+1);
		console.log(plan);
		if(plan == null){
			alert("day"+i+"의 계획을 작성해 주세요.");
			return;
		}
	}

	var p = 1;
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	document.makePlanForm.action = "RestorePlan.jsp?p_public="+p;
	document.makePlanForm.submit();
}

function editPlan(rownum) {
	var day=0;
	// day 개수
	while(true){
		var dayPlan = document.querySelector(".day_plan"+(day+1));
		if(dayPlan != null) day++;
		else break;
	}
	console.log(day);
	
	for(var i=1; i<=day; i++){
		// 날짜에 플랜이 하나도 없으면 alert 띄움
		var plan = document.getElementById("p_list"+i+"_"+1);
		console.log(plan);
		if(plan == null){
			alert("day"+i+"의 계획을 작성해 주세요.");
			return;
		}
	}
	
	var p = 1;
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	document.editPlanForm.action = "EditPlan_Ok.jsp?p_rownum="+rownum+"&p_public="+i;
	document.editPlanForm.submit();
}