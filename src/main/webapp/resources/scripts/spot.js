const spotArea = document.getElementById("spot_area");
const trafficTab = document.getElementById('tf_tab');
const accommodationTab = document.getElementById('ac_tab');
const restaurantTab = document.getElementById('re_tab');
const eventTab = document.getElementById('ev_tab');
const spotList = document.getElementById("spot_list");

/*
* spot 컨테이터 내부에 띄울 spot 정보를 ajax로 가져오는 메서드
* 
* @param kindOfSpot 어떤 장소 데이터를 가져올지 지정해주는 변수
* */
function getSpotList(kindOfSpot){

	const xhr = new XMLHttpRequest();
	xhr.open("GET", "/new/spot?kindOfSpot=" + kindOfSpot);
	/* 정의된 서버에 요청을 전송 */
	xhr.send();

	xhr.onload = () => {
		if (xhr.status === 200) {
			const spotDataList = JSON.parse(xhr.response);

			loadSpotList(spotDataList);
			resetSpotTab();
			loadSpotTab(kindOfSpot);
		}
		else console.error('Error', xhr.status, xhr.statusText);
	}
}


/* spot Area 토글 */
function toggleSpotArea() {
	spotArea.classList.toggle("hidden");

	const xhr = new XMLHttpRequest();
	xhr.open("GET", "/new/spot?kindOfSpot=" + kindOfSpot);
	/* 정의된 서버에 요청을 전송 */
	xhr.send();

	xhr.onload = () => {
		if (xhr.status === 200) {
			const spotDataList = JSON.parse(xhr.response);

			loadSpotList(spotDataList);
			resetSpotTab();
			loadSpotTab(kindOfSpot);
		}
		else console.error('Error', xhr.status, xhr.statusText);
	}
}

/* 장소 검색 */
function searchSpotList() {
	const search = document.getElementById('spot_search_bar').value;
	/* ajax 추가 */
}

/* spot 탭 초기화  */
function resetSpotTab() {
	trafficTab.classList.remove("spot_tab_active");
	accommodationTab.classList.remove("spot_tab_active");
	restaurantTab.classList.remove("spot_tab_active");
	eventTab.classList.remove("spot_tab_active");
	/* 스크롤 초기화 */
	spotList.scrollTop = 0;
}
/* 클릭 이벤트 시 spot 탭 설정  */
function loadSpotTab(kindOfSpot) {
	switch (kindOfSpot) {
		case "traffic": trafficTab.classList.add("spot_tab_active");
			break;
		case "accommodation": accommodationTab.classList.add("spot_tab_active");
			break;
		case "restaurant": restaurantTab.classList.add("spot_tab_active");
			break;
		case "event": eventTab.classList.add("spot_tab_active");
			break;
	}
}

/* ajax로 가져온 장소 데이터를 요소로 추가 */
function loadSpotList(spotDataList) {
	spotList.innerHTML = "";

	spotDataList.forEach(function (row){
		const spot = document.createElement("div");
		spot.classList.add("spot_wrap");
		spot.setAttribute("onClick", "setSpot(this)");

		const spotDetail = "<img src='"+row.spotPhoto+"' class='spot_img'>"
							+ "<div>"
							+ "<input type='text' name='spotSerialNumber' value='" + row.spotSerialNumber + "' hidden>"
							+ "<p class='spot_name'>" + row.spotName + "</p>"
							+ "<p class='spot_type'>" + row.spotType + "</p>"
							+ "<p class='spot_pnumber'>" + row.spotPhoneNumber + "</p>"
							+ "<p class='spot_loc'>" + row.spotLocation + "</p>";

		const spotTime = "<p class='spot_time'>" + row.spotStartTime + " ~ " + row.spotEndTime + "</p>"

		if(row.spotStartTime === "") spot.innerHTML = spotDetail + "</div>";
		else spot.innerHTML = spotDetail + spotTime + "</div>";

		spotList.appendChild(spot);
	});

	spotList.appendChild(blank);
}
