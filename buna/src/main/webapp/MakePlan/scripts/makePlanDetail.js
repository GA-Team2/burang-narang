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
	var up_down = "<div class='up_down'>"
             				+"<div class='up' onclick='goUp(this)'>&#9650;</div>"
                            +"<div class='plan_no'>"+cnt+"</div>"
                            +"<div class='down' onclick='goDown(this)'>&#9660;</div>"
             			+"</div>";

	/* plan main */
	var plan_main = "<div class='plan_main'>"
             				+"<div>img 넣을 예정</div>"
             				+"<p>일정"+cnt+"</p>"
             				+"<input type='text' value='"
											+cnt
											+"' name='p_no"
											+i
											+"' hidden>"
                        	+"<p>"+spot.name+"</p>"
             				+"<input type='text' value='"
										+spot.snum
										+"' name='s_snum"
										+i
										+"' hidden>"
             				+"<input type='text' value='"
										+spot.name
										+"' name='s_name"
										+i
										+"' hidden>"
                        	+"<p>"+spot.type+"</p>"
             				+"<input type='text' value='"
										+spot.type
										+"' name='s_type"
										+i
										+"' hidden>"
                        	+"<p>"+spot.loc+"</p>"
             				+"<input type='text' value='"+spot.loc+"' name='s_loc"+i+"' hidden>"
                       		+"<div class='remove_plan' onclick='removePlan(this)'>X</div>"
             			+"</div>";
	
	plan.innerHTML = up_down+plan_main;
	
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
			next.children[1].children[1].innerHTML = "일정"+no;
			next.children[1].children[2].setAttribute("value", no);			
			no++;
			
			// next가 형제가 있고, 마찬가지로 플랜이라면 no 수정
			while(next.nextSibling != null) {
				next = next.nextSibling;
				if(next.classList.contains("plan_list")) {
					next.children[0].children[1].innerHTML = no;
					next.children[1].children[1].innerHTML = "일정"+no;
					next.children[1].children[2].setAttribute("value", no);
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