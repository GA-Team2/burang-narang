/* chang plan
	plan 의 순서를 변경하는 메소드
*/
function goUp(t) {
	var move = t.parentNode.parentNode;
	var parent = move.parentNode;
	if(move.previousSibling != null) {
		var prev = move.previousSibling;
		var no = t.nextSibling.innerText;
		no = Number(no);
		prev.children[0].children[1].innerHTML = no;
		t.nextSibling.innerHTML = no-1;
		
		move.children[1].children[0].innerHTML = "일정"+(no-1);
		move.children[1].children[1].setAttribute("value", no-1);
		prev.children[1].children[0].innerHTML = "일정"+no;
		prev.children[1].children[1].setAttribute("value", no);
		
		parent.insertBefore(move, prev);
	}
}
function goDown(t) {
	var move = t.parentNode.parentNode;
	var parent = move.parentNode;
	if(move.nextSibling != null) {
		var next = move.nextSibling;
		var no = t.previousSibling.innerText;
		no = Number(no);
		next.children[0].children[1].innerHTML = no;
		t.previousSibling.innerHTML = no+1;
		
		move.children[1].children[0].innerHTML = "일정"+(no+1);
		move.children[1].children[1].setAttribute("value", no+1);
		next.children[1].children[0].innerHTML = "일정"+no;
		next.children[1].children[1].setAttribute("value", no);
		
		parent.insertBefore(next, move);
	}
}