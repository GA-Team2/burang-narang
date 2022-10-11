// 뒤로가기 방지
window.history.forward();
function noBack() {
	window.history.forward();
}

/*
 * 취소 버튼 클릭 시 마이페이지에서 넘어왔을 경우 마이페이지로, 그 외 페이지에서 넘어왔을 경우 인덱스페이지로 이동
 */
function cancle_location(mypage) {
	if (mypage == "true") {
		location.href = "myPage.jsp";
	} else {
		location.href = "index.jsp";
	}
}

//document.ready
function like_icon() {
	var likecheck = document.getElementById('likecheck').value;
	var like = document.getElementById('like');

	like.addEventListener('click', function() {
		if (likecheck == 1) {
				like.classList.remove("xi-heart-o");
				like.classList.add("xi-heart");
		} else if (likecheck == 0) {
				like.classList.remove("xi-heart");
				like.classList.add("xi-heart-o");
		}
	});
}

//document.ready
function remove_busan() {
	var location = document.getElementsByClassName("location");

	for (var i = 0; i < location.length; i++) {
		var loca = location[i].innerText.split(" ");
		var locas = loca.slice(1, 4);
		location[i].innerText = locas.join(" ");
	}
}



$(document).ready(function() {

	like_icon();
	remove_busan();

			// var likecheck = $("#likecheck").val();

			// if (likecheck == 1) {
			// 	// 이미 좋아요를 한 경우
			// 	$("#like").removeClass("xi-heart-o");
			// 	$("#like").addClass("xi-heart");
			// } else if (likecheck == 0) {
			// 	// 좋아요 하지 않았을 경우
			// 	$("#like").removeClass("xi-heart");
			// 	$("#like").addClass("xi-heart-o");
			// }

			/*
			// 일정 5개를 한 줄씩 묶고 5개 이상이 되면 .tripday 영역만큼 공간 띄우기
			$(".schedule:nth-of-type(6n+1)").before("<div class='none' />");
			// 5번째 일정/맨 마지막 일정은 circle만 남기고 edge는 지우기
			$(".schedule:nth-of-type(5n+1) div").removeClass("edge f_edge");
			$(".schedule:last-of-type div").removeClass("edge f_edge");
			*/

			// 위치에서 부산/부산광역시 제거
/*			var location = document.getElementsByClassName("location");

			for (var i = 0; i < location.length; i++) {
				var loca = location[i].innerText.split(" ");
				var locas = loca.slice(1, 4);
				location[i].innerText = locas.join(" ");
			}
*/

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
