/* chang plan
* plan 의 순서를 변경하는 메소드
*/
function moveUpPlan(up) {
	var thisPlan = up.parentNode.parentNode;

	/* tday = tripday seq = 플랜 순서 */
	var tday = getTday(thisPlan);
	var seq = getSeq(thisPlan);
	
	// parent = day_plan
	var parent = thisPlan.parentNode;
	
	if(document.getElementById("p_list" + tday + "_" + (seq - 1)) != null) {
		// move와 바꿀 이전 노드
		var prev = document.getElementById("p_list" + tday + "_" + (seq-1));
		changePlanSeq(prev, tday, seq);
		changePlanSeq(thisPlan, tday,seq-1);
		
		parent.insertBefore(thisPlan, prev);
		movePlace(seq, tday, true);
	}
}
function moveDownPlan(down) {
	var thisPlan = down.parentNode.parentNode;

	/* tday = tripday seq = 플랜 순서 */
	var tday = getTday(thisPlan);
	var seq = getSeq(thisPlan);
	
	var parent = thisPlan.parentNode;
	
	if(document.getElementById("p_list" + tday + "_" + (seq + 1)) != null) {
		var next = document.getElementById("p_list" + tday + "_" + (seq + 1));
		changePlanSeq(next, tday, seq);
		changePlanSeq(thisPlan, tday,seq+1);
		
		parent.insertBefore(next, thisPlan);
		movePlace(seq, tday, false);
	}
}

function changePlanSeq(plan, tday, seq) {
	plan.children[0].children[1].innerHTML = seq;
	plan.children[1].children[1].innerHTML = "일정" + seq;
	plan.children[1].children[2].setAttribute("value", seq);
	plan.setAttribute("id", "p_list" + tday + "_" + seq);
}

function getTday(thisPlan) {
	var id = thisPlan.getAttribute("id");
	var tday = Number(id.substring(6, id.indexOf("_", 2)));
	return tday;
}

function getSeq(thisPlan) {
	var id = thisPlan.getAttribute("id");
	var seq = Number(id.substring(id.indexOf("_", 2) + 1));
	return seq;
}