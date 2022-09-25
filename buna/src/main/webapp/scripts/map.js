var fewDays;

// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });

var container = document.getElementById("map_area"); // 지도를 표시할 div
var options = {
  center: new kakao.maps.LatLng(35.157714, 129.059165), // 지도의 중심좌표
  level: 3, // 지도의 확대 레벨
};

var map = new kakao.maps.Map(container, options); // 지도를 생성

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.LEFT);

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();
// 선을 구성하는 좌표 배열입니다. 이 좌표들을 이어서 선을 표시합니다

function placeSearch(placeAddress, ...i) {
  fewDays = i;
  // 키워드로 장소를 검색합니다
  ps.keywordSearch(placeAddress, placesSearchCB);
}

var linePath = [];
var markers = [];
var polyline = new kakao.maps.Polyline({
  strokeWeight: 5, // 선의 두께 입니다
  strokeColor: "#0080FF", // 선의 색깔입니다
  strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
  strokeStyle: "solid", // 선의 스타일입니다
});

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
  // 지도에 표시할 선을 생성합니다
  if (status === kakao.maps.services.Status.OK) {
    // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
    // LatLngBounds 객체에 좌표를 추가합니다
    var bounds = new kakao.maps.LatLngBounds();

    for (var i = 0; i < data.length; i++) {
      displayMarker(data[i]);
      bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
      linePath.splice(
        planCount.lastIndexOf(fewDays + ""),
        0,
        new kakao.maps.LatLng(data[i].y, data[i].x)
      );
    }
    console.log(fewDays);
    polyline.setPath(linePath);

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
    polyline.setMap(map);
  }
}
// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
  // 마커를 생성하고 지도에 표시합니다
  var marker = new kakao.maps.Marker({
    map: map,
    position: new kakao.maps.LatLng(place.y, place.x),
  });

  markers.splice(planCount.lastIndexOf(fewDays + ""), 0, marker);
  marker.setMap(map);

  // 마커에 클릭이벤트를 등록합니다
  kakao.maps.event.addListener(marker, "click", function () {
    // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
    infowindow.setContent(
      '<div style="padding:5px;font-size:12px;">' + place.place_name + "</div>"
    );
    infowindow.open(map, marker);
  });
}

function deletePlace(seq) {
  console.log(markers);
  console.log(linePath);
  markers[seq].setMap(null);

  linePath.splice(seq, 1);
  markers.splice(seq, 1);
  polyline.setPath(linePath);
  polyline.setMap(map);
}

function movePlace(seq, fewDay, direction) {
  if (direction == true) {
    // up
    if (seq != 1) {
      var tempLine = linePath[seq - 2];
      var tempMark = markers[seq - 2];
      linePath[seq - 2] = linePath[seq - 1];
      linePath[seq - 1] = tempLine;
      markers[seq - 2] = markers[seq - 1];
      markers[seq - 1] = tempMark;
      polyline.setPath(linePath);
      polyline.setMap(map);
    }
  } else if (direction == false) {
    // down
    if (
      planCount.lastIndexOf(fewDay + "") !=
      planCount.indexOf(fewDay + "") + (seq - 1)
    ) {
      var tempLine = linePath[seq];
      var tempMark = markers[seq];
      linePath[seq] = linePath[seq - 1];
      linePath[seq - 1] = tempLine;
      markers[seq] = markers[seq - 1];
      markers[seq - 1] = tempMark;
      polyline.setPath(linePath);
      polyline.setMap(map);
    }
  }
}

function detailInquiryPlace(spot) {
  linePath.length = 0;
  markers.length = 0;

  for (var i = 0; i < spot.size(); i++) {
    placeSearch(
      spot[i].spotname + " " + spot[i].location + " " + spot[i].pnumber,
      placesSearchCB
    );
  }
}
