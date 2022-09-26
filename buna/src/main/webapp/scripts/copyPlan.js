window.onload = function(){
	var add = document.querySelector(".modal_add");
	add.setAttribute("value", "추가");
	add.setAttribute("onclick", "writeCheck()");
	
	var cancel = document.querySelector(".modal_cancel");
	cancel.setAttribute("value", "취소");
	// 현재 페이지 주소
	var url = window.document.location.href;
	var rownum = url.substring(url.indexOf("=")+1);
	// plan detail.jsp
	cancel.setAttribute("onclick", "location.href='planDetail.jsp?rownum="+rownum+"'");
	
	// schedule에 세팅
	var form = document.scheduleForm;
	var title = document.editPlanForm.p_title.value;
	var firstdate = document.editPlanForm.p_firstdate.value;
	var lastdate = document.editPlanForm.p_lastdate.value;
	var tname = document.editPlanForm.t_namelist.value;
	
	form.title.value= title;
	form.firstdate.value = firstdate;
	form.lastdate.value = lastdate;
	form.tag_value = tname;
	
	var tagArea = document.getElementById("tag_area");
	var tag = tname.split(" ");
	console.log(tag);
	
	// 공백 하나 더 인식 되서 length-1
	for(var j=0; j<tag.length-1; j++){
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
	
	// 제목 수정
	var context = document.querySelector(".modal_context");
	context.children[0].innerHTML = "플랜 수정";
}