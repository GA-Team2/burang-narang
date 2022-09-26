
$(document).ready(function () {
  $("#radio_unchecked").click(function () {
    $("input[type=radio][name=gnb]").prop("checked", false);
  });
});

document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView: 'dayGridMonth',
			events:function(info, successCallback, failureCallback){
				$.ajax({
					url: 'DateCheckServlet',
					type: 'get',
					dataType: 'json',
					success: function(res){
						var list = res;
						console.log(list);
						console.log(list[0].datecount)
						
						var events = [];
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
