/* count 쿠키 세팅  
	count는 day당 하나씩 부여 됨 <div class="day_plan"> 개수 만큼
	예를 들어 1박 2일 이면 2일치의 일정을 짜니까
	count는 count1, count2의 두개의 쿠키가 생성됨
	각 쿠키는 해당 일자의 일정 횟수를 센다
*/
function setCount(i) {
	document.cookie = "count"+i+"=1";
}
function getCount(i) {
	// count 쿠키의 값 반환
	var count = getCookie("count"+i);		
	return count;
}
// 쿠키의 value 값을 가져옴
function getCookie(name) {
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return value? value[2] : null;
}

/* 일정 더하기 버튼을 눌렀을 때 해당 버튼을 구분할 class를 받아오기 위한 변수  */
var btnClass;

// + 버튼을 눌렀을 때 spot list를 modal로 띄움
function getSpotList(btn){
	var url = "SpotList.jsp"
	// 누른 버튼 객체를 대입한 후, 해당 객체를 구분하는 클래스를 받아 옴
	btnClass = btn.classList;
	// 두번째 클래스 받아 옴
	btnClass = btnClass[1];
	console.log(btnClass);
	
	$('.modal_detail').load(url, function(){
    	$('.black').removeClass('hidden');
    });
}


// makeplan 페이지 재시작 시 count 쿠키가 있다면 삭제
window.onload = function(){
	var i = 1;
	while(true){
		// count i번째 쿠키가 존재한다면 해당 쿠키의 유효기간을 설정해 삭제
		// js는 쿠키 삭제 메소드가 따로 존재하지 않음
		if(getCount(i) != null) {
			document.cookie = "count"+i+"=0; max-age=0";
			i++;
		}else {break;}
	}
}


function setSpot(t) {
	/* get spot data */
	var spot = {};
	spot = getSpot(t);
	console.log(spot);
	
	var button = document.querySelector("."+btnClass);
	/* 몇 번째 날인지 */
	var i = btnClass.substring(7);
	
	/* plan no -> cookie로 count생성 */
	if(getCount(i) == null) setCount(i);
	var cnt = getCount(i);
	
	/* plan 요소 추가 - 요소 구성은 git 참고 */
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
	/* plan Main */
	var planMain = document.createElement("div");
	planMain.classList.add("plan_main");
	/* 플랜에 들어갈 spot detail */
	var sname = document.createTextNode(spot.name);
	var stype = document.createTextNode(spot.type);
	var sloc = document.createTextNode(spot.loc);
	var splan = document.createTextNode("일정"+cnt);
	var re_text = document.createTextNode("X");
	/* plan Main에 들어갈 p */
	// 일정
	var p = document.createElement("p");
	/* 일정 내용 */
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


/* 추가한 일정을 삭제하는 메소드 */
// re는 x 버튼
function removePlan(re) {
	/* plan_main */
	var plan = re.parentNode;
	// no는 일정의 번호
	var p_no = plan.previousSibling.children[1];
	var no = p_no.innerText;
	// int가 제대로 인식이 안 될때가 있어서 파싱
	no = Number(no);
	/* plan_list */
	var parent = plan.parentNode;
	
//	삭제 하려는 플랜의 다음 플랜이(형제가) 있는 경우
	if(parent.nextSibling != null) {
		var next = parent.nextSibling;
		// 형제가 (일정 추가하기 버튼이 아니고) 플랜이라면 no 수정
		if(next.classList.contains("plan_list")) {
			next.children[0].children[1].innerHTML = no;
			next.children[1].children[0].innerHTML = "plan"+no;
			next.children[1].children[1].setAttribute("value", no);			
			no++;
			
			// next가 형제가 있고, 마찬가지로 플랜이라면 no 수정
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
	
	// 플랜 번호 수정 후 해당 day의 플랜 개수를 세는 count 쿠키 수정
	var i = plan.children[1].getAttribute("name").substring(4);
	console.log(i);
	i = Number(i);
	var cnt = getCount(i);
	cnt = Number(cnt);
	cnt--;
	document.cookie = "count"+i+"="+cnt;
	
	parent.remove();
}


function getSpot(t) {
	/* get data */
	/* children은 t내부의 태그 요소의 집합 */
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