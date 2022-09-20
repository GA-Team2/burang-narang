// 사이드 바 이동
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


var btnClass;

// + 버튼을 눌렀을 때 spot list를 modal로 띄움
function getSpotList(btn){
	var url = "SpotList.jsp"
	// 누른 버튼 객체를 대입
	btnClass = btn.classList;
	btnClass = btnClass[1];
	console.log(btnClass);
	
	$('.modal_detail').load(url, function(){
    	$('.black').removeClass('hidden');
    });
}

// spot list 추가 취소
function cancle() {
    $('.black').addClass('hidden');
}
// 플랜 작성 취소
function plan_cancle() {	
	document.querySelector(".plan_info").classList.add('hidden');
	history.go(-1);
}
// plan info 저장
function make_plan() {
	var title = document.querySelector("input[name='title']").value;
	var first = document.querySelector("input[name='firstdate']").value;
	var last = document.querySelector("input[name='lastdate']").value;
	document.querySelector("input[name='p_title']").setAttribute("value", title);
	document.querySelector("input[name='p_firstdate']").setAttribute("value", first);
	document.querySelector("input[name='p_lastdate']").setAttribute("value", last);
	
	// 제목 저장
	document.querySelector(".plan_sub").innerHTML = title;
	
	// 작성 갱신 되면서 day tab 계산
	// new date를 이용해 문자열을 날짜형 포맷으로 변경
	var firstdate = new Date(first);
	var lastdate = new Date(last);
	var day = lastdate - firstdate;
	var currday = 24 * 60 * 60 * 1000;
	day = parseInt(day/currday)+1;
	console.log(day);
	
    var tab_con = document.querySelector(".day_plan_tab");
	for (var i = 1; i <= day; i++) {
		var tab = document.createElement("li");
		tab.innerHTML = "day"+i;
		if(i == 1) tab.classList.add("active_day");
		tab_con.appendChild(tab);
    }
	
	// 스크롤 확인
	var blank = document.createElement("div");
	blank.classList.add("blank");
	
	for (var i = 1; i <= day; i++) {
		var day_plan = document.createElement("div");
		day_plan.classList.add("day_plan");
		day_plan.classList.add("day_plan"+i);
		var plan_day = document.createElement("div");
		plan_day.classList.add("plan_day");
		var in_day = document.createElement("input");
		in_day.setAttribute("type","text");
		in_day.setAttribute("hidden", "hidden");
		var in_btn = document.createElement("input");
		in_btn.setAttribute("type","button");
		in_btn.setAttribute("onclick","getSpotList(this)");	
		in_btn.classList.add("plan_btn");
		in_btn.classList.add("btn_day"+i);
		in_btn.setAttribute("value", "+");
		
		plan_day.innerHTML = "day"+i;
		in_day.setAttribute("name", "day"+i);
		in_day.setAttribute("value", i);
		day_plan.appendChild(plan_day);
		day_plan.appendChild(in_day);
		day_plan.appendChild(in_btn);
		
		document.querySelector(".day_plan_con").appendChild(day_plan);
		document.querySelector(".day_plan_con").appendChild(blank);
    }

	console.log(firstdate);
	// 모달 끔
	$('.plan_info').addClass('hidden');
}

// count 쿠키는 플랜의 개수를 세는 변수
// makeplan 페이지 재시작 시 count 쿠키가 있다면 삭제
window.onload = function(){
	var i = 1;
	while(true){
		if(getCount(i) != null) {
			document.cookie = "count"+i+"=0; max-age=0";
			i++;
		}else {break;}
	}
}

// count 쿠키 세팅
function setCount(i) {
	document.cookie = "count"+i+"=1";
}
function getCount(i) {
	var count = getCookie("count"+i);		
	return count;
}
// 쿠키의 value 값을 가져옴
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
		move.children[1].children[1].setAttribute("value", no-1);
		prev.children[1].children[0].innerHTML = "plan"+no;
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
		
		move.children[1].children[0].innerHTML = "plan"+(no+1);
		move.children[1].children[1].setAttribute("value", no+1);
		next.children[1].children[0].innerHTML = "plan"+no;
		next.children[1].children[1].setAttribute("value", no);
		
		parent.insertBefore(next, move);
	}
}

