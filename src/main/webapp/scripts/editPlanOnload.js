// editPlan 시작 시 plan_sequence 받아옴
/* window.onload는 마지막에 import된 js 파일의 것만 실행하므로 주의 */
window.onload = function () {
	// tday = tripday
  	var tday = 1;
  	while (true) {
    	// 플랜 쿠키 존재 시 삭제
    	if (getCount(tday) != null) {
      	document.cookie = "count" + tday + "=0; max-age=0";
      	tday++;
    	} else break;
  	}
  	tday = 1;
	// 플랜 쿠키 삭제 후 수정하려는 플랜의 tripday와 plansequence에 맞춰 쿠키 생성
  	while (document.querySelector(".day_plan" + tday) != null) {
    	var day = document.querySelector(".day_plan" + tday);
    	var count = 1;
		
		// day의 children은 plan_list planlist의 개수 만큼 쿠키 세팅
		// day의 children[0]과 [1]은 planlist가 아니므로 j=2부터 시작 
    	for (var j = 2; j < day.children.length; j++) {
			// day의 자식에는 더하기 버튼도 있으므로 tagname="DIV"로 요소 구분
      		var child = day.children[j].tagName;
      		if (child == "DIV") count++;
    	}
		// count = sequence +1 
        document.cookie = "count" + tday + "=" + count;
    	tday++;
  	}

  	// writeSimplePlan.jsp를 editPlan.jsp에 맞춰 수정
  	var context = document.querySelector(".modal_context");
  	context.children[0].innerHTML = "플랜 수정";
  	var add = document.querySelector(".modal_add");
  	add.setAttribute("value", "수정");

  	var cancel = document.querySelector(".modal_cancel");
  	cancel.setAttribute("value", "취소");
  	var url = window.document.location.href;
  	var rownum = url.substring(url.indexOf("=") + 1);
  	rownum = rownum.substring(0, 1);

  	// 플랜 수정 취소 시 plan detail.jsp로 이동
	cancel.setAttribute("onclick","location.href='planDetail.jsp?rownum=" + rownum + "'");

  	// popularCopyPlan.jsp 이면  => pop가 존재
  	var and = url.substring(url.indexOf("pop="));
  	and = and.substring(and.indexOf("=") + 1);
  	if (and != null) {
    	if (and == "true") {
			// writeSimplePlan 수정
    		context.children[0].innerHTML = "새 플랜 작성";
      		add.setAttribute("value", "추가");
			// edit인지 make인지 copy인지 구분하기 위함
			add.setAttribute("id", "copy");
      		cancel.setAttribute("onclick", "location.href='planDetail.jsp?rownum=" + rownum + "&pop=" + and + "'");
    	}
  	}

  	// writeSimplePlan에 세팅
  	var form = document.scheduleForm;
  	var title = document.editPlanForm.p_title.value;
  	var firstdate = document.editPlanForm.p_firstdate.value;
  	var lastdate = document.editPlanForm.p_lastdate.value;
  	var tname = document.editPlanForm.t_namelist.value;

  	form.title.value = title;
  	form.firstdate.value = firstdate;
  	form.lastdate.value = lastdate;
  	form.tag_value = tname;

	// tag 세팅
  	var tagArea = document.getElementById("tag_area");
  	var tag = tname.split(" ");

  	// 공백 하나 더 인식 되서 length-1
  	for (var j = 0; j < tag.length - 1; j++) {
		var addTag = document.createElement("span");
    	var tagId = tag[j] + "_in";
    	document.getElementById("tag_value").value += tag[j] + " ";
    	addTag.id = tagId;
    	addTag.className = "highlight";
    	addTag.innerText = tag[j];
    	addTag.onclick = function () {
      		removeTag(tagId);
    	};
    	tagArea.appendChild(addTag);
  	}

  	// tripday 위의 tday와 구분
  	var day = 0;
  	while (true) {
    	var day_plan = document.querySelector(".day_plan" + (day + 1));
    	if (day_plan != null) day++;
    	else break;
  	}

  	// sequence 초기화
  	var seq = [];
  	for (var i = 0; i < day; i++) {
    	seq[i] = 0;
  	}

  	for (var i = 0; i < day; i++) {
    	// day = i + 1
    	while (true) {
      		var plan_seq = document.getElementById("p_list" + (i + 1) + "_" + (seq[i] + 1));
      		if (plan_seq != null) seq[i] += 1;
      		else break;
    	}
  	}

	// 각 tripday의 sequence의 spot 정보 받아와 지도에 세팅
  	for (var i = 1; i <= day; i++) {
    	for (var j = 1; j <= seq[i - 1]; j++) {
      		var name = document.getElementById("s_name" + i + "_" + j).value;
      		var loc = document.getElementById("s_loc" + i + "_" + j).value;
      		var pnum = document.getElementById("s_pnum" + i + "_" + j).value;
			// 지도에 세팅
      		placeSearch(loc + " " + name + " " + pnum, i);
    	}
  	}
};