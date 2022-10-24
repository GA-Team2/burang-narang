// var planCount = [];

//뒤로가기 방지
window.history.forward();
window.onpageshow = function() {
	if(event.persisted) noBack();
}

window.onload = function() {
	noBack();
	like_icon();
	remove_busan();
	detail_sort();
	setMapMarkerAll();
}

/* ajax 수정 필요

$(document).ready(function() {

			// 지도 조회에 필요한 상호명, 위치, 전화번호, 여행일자 전달을 위해 ajax 사용
			$.ajax({
				// 데이터를 요청항 url
				url : "http://localhost:8181/buna/plandetail",
				// 요청방식
				type : "get",
				// 송수신할 데이터 타입
				dataType : "json",
				data : {
					rownum : $("#ajaxrownum").val()
				},
				// 요청 성공시
				success : function(res) {
					// 받아온 데이터 변수에 저장
					var list = res;
					// 이벤트에 추가할 변수 선언
					console.log(list);

					for (var i = 0; i < Object.keys(list).length; i++) {
						placeSearch(list[i].s_location + " "
								+ list[i].p_spotname + " " + list[i].s_pnumber,
								list[i].p_tripday, true);

					}
					zoomOut();
					console.log(planCount);
				},
			});

});

 */

// 뒤로가기 방지
function noBack() {
	window.history.forward();
}

/*
 * onclick 관련 함수
 * 취소 버튼 클릭 시 마이페이지에서 넘어왔을 경우 마이페이지로,
 * 그 외 페이지에서 넘어왔을 경우 인덱스페이지로 이동
 */
function cancle_location(mypage) {
	if (mypage == "true") {
		location.href = "MyPage.jsp";
	} else {
		location.href = "Index.jsp";
	}
}

/* 페이지 로드 시 실행되는 함수 목록 */
/* 추천 여부에 따른 아이콘 변경 */
function like_icon() {
	var likecheck = document.getElementById('likecheck').value;
	var like = document.getElementById('like');

	if (likecheck == 1) {
		like.classList.remove("xi-heart-o");
		like.classList.add("xi-heart");
	} else if (likecheck == 0) {
		like.classList.remove("xi-heart");
		like.classList.add("xi-heart-o");
	}
}

/* 받아온 주소 데이터에서 부산,부산광역시 제거 */
function remove_busan() {
	var location = document.getElementsByClassName("location");

	for (var i = 0; i < location.length; i++) {
		var loca = location[i].innerText.split(" ");
		var locas = loca.slice(1, 4);
		location[i].innerText = locas.join(" ");
	}
}

/* 플랜 정렬 */
function detail_sort() {
	var plan_container = document.getElementsByClassName('container');

	// 일정 5개를 한 줄씩 묶어 5개 초과 시 .tripday 영역만큼 공간 띄우기
	$(".schedule:nth-of-type(6n+1)").before("<div class='none' />");
	// 5번째 일정/맨 마지막 일정마다 circle만 남기고 edge(연결 선) 지우기
	$(".schedule:nth-of-type(5n+1) div").removeClass("edge f_edge");
	$(".schedule:last-of-type div").removeClass("edge f_edge");
}


function setMapMarkerAll() {
	// XMLHttpRequest 객체 생성
	const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
	xhr.open('GET', '/detail/all');

// HTTP 요청 전송
	xhr.send();

// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
	xhr.onload = () => {
		if (xhr.status === 200) {
			console.log(JSON.parse(xhr.response));
		} else {
			console.error('Error', xhr.status, xhr.statusText);
		}
	}
}

var likeNum = document.getElementById("likeNum").value;
function likeAjax(rownum) {
// XMLHttpRequest 객체 생성
	const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
	xhr.open('GET', '/likecheck?rownum='+rownum);
// HTTP 요청 전송
	xhr.send();
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
	xhr.onload = () => {
		const result = xhr.response;
		console.log(result);
		if (xhr.status === 200) {
			likeNum = result;
			console.log(JSON.parse(xhr.response));
		} else {
			console.error('Error', xhr.status, xhr.statusText);
		}
	}
}

