
//페이지 로딩 시 실행되는 함수
window.onload = function() {
	like_icon();
	remove_busan();
	detail_sort();
	setMapMarkerAll();
}

/*
 * onclick 관련 함수
 * 취소 버튼 클릭 시 마이페이지에서 넘어왔을 경우 마이페이지로,
 * 그 외 페이지에서 넘어왔을 경우 인덱스페이지로 이동
 */
function cancle_location(mypage) {
	if (mypage == "true") {
		location.href = "/mypage";
	} else {
		location.href = "/";
	}
}


/* 페이지 로드 시 실행되는 함수 목록 */

var like = document.getElementById('like');

/* 추천 여부에 따른 아이콘 변경 */
function like_icon() {
	var likecheck = document.getElementById('likecheck').value;

	if (likecheck == 1) {
		like.classList.replace("xi-heart-o", "xi-heart");
	} else if (likecheck == 0) {
		like.classList.replace("xi-heart", "xi-heart-o");
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
	var schedule = document.getElementsByClassName('schedule');




	// 일정 5개를 한 줄씩 묶어 5개 초과 시 .tripday 영역만큼 공간 띄우기
	$(".schedule:nth-of-type(6n+1)").before("<br><div class='none' />");
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

/* 좋아요 */
var likeNum = document.getElementById("likeNum");
function likeAjax(rownum) {
// XMLHttpRequest 객체 생성
	const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
	xhr.open('GET', '/detail/like?rownum='+rownum);
// HTTP 요청 전송
	xhr.send();
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
	xhr.onload = () => {
		const result = JSON.parse(xhr.response);
		console.log(result);
		if (xhr.status === 200) {
			likeNum.innerText = result.likeNumber;
			if (result.checkResult == 0) {
				like.classList.replace("xi-heart-o", "xi-heart");
			} else {
				like.classList.replace("xi-heart", "xi-heart-o");
			}
		} else {
			console.error('Error', xhr.status, xhr.statusText);
		}
	}
}

