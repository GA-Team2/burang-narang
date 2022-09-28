$(document).ready(function () {
	var now = new Date();
	var hour = now.getHours();
	if(hour >= 7 && hour < 10){
		$('#content').addClass('bgSunrise');
	} else if(hour >=10 && hour < 16) {
		$('#content').addClass('bgAfter');
	} else if(hour >= 16 && hour < 18) {
		$('#content').addClass('bgSunset');
	} else {
		$('#content').addClass('bgNight');
	}
	
	$('#content').delay(3500).fadeIn(1000, 'linear');
});

document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView: 'dayGridMonth',
//			이벤트 function
			events:function(info, successCallback, failureCallback){
//				ajax 선언
				$.ajax({
//					데이터를 요청할 url
					url: 'DateCheckServlet',
//					요청방식
					type: 'get',
//					수신할 데이터 타입
					dataType: 'json',
//					요청 성공시
					success: function(res){
//						받아온 데이터 변수에 저장
						var list = res;
						console.log(res);
//						이벤트에 추가할 변수 선언
						var events = [];
//						리스트가 null이 아닐시
						if (list != null) {
//							list 안의 데이터만큼 반복문
							for (var i in list) {
//								일일 방문량이 5 미만일 경우
								if (list[i].datecount < 5) {
//									이벤트 변수에 테이터 추가
									events.push({
//										시작일
										start: list[i].p_tripdate,
//										디스플레이 추가
										display: 'background',
//										배경색
										backgroundColor: "green"
									});
//								일일 방문량이 5이상 10미만일 경우
								} else if(list[i].datecount < 10){
									events.push({
										start: list[i].p_tripdate,
										display: 'background',
										backgroundColor: 'yellow'
									});
//								나머지 케이스
								} else {
									events.push({
										start: list[i].p_tripdate,
										display: 'background',
										backgroundColor: 'red'
									});
								}
							}
						}
//						Callback성공시 function
						successCallback(events);
					}
				});
			}
	});
	calendar.render();
});



window.onload = function(){
    $(".fc-scroller").removeAttr("style");
};