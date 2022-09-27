document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView: 'dayGridMonth',
			events:function(info, successCallback, failureCallback){
				// ajax 선언
				$.ajax({
					// 데이터를 요청할 url
					url: 'DateCheckServlet',
					type: 'get',
					// 수신할 데이터 타입
					dataType: 'json',
					// 요청 성공시
					success: function(res){
						// 받아온 데이터 변수에 저장
						var list = res;
						// 이벤트에 추가할 변수 선언						
						var events = [];
						// 리스트가 null이 아닐시
						if (list != null) {
							for (var i in list) {
								if (list[i].datecount < 5) {
									events.push({
										start: list[i].p_tripdate,
										display: 'background',
										backgroundColor: "green"
									});
								} else if(list[i].datecount < 10){
									events.push({
										start: list[i].p_tripdate,
										display: 'background',
										backgroundColor: 'yellow'
									});
								} else {
									events.push({
										start: list[i].p_tripdate,
										display: 'background',
										backgroundColor: 'red'
									});
								}
							}
							console.log(events);
						}
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
