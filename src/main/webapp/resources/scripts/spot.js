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
	xhr.open("GET", "/new/spot?spot="+spot);
	//xhr.responseType = "json";
	//xhr.setRequestHeader('Content-Type', 'application/json');
	/* 정의된 서버에 요청을 전송 */
	xhr.send();

	/*xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status === 200) {
			console.log("통신 성공");
			console.log(xhr.response);
		}

	};*/

	xhr.onload = () => {
		if (xhr.status === 200) {
			const spotData = JSON.parse(xhr.response);
			console.log(spotData);
			//console.log(spotData[0]);
			loadSpotList(spotData);

			resetSpotCon();

			switch (spot) {
				case "traffic": tf.classList.add("spotTab_active");
					break;

				case "accommodation": ac.classList.add("spotTab_active");
					break;

				case "restaurant": re.classList.add("spotTab_active");
					break;

				case "event": ev.classList.add("spotTab_active");
					break;
			}
		}
		else console.error('Error', xhr.status, xhr.statusText);


	}

	//$('#list_load').load('SpotList.jsp?spot=' + spot);
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

function loadSpotList(spotArr) {
	const spotList = document.createElement("div");
	spotList.classList.add("spot_list");

	spotArr.forEach(function (row){
		console.log(row);
	});

	spotList.appendChild(blank);

}
/*
	<div className="spot_list">
		<c:forEach var="trafficList" items="${trafficList}">
			<div className="spot_con" onClick="setSpot(this)">
				<img src="${trafficList.trafficPhoto}" className="spot_img">
					<div>
						<input type="text" name="spotSerialNum" value="${trafficList.spotSerialNum}" hidden>
							<p className="s_name">${trafficList.trafficName}</p>
							<p className="s_type">${trafficList.trafficType}</p>
							<p className="s_pnumber">${trafficList.trafficPnumber}</p>
							<p className="s_loc">${trafficList.trafficLocation}</p>
					</div>
			</div>
		</c:forEach>
		<div className="blank"></div>
	</div>
}*/
