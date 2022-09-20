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
		// 요소 생성
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