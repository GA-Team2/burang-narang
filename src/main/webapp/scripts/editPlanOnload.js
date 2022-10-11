// editPlan 시작 시 plan_sequence 받아옴
/* window.onload는 마지막에 import된 js 파일의 것만 실행하므로 주의 */
// push test
window.onload = function () {
	/* trip day 쿠키 초기화 */
	resetDay();
	setDays();


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
  	title.value = p_title.value;
  	firstDate.value = p_firstdate.value;
  	lastDate.value = p_lastdate.value;
  	tagList.value = t_namelist.value;

	// tag 세팅
  	var tagArea = document.getElementById("tag_area");
  	var tag = tagList.value.split(" ");

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