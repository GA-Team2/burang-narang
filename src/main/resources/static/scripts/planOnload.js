/*
* makePlan, editPlan, copyPlan 페이지 로드 시 day 쿠키 리셋 및 세팅
* */
window.onload = function () {
	/* trip day 쿠키 초기화 */
	resetDay();
	/*
	* 하나 이상의 날짜가 존재 시
	* editPlan과 copyPlan이므로, 페이지에 맞춰 쿠키 세팅 및 페이지 요소 수정
	* */
	if(document.getElementById("day_plan1") != null) {
		console.log("기존 플랜 존재");
		setDays();
		setPlaces();
		editScheduleForm();
	} else return;
};

/*
* editPlan, copyPlan의 경우 writeSimplePlan 수정
* */
function editScheduleForm() {

	title.value = p_title.value;
	firstDate.value = p_firstdate.value;
	lastDate.value = p_lastdate.value;
	tagList.value = t_namelist.value;
	setTagList();

	const url = window.document.location.href;
	const rownum = url.substring(url.indexOf("=") + 1).substring(0);
	let pop = null;
	if(url.includes("pop")) pop = url.substring(url.indexOf("pop=")).substring(4);
	/* pop이 null이 아니면 copyPlan */
	infoBtn.name = "edit";
	if(pop == null) {
		const scheduleTitle = planInfo.children[0].children[0];
		scheduleTitle.innerHTML = "플랜 수정";

		infoBtn.setAttribute("value", "수정");

		cancelBtn.setAttribute("value", "취소");

		cancelBtn.setAttribute("onclick","location.href='PlanDetail.jsp?rownum=" + rownum + "'");
	} else cancelBtn.setAttribute("onclick", "location.href='PlanDetail.jsp?rownum=" + rownum + "&pop=" + pop + "'");
}

/*
* writeSimplePlan에 tag 세팅
* */
function setTagList() {
	// tag 세팅
	const tagArea = document.getElementById("tag_area");
	const tagArr = tagList.value.split(" ");

	// 공백 하나 더 인식 되서 length-1
	for (let j = 0; j < tagArr.length - 1; j++) {
		const addTag = document.createElement("span");
		const tagId = tagArr[j] + "_in";

		addTag.id = tagId;
		addTag.className = "highlight";
		addTag.innerText = tagArr[j];
		addTag.onclick = function () {
			removeTag(tagId);
		};

		tagArea.appendChild(addTag);
	}
}


/*
* 여행 일자와 플랜에 맞춰 장소 노드 생성
* */
function setPlaces() {
	let tday = 0;
	let seq = [];

	while(getDay(tday+1) != null) {
		seq[tday] = getDay(tday+1) - 1;
		tday++;
	}

	// 각 tripday의 sequence의 spot 정보 받아와 지도에 세팅
	for (let i = 1; i <= tday; i++) {
		for (let j = 1; j <= seq[i - 1]; j++) {
			const name = document.getElementById("s_name" + i + "_" + j).value;
			const loc = document.getElementById("s_loc" + i + "_" + j).value;
			const pnum = document.getElementById("s_pnum" + i + "_" + j).value;
			// 지도에 세팅
			//placeSearch(loc + " " + name + " " + pnum, i);

			// 전체 여행일
			/*let totalTripDay = 1;
			while(document.getElementById("day" + (totalTripDay + 1))) {
				totalTripDay++;
			}

			initSpotSequence(totalTripDay);

			let planList = [];

			for (let j = 1; j <= totalTripDay; j++) {
				let i = 1;
				while (document.getElementById("plan_list" + j + "_" + i)) {
					planList.push(document.getElementById("plan_list" + j + "_" + i));
					i++;
				}
			}*/

			/*spots.forEach(spot => setSpotSequence(spot.tripDay, spot.tripSequence));

			(async () => {
				try {
					for (let spot of spots) {
						const result = await addressSearch(spot.spotLocation);
						setMapSpot(result, spot.tripDay, spot.tripSequence);
					}
				} catch (e) {
					console.log(e);
				}
			})();*/
		}
	}
}