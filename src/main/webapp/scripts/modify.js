/* chang plan
* plan 의 순서를 변경하는 메소드
*/
function goUp(t) {
	// move = plan_list
	var move = t.parentNode.parentNode;
	/* tday = tripday seq = 플랜 순서 */
	var tday = move.getAttribute("id");
	tday = tday.substring(6, tday.indexOf("_", 2));
	tday = Number(tday);
	var seq = move.getAttribute("id");
	seq = seq.substring(seq.indexOf("_", 2) + 1);
	seq = Number(seq);
	
	// parent = day_plan
	var parent = move.parentNode;
	
	if(document.getElementById("p_list" + tday + "_" + (seq - 1)) != null) {
		// move와 바꿀 이전 노드
		var prev = document.getElementById("p_list" + tday + "_" + (seq-1));
		
		prev.children[0].children[1].innerHTML = seq;
		move.children[0].children[1].innerHTML = seq - 1;
		
		move.children[1].children[1].innerHTML = "일정" + (seq - 1);	
		move.children[1].children[2].setAttribute("value", seq - 1);
		prev.children[1].children[1].innerHTML = "일정" + seq;
		prev.children[1].children[2].setAttribute("value", seq);
		
		move.setAttribute("id", "p_list" + tday + "_" + (seq - 1));
		prev.setAttribute("id", "p_list" + tday + "_" + seq);
		
		parent.insertBefore(move, prev);
	}
	
	movePlace(seq, tday, true);
}
function goDown(t) {
	var move = t.parentNode.parentNode;
	/* tday = tripday seq = 플랜 순서 */
	var tday = move.getAttribute("id");
	tday = tday.substring(6, tday.indexOf("_", 2));
	tday = Number(tday);
	var seq = move.getAttribute("id");
	seq = seq.substring(seq.indexOf("_", 2) + 1);
	seq = Number(seq);
	
	var parent = move.parentNode;
	
	if(document.getElementById("p_list" + tday + "_" + (seq + 1)) != null) {
		var next = document.getElementById("p_list" + tday + "_" + (seq + 1));
		
		next.children[0].children[1].innerHTML = seq;
		move.children[0].children[1].innerHTML = seq + 1;
		
		move.children[1].children[1].innerHTML = "일정" + (seq + 1);
		move.children[1].children[2].setAttribute("value", seq + 1);
		next.children[1].children[1].innerHTML = "일정" + seq;
		next.children[1].children[2].setAttribute("value", seq);
		
		move.setAttribute("id", "p_list" + tday + "_" + (seq + 1));
		next.setAttribute("id", "p_list" + tday + "_" + seq);
		
		parent.insertBefore(next, move);
	}
	
	movePlace(seq, tday, false);
}