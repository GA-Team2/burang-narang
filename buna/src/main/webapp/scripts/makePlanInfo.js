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
		// 요소 생성
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
		document.querySelector(".day_plan_con").appendChild(blank);
    }

	// 모달 끔
	$('.modal_zone').addClass('hidden');
}


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