function setSpot(t) {
	/* spot data */
	var spot = {};
	spot = getSpot(t);
	console.log(spot);
	
	var button = document.querySelector("."+btnClass);
	/* 몇 번째 날인지 */
	var i = btnClass.substring(7);
	
	/* plan no -> cookie로 count생성 */
	if(getCount(i) == null) setCount(i);
	var cnt = getCount(i);
	
	/* div.plan_list */
	var plan = document.createElement("div");
	plan.classList.add("plan_list");
	/* up-down button */
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
	/* plan Main detail */
	var planMain = document.createElement("div");
	planMain.classList.add("plan_main");
	/* 플랜에 들어갈 spot detail */
	var sname = document.createTextNode(spot.name);
	var stype = document.createTextNode(spot.type);
	var sloc = document.createTextNode(spot.loc);
	var splan = document.createTextNode("plan"+cnt);
	var re_text = document.createTextNode("X");
	/* plan Main에 들어갈 p */
	var p = document.createElement("p");
	var p1 = document.createElement("p");
	var p2 = document.createElement("p");
	var p3 = document.createElement("p");
	/* 삭제 버튼 */
	var re_plan = document.createElement("div");
	re_plan.classList.add("remove_plan");
	re_plan.setAttribute("onclick", "removePlan(this)");
	
	var in_pno = document.createElement("input");
	in_pno.setAttribute("type","text");
    in_pno.setAttribute("value", cnt);
    in_pno.setAttribute("name", "p_no"+i);
    in_pno.setAttribute("hidden", "hidden");

	var in_sn = document.createElement("input");
	in_sn.setAttribute("type","text");
    in_sn.setAttribute("value", spot.snum);
    in_sn.setAttribute("name", "s_snum"+i);
    in_sn.setAttribute("hidden", "hidden");
    
	var in_sname = document.createElement("input");
	in_sname.setAttribute("type","text");
    in_sname.setAttribute("value", spot.name);
    in_sname.setAttribute("name", "s_name"+i);
    in_sname.setAttribute("hidden", "hidden");
    
	var in_stype = document.createElement("input");
	in_stype.setAttribute("type","text");
    in_stype.setAttribute("value", spot.type);
    in_stype.setAttribute("name", "s_type"+i);
    in_stype.setAttribute("hidden", "hidden");
	
	var in_sloc = document.createElement("input");
	in_sloc.setAttribute("type","text");
    in_sloc.setAttribute("value", spot.loc);
    in_sloc.setAttribute("name", "s_loc"+i);
    in_sloc.setAttribute("hidden", "hidden");
	
	p.appendChild(splan);
	p1.appendChild(sname);
	p2.appendChild(stype);
	p3.appendChild(sloc);
	re_plan.appendChild(re_text);

	planMain.appendChild(p);
	planMain.appendChild(in_pno);
	planMain.appendChild(p1);
	planMain.appendChild(in_sn);
	planMain.appendChild(in_sname);
	planMain.appendChild(p2);
	planMain.appendChild(in_stype);
	planMain.appendChild(p3);
	planMain.appendChild(in_sloc);
	planMain.appendChild(re_plan);
	
	/* plan list 생성 */
	plan.appendChild(planMain);
	
	$('.black').addClass('hidden');

	var parent = document.querySelector(".day_plan"+i);
	parent.insertBefore(plan, button);
	
	cnt++;
	document.cookie = "count"+i+"="+cnt;
}

function removePlan(re) {
	/* plan_main */
	var plan = re.parentNode;
	var i = plan.children[1].name.substring(4);
	console.log(i);
	var p_no = plan.previousSibling.children[1];
	var no = p_no.innerText;
	no = Number(no);
	var parent = plan.parentNode;
	
//	삭제 하려는 플랜의 다음 플랜이 있는 경우
	if(parent.nextSibling != null) {
		var next = parent.nextSibling;
		if(next.classList.contains("plan_list")) {
			next.children[0].children[1].innerHTML = no;
			next.children[1].children[0].innerHTML = "plan"+no;
			next.children[1].children[1].setAttribute("value", no);			
			no++;
			
			while(next.nextSibling != null) {
				next = next.nextSibling;
				if(next.classList.contains("plan_list")) {
					next.children[0].children[1].innerHTML = no;
					next.children[1].children[0].innerHTML = "plan"+no;
					next.children[1].children[1].setAttribute("value", no);
					no++;
				}else break;
			}
		}
	}
	
	var cnt = getCount(i);
	cnt = Number(cnt);
	cnt--;
	document.cookie = "count"+i+"="+cnt;
	
	parent.remove();
}



function getSpot(t) {
	/* get data */
	var x = t.children[1];
	var snum = x.children[0].value;
	var sname = x.children[1].innerText;
	var stype = x.children[2].innerText;
	var sloc = x.children[3].innerText;
	var spot = {
		snum: snum,
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