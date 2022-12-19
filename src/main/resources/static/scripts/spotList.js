const spotArea = document.getElementById("spot_area");
trafficTab = document.getElementById('tf_tab');
accommodationTab = document.getElementById('ac_tab');
restaurantTab = document.getElementById('re_tab');
eventTab = document.getElementById('ev_tab');
spotList = document.getElementById("spot_list");

/**
 * spot 컨테이터 내부에 띄울 spot 정보를 ajax로 가져오는 메서드
 *
 * @param kindOfSpot 어떤 장소 데이터를 가져올지 지정해주는 변수
 */
function getSpotList(kindOfSpot) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "/new/spot?kindOfSpot=" + kindOfSpot);
    /* 정의된 서버에 요청을 전송 */
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            const spotDataList = JSON.parse(xhr.response);

            setSpotList(spotDataList);
            resetSpotTab();
            onSpotTab(kindOfSpot);
        } else console.error('Error', xhr.status, xhr.statusText);
    }
}


/* spot Area 토글 */
function toggleSpotArea() {
    spotArea.classList.toggle("hidden");
}

/* 장소 검색 */
function searchSpotList() {
    const spotName = document.getElementById('spot_search_bar').value;
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "/new/search?spotName=" + spotName);
    /* 정의된 서버에 요청을 전송 */
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === 200) {
            const spotDataList = JSON.parse(xhr.response);
            setSpotList(spotDataList);
            resetSpotTab();
        } else console.error('Error', xhr.status, xhr.statusText);
    }
}

/* spot 탭 초기화  */
function resetSpotTab() {
    trafficTab.classList.remove("spot_tab_active");
    accommodationTab.classList.remove("spot_tab_active");
    restaurantTab.classList.remove("spot_tab_active");
    eventTab.classList.remove("spot_tab_active");
    /* 스크롤 초기화 */
    document.getElementById("spot_list_container").scrollTop = 0;
}

/**
 * 클릭 이벤트 시 spot 탭 설정
 *
 *@param kindOfSpot 어떤 장소 데이터를 가져올지 지정해주는 변수
 */
function onSpotTab(kindOfSpot) {
    switch (kindOfSpot) {
        case "traffic":
            trafficTab.classList.add("spot_tab_active");
            break;
        case "accommodation":
            accommodationTab.classList.add("spot_tab_active");
            break;
        case "restaurant":
            restaurantTab.classList.add("spot_tab_active");
            break;
        case "event":
            eventTab.classList.add("spot_tab_active");
            break;
    }
}

/**
 * ajax로 가져온 장소 데이터를 요소로 추가
 *
 * @param spotDataList 장소 데이터 리스트
 */
function setSpotList(spotDataList) {
    spotList.innerHTML = "";

    spotDataList.forEach(function (row) {
        const spot = document.createElement("div");
        spot.classList.add("spot_wrap");
        spot.setAttribute("onClick", "setSpot(this)");

        const spotDetail = `<img src='${row.spotPhoto}' class='spot_img'>
							<div>
							<input type='text' name='spotSerialNumber' value='${row.spotSerialNumber}' hidden>
							<p class='spot_name'>${row.spotName}</p>
							<p class='spot_type'>${row.spotType}</p>
							<p class='spot_pnumber'>${row.spotPhoneNumber}</p>
							<p class='spot_loc'>${row.spotLocation}</p>`;

        const spotTime = `<p class='spot_time'>${row.spotStartTime} ~ ${row.spotEndTime}</p>`;

        if (row.spotStartTime === "") spot.innerHTML = spotDetail + `</div>`;
        else spot.innerHTML = spotDetail + spotTime + `</div>`;

        spotList.appendChild(spot);
    });

    const blank = document.createElement("div");
    blank.classList.add("blank");

    spotList.appendChild(blank);
}
