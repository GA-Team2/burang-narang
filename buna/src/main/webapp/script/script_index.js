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
}
