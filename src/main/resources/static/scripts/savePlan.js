/*
* 플랜 저장 유효성 체크 메서드
* 
* 유효성 체크 후 플랜 인포 저장 메서드 호출
* */
function planCheck() {
	// 유효성 검사
	let day = 0;
	while(true){
		const dayPlan = document.getElementById("day_plan" + (day + 1));
		if(dayPlan != null) day++;
		else break;
	}

	for(var i = 1; i <= day; i++){
		// tripday에 플랜이 하나도 없으면 alert 띄움
		const plan = document.getElementById("plan_list"+i+"_1");
		if(plan == null){
			alert("day" + i + "의 계획을 작성해 주세요.");
			return;
		}
	}

	const url = window.document.location.href;
	if(url.includes("rownum") && !url.includes("pop")) {
		const rownum = url.substring(url.indexOf("=") + 1).substring(0);
		return editPlan(rownum);
	} else {
		savePlanInfo();
	}
}

/*
 * makePlan, copyPlan 페이지의
 * 플랜 인포 객체 controller로 보내는 메서드
 */
function savePlanInfo() {
	let p;
	// 플랜 저장 시 공개 여부 설정
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;

	const xhr = new XMLHttpRequest();

	const planInfoDTO = {
		"memberNickName": planDetail.m_nickname.value,
		"planTitle": titleValue,
		"planFirstDate": new Date(firstValue),
		"planLastDate": new Date(lastValue),
		"tagNameList": taglistValue,
		"planPublic": p
	}

	xhr.open('POST', '/new/planinfo', true);
	xhr.responseType = "json";
	xhr.setRequestHeader('Content-type', 'application/json');

	xhr.onreadystatechange = () => { // Call a function when the state changes.
		if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
			//console.log("통신 성공 info");
			savePlanDetail();
		}
	}
	
	xhr.send(JSON.stringify(planInfoDTO));
}

/*
 * makePlan, copyPlan 페이지의
 * 플랜 디테일 객체 controller로 보내는 메서드
 * 플랜 디테일 페이지로 매핑 필요
 */
function savePlanDetail() {

	let planDetailDTOList = [];

	let date1 = new Date(firstValue);
	let date2 = new Date(lastValue);
	let tripDays = (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1;

	let seq = 1;
	for (let i = 1; i <= tripDays; i++) {
		while (document.getElementById("p_seq" + i + "_" + seq) != null) {

			let tripDate = new Date(firstValue);
			if(i > 1) tripDate.setDate(tripDate.getDate() + (i - 1));

			const planDetailDTO = {
				"planTripDay": i,
				"planTripDate":tripDate,
				"planSequence": seq,
				"spotSerialNumber": document.getElementById("s_snum" + i + "_"  + seq).value,
				"planSpotName": document.getElementById("s_name" + i + "_"  + seq).value
			}
			planDetailDTOList.push(planDetailDTO);
			seq++;
		}
		seq = 1;
	}
	const xhr = new XMLHttpRequest();
	xhr.open('POST', '/new/plandetail', true);
	xhr.responseType = "json";
	xhr.setRequestHeader('Content-type', 'application/json');

	xhr.onreadystatechange = () => { // Call a function when the state changes.
		if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
			//console.log("통신 성공 detail");
		} else if (xhr === 201) {
			//const rowNum = xhr.response;
			//planDetail.action = "";
		}
	}

	xhr.send(JSON.stringify(planDetailDTOList));
}

/*
 * editPlan, copyPlan 페이지의 플랜 작성 결과 editPlanOk으로 보내는 메서드
 */
function editPlan(rownum) {
	let p;
	if(window.confirm("플랜을 공개하시겠습니까?")) p = 1;
	else p = 0;
	
	// editPlan_ok로 이동
	planDetail.action = "EditPlanOk.jsp?p_rownum=" + rownum + "&p_public=" + p;
	planDetail.submit();
}

