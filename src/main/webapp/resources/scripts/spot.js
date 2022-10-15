const tf = document.getElementById('tfTap');
const ac = document.getElementById('acTap');
const re = document.getElementById('reTap');
const ev = document.getElementById('evTap');
const sList = document.getElementById('list_load');

/*
* spot 컨테이터 내부에 띄울 spot 정보를 가져오는 메서드
* 
* @param 가져올 장소(교통, 숙소, 맛집, 이벤트)
* */
function getSpotList(spot){
	
	$('#list_load').load('SpotList.jsp?spot=' + spot);

	resetSpotCon();

	switch (spot) {
		case "tf": tf.classList.add("spotTab_active");
			break;

		case "ac": ac.classList.add("spotTab_active");
			break;

		case "re": re.classList.add("spotTab_active");
			break;

		case "ev": ev.classList.add("spotTab_active");
			break;
	}
}


/* spotcontainer 종료 메서드 */
function cancelSpot() {
	document.getElementById("spot_container").classList.add("hidden");
}

/* searchspot 띄우는 메서드 */
function searchSpot() {
	let search = document.getElementById('searchSpot').value;
	
	$('#list_load').load('SearchSpot.jsp?search=' + search);
}

/* spot 컨테이너 초기화  */
function resetSpotCon() {
	tf.classList.remove("spotTab_active");
	ac.classList.remove("spotTab_active");
	re.classList.remove("spotTab_active");
	ev.classList.remove("spotTab_active");
	/* 스크롤 초기화 */
	sList.scrollTop = 0;
}