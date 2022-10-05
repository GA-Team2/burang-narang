// plan info 저장
function make_plan() {
	var title = document.querySelector("input[name='title']").value;
	var first = document.querySelector("input[name='firstdate']").value;
	var last = document.querySelector("input[name='lastdate']").value;
	var taglist = document.querySelector("input[name='taglist']").value;
	
	document.querySelector("input[name='p_title']").setAttribute("value", title);
	document.querySelector("input[name='p_firstdate']").setAttribute("value", first);
	document.querySelector("input[name='p_lastdate']").setAttribute("value", last);
	document.querySelector("input[name='t_namelist']").setAttribute("value", taglist);
	
	// 제목 저장
	document.querySelector(".plan_sub").children[0].innerHTML = title;
	
	
	// 작성 갱신 되면서 day tab 계산
	// new date를 이용해 문자열을 날짜형 포맷으로 변경
	var firstdate = new Date(first);
	var lastdate = new Date(last);
	var day = lastdate - firstdate;
	var currday = 24 * 60 * 60 * 1000;
	day = parseInt(day/currday)+1;
	
	// 날짜 탭 요소 생성
    var tab_con = document.querySelector(".day_plan_tab");
	for (var i = 1; i <= day; i++) {
		var tab = document.createElement("li");
		/* tab 클릭 시 해당 탭의 날짜의 플랜으로 스크롤 -> side.js */
		tab.setAttribute("onclick", "tabScroll(this)");
		tab.setAttribute("id", "day"+i);		
		tab.innerHTML = "Day"+i;
		if(i == 1) tab.classList.add("active_day");
		tab_con.appendChild(tab);
    }
	
	// 스크롤 용 여백 
	var blank = document.createElement("div");
	blank.classList.add("blank");
	
	// 각 날짜 별 plan 추가되는 공간 요소 생성
	for (var i = 1; i <= day; i++) {
		var day_plan = document.createElement("div");
		day_plan.classList.add("day_plan");
		day_plan.classList.add("day_plan"+i);
		
		var plan_day = "<div class='plan_day'>Day"+i+"</div>"
		var in_day = "<input type='text' name='day"
						+i
						+"' value='"
						+i
						+"' hidden>"
		var in_btn = "<input type='button' onclick='getSpotList(this)'"
						+" class='plan_btn btn_day"
						+i
						+"' value='+'>"
						
		day_plan.innerHTML = plan_day+in_day+in_btn;
		
		document.querySelector(".day_plan_con").appendChild(day_plan);
    }
	document.querySelector(".day_plan_con").appendChild(blank);

	// 모달 종료
	$('.modal_zone').addClass('modal_hidden');
}

// writeSimplePlan 유효성 검사
function writeCheck() {
  var title = true;
  var schedule = true;

  if (scheduleForm.title.value.length === 0) {
    document.getElementById("notitle").className = "";
    title = false;
  } else {
    document.getElementById("notitle").className = "hidden";
  }

  if (scheduleForm.firstdate.value.length === 0) {
    document.getElementById("noschedule").className = "";
    schedule = false;
  } else {
    document.getElementById("noschedule").className = "hidden";
  }

  if (title === false || schedule === false) {
    return;
  }

	make_plan();
}


// info를 수정하는 메서드
function editInfo(){
	// 모달 생성
	$('.modal_zone').removeClass('modal_hidden');
	var modal = document.querySelector(".modal_zone");
	if(modal.classList.contains("hidden")) modal.classList.remove("hidden");
	
	// onclick 메서드 수정 
	var add = document.querySelector(".modal_add");
	add.setAttribute("value", "수정");
	add.setAttribute("onclick", "editCheck()");
	
	var cancel = document.querySelector(".modal_cancel");
	cancel.setAttribute("value", "계속");
	cancel.setAttribute("onclick", "closeEdit()");
}

// editInfo 후 planinfo 수정 후 저장 누르면 발생하는 유효성 검사
function editCheck() {
	// 유효성 검사 - writecheck와 동일
	var title = true;
  	var schedule = true;

  	if (scheduleForm.title.value.length === 0) {
    	document.getElementById("notitle").className = "";
    	title = false;
  	} else {
    	document.getElementById("notitle").className = "hidden";
  	}

  	if (scheduleForm.firstdate.value.length === 0) {
    	document.getElementById("noschedule").className = "";
    	schedule = false;
  	} else {
    	document.getElementById("noschedule").className = "hidden";
  	}

  	if (title === false || schedule === false) {
    	return;
  	}

	var edit_title = document.querySelector("input[name='title']").value;
	var p_title = document.querySelector("input[name='p_title']").value;
	var taglist = document.querySelector("input[name='taglist']").value;
	var p_taglist = document.querySelector("input[name='t_namelist']").value;

	var first = document.querySelector("input[name='firstdate']").value;
	var p_first = document.querySelector("input[name='p_firstdate']").value;
	var last = document.querySelector("input[name='lastdate']").value;
	var p_last = document.querySelector("input[name='p_lastdate']").value;
	
	// 제목 갱신
	if(edit_title != p_title){
		document.querySelector("input[name='p_title']").setAttribute("value", edit_title);
		document.querySelector(".plan_sub").children[0].innerHTML = edit_title;
	}
		
	// 태그 리스트 갱신
	if(taglist != p_taglist) document.querySelector("input[name='t_namelist']").setAttribute("value", taglist);
	
	// 날짜가 변경되었다면 editplan 실행
	var i = 1;
	if(first != p_first || last != p_last){
		if(window.confirm("날짜를 수정하시겠습니까?\n수정하시면 작성된 플랜은 삭제됩니다.")) i = 1;
		else i = 0;
		edit_plan(i);
		clearPlace();
	} else $('.modal_zone').addClass('modal_hidden');
}

// plan info의 날짜가 변경되었다면 실행되는 메서드 
function edit_plan(i) {
	if(i == 1){
		//info 수정
		//detail 전체 삭제
		var tab_con = document.querySelector(".day_plan_tab");
		var i = tab_con.children.length;
        for(var j=0; j<i; j++){
            tab_con.children[0].remove();
        }
		var plan_con = document.querySelector(".day_plan_con");
		var x = plan_con.children.length;
        for(var j=0; j<x; j++){
            plan_con.children[0].remove();
        }
		// seq cookie 재 시작 
		var seq = 1;
		while(true){
			// 쿠키 리셋
			if(getCount(seq) != null) {
				document.cookie = "count"+seq+"=0; max-age=0";
				seq++;
			}else {break;}
		}
		var con = document.forms.makePlanForm;
		// edit 폼인 경우 폼 변경
		if(con == null) con=document.forms.editPlanForm;
		// scroll reset
		con.scrollTop = 0;
		make_plan();
		}
}

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
