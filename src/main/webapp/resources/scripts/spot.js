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

	const xhr = new XMLHttpRequest();
	xhr.open("get", "/new/spotcontainer");
	xhr.responseType = "json";
	xhr.setRequestHeader('Content-Type', 'application/json');

	//const xhr = new XMLHttpRequest();
	/* Get 방식으로 name 파라미터와 함께 요청 */
	//xhr.open("get", "/new/spotlist");
	/* Response Type을 Json으로 사전 정의 */
	//xhr.responseType = "json";

	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status === 200) {
			console.log("통신 성공");
			console.log(xhr.response);
		}

	};


	/*httpRequest.onreadystatechange = () => {
		/!* readyState가 Done이고 응답 값이 200일 때, 받아온 response로 name과 age를 그려줌 *!/
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				var result = httpRequest.response;
				document.getElementById("name").innerText = result.name;
				document.getElementById("age").innerText = result.age;
			} else {
				alert('Request Error!');
			}
		}
	};*/

	/* 정의된 서버에 요청을 전송 */
	xhr.send();



	//$('#list_load').load('SpotList.jsp?spot=' + spot);



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