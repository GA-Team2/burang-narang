$(document).ready(function () {
    
    // side x좌표 이동 
    $('.side_button').click(function () {
        // r 값 : 오른쪽에서 x 좌표 위치
        // 초기값 0
        var r = $('.side_bar').css('right');
        var w = '-' + $('.side_bar').css('width');
        console.log(w);


        if (r == '0px') {
            $('.side_bar').animate({ 'right': w }, 500);
            // 바뀐 좌표 재 대입
            r = $('.side_bar').css('right');
        } else {
            $('.side_bar').animate({ 'right': 0 }, 500);
            // 바뀐 좌표 재 대입
            r = $('.side_bar').css('right');
        }
    });
});

function callModal() {
        var url = "spotList.jsp";
        $('.modal_detail').load(url, function(){
            $('.black').removeClass('hidden');
        });

}

var button;

function getSpotList(btn){
	var url = "spotList.jsp"
	var modal = document.querySelector(".modal_detail");
	var black = document.querySelector(".black");
	button = btn;
		
	$('.modal_detail').load(url, function(){
            $('.black').removeClass('hidden');
        });
}

function cancle() {
    	// 쿠키가 저장 되면서 modal 종료가 되면 
    	// 쿠키가 있는지 없는지 확인 한 후
    	// list 갱신
        $('.black').addClass('hidden');
}

// 페이지 시작 시 쿠키가 있다면 삭제
window.onload = function(){
	document.cookie = "count=0; max-age=0";
}

function setCount() {
	document.cookie = "count=1";
}
		
function getCount() {
	var count = getCookie("count");		
	return count;
}

function getCookie(name) {
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
}

/* chang plan 순서 */
function goUp(t) {
	var move = t.parentNode.parentNode;
	var parent = move.parentNode;
	if(move.previousSibling != null) {
		var prev = move.previousSibling;
		var no = t.nextSibling.innerText;
		no = Number(no);
		prev.children[0].children[1].innerHTML = no;
		t.nextSibling.innerHTML = no-1;
		
		move.children[1].children[0].innerHTML = "plan"+(no-1);
		prev.children[1].children[0].innerHTML = "plan"+no;
		
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
		
		move.children[1].children[0].innerHTML = "plan"+(no+1);
		next.children[1].children[0].innerHTML = "plan"+no;
		
		parent.insertBefore(next, move);
	}
}

function setSpot(t) {
	/* spot data */
	var spot = {};
	spot = getSpot(t);
	console.log(spot);
	
	/* plan no -> cookie로 count생성 */
	if(getCount() == null) setCount();
	var cnt = getCount();
	
	/* div.plan_list */
	var plan = document.createElement("div");
	plan.classList.add("plan_list");

	var btn = document.createElement("div");
	btn.classList.add("up_down");
	var up = document.createElement("div");
	up.classList.add("up");
	up.setAttribute("onclick", "goUp(this)");
	var down = document.createElement("div");
	down.classList.add("down");
	down.setAttribute("onclick", "goDown(this)");	
	var planNo = document.createElement("div");
	planNo.classList.add("plan_no");
	var u = document.createTextNode("\u25B2");
	var d = document.createTextNode("\u25BC");
	var no = document.createTextNode(cnt);
	up.appendChild(u);
	down.appendChild(d);
	planNo.appendChild(no);
	btn.appendChild(up);
	btn.appendChild(planNo);
	btn.appendChild(down);
	plan.appendChild(btn);


	var planMain = document.createElement("div");
	planMain.classList.add("plan_main");
	var sname = document.createTextNode(spot.name);
	var stype = document.createTextNode(spot.type);
	var sloc = document.createTextNode(spot.loc);
	var splan = document.createTextNode("plan"+cnt);
	var p = document.createElement("p");
	var p1 = document.createElement("p");
	var p2 = document.createElement("p");
	var p3 = document.createElement("p");
	p.appendChild(splan);
	p1.appendChild(sname);
	p2.appendChild(stype);
	p3.appendChild(sloc);
	planMain.appendChild(p);
	planMain.appendChild(p1);
	planMain.appendChild(p2);
	planMain.appendChild(p3);
	plan.appendChild(planMain);
	
	$('.black').addClass('hidden');
	
	/*var next = document.querySelector(".plan_list:last-of-type");
	parent.appendChild(plan);*/
	var parent = document.querySelector(".day_plan");
	parent.insertBefore(plan, button);
	/*var plus = document.createElement("button");
	var plus_inner = document.createTextNode("+");
	plus.classList.add("plan_btn");
	plus.setAttribute("onclick","getSpotList(this)");
	plus.appendChild(plus_inner);
	
	if(plan.previousSibling ) parent.insertBefore(plus, plan);*/
	
	cnt++;
	document.cookie = "count="+cnt;
}

function getSpot(t) {
	/* get data */
	var x = t.children[1];
	var sname = x.children[0].innerText;
	var stype = x.children[1].innerText;
	var sloc = x.children[2].innerText;
	var spot = {
		name: sname,
		type: stype,
		loc: sloc
	};

	return spot;
}


// tab 변경
/*
$(document).ready(function () {
    $('.day_plan_tab').click(function () {
        $('.day_plan_tab').addClass('active_tab');
        $('.day_plan_con').addClass('active');

        $('.search_spot_tab').removeClass('active_tab');
        $('.search_con').removeClass('active');
    });
    $('.search_spot_tab').click(function () {
        $('.search_spot_tab').addClass('active_tab');
        $('.search_con').addClass('active');

        $('.day_plan_tab').removeClass('active_tab');
        $('.day_plan_con').removeClass('active');
    })
});
*/