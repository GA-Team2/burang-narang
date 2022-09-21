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