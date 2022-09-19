var closeBtn = document.querySelector(".modal_cancel");
var addBtn = document.querySelector(".modal_add");
var modal = document.querySelector(".modal_zone");
var startDate, endDate;

closeBtn.addEventListener("click", function () {
  modal.classList.add("hidden");
});

addBtn.addEventListener("click", function () {
  modal.classList.add("hidden");
});

function getValue(e) {
  var result = e.target.value;
  var tagValue = document.getElementById("tag_list").value;

  if (e.target.checked) {
    document.getElementById("tag_list").innerHTML += result + " ";
  } else {
    var idx = tagValue.indexOf(result);
    document.getElementById("tag_list").innerHTML = tagValue.replace(
      tagValue.substring(idx, idx + result.length + 1),
      ""
    );
  }
}

document.addEventListener("DOMContentLoaded", function () {
  var calendarEl = document.getElementById("calendar");
  var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: "dayGridMonth",
    height: 500,
    titleFormat: "YYYY년 MM월",
    headerToolbar: {
      start: "",
      center: "title",
      end: "prev,next",
    },
    selectable: true,
    select: function (info) {
      startDate = info.start;
      endDate = new Date(info.end.setDate(info.end.getDate() - 1));
      var startYear = startDate.getFullYear();
      var startMonth = startDate.getMonth();
      var startDay = startDate.getDate();
      var endYear = endDate.getFullYear();
      var endMonth = endDate.getMonth();
      var endDay = endDate.getDate();

      document.getElementById("start_schedule").value =
        startYear +
        "-" +
        (startMonth >= 10 ? startMonth : "0" + startMonth) +
        "-" +
        (startDay >= 10 ? startDay : "0" + startDay);
      document.getElementById("end_schedule").value =
        endYear +
        "-" +
        (endMonth >= 10 ? endMonth : "0" + endMonth) +
        "-" +
        (endDay >= 10 ? endDay : "0" + endDay);
    },
  });
  calendar.render();
});
