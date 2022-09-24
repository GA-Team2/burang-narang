// $(function() unchecked(){
//     $("Input:radio[name='radio_unchecked']'").prop('checked',false);
// });
$(document).ready(function () {
  $("#radio_unchecked").click(function () {
    $("input[type=radio][name=gnb]").prop("checked", false);
  });
});

document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'dayGridMonth'
    });
    calendar.render();
});



window.onload = function(){
    $(".fc-scroller").removeAttr("style");
    /*var date_temp = $('#fc-dom-1').text();
	var month = date_temp.substring(0,date_temp.indexOf(' '));
	var year = date_temp.substring(date_temp.indexOf(' ')+1);
	$('#month').val(month);
	$('#year').val(year);*/
};

