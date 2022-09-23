/**
 * 
 */

function restore_plan() {
	var i = 1;
	if(window.confirm("플랜을 공개하시겠습니까?")) i = 1;
	else i = 0;
	
	document.makePlanForm.action = "RestorePlan.jsp?p_public="+i;
	document.makePlanForm.submit();
}

function editPlan(rownum) {
	console.log(rownum);
	var i = 1;
	if(window.confirm("플랜을 공개하시겠습니까?")) i = 1;
	else i = 0;
	
	document.editPlanForm.action = "EditPlan_Ok.jsp?p_rownum="+rownum+"&p_public="+i;
	document.editPlanForm.submit();
}