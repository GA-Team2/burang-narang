var closeBtn = document.querySelector(".modal_cancel");
var addBtn = document.querySelector(".modal_add");
var tagAddBtn = document.getElementById("tag_insert");
var modal = document.querySelector(".modal_zone");
var startDate, endDate;

closeBtn.addEventListener("click", function () {
  modal.classList.add("modal_hidden");
});

tagAddBtn.addEventListener("click", function (e) {
  var tag = document.getElementById("tag").value;
  var tagId = tag + "_in";
  var tagArea = document.getElementById("tag_area");
  var addTag = document.createElement("span");
  var tagValue = document.getElementById("tag_value").value;
  var overLap = document.getElementById("overlap");
  var manyTag = document.getElementById("manytag");
  var longTag = document.getElementById("longtag");
  var noTag = document.getElementById("notag");
  var tagValueList = tagValue.split(" ");

  if (tag === "#") {
    noTag.className = "";
    manyTag.className = "hidden";
    longTag.className = "hidden";
    overLap.className = "hidden";
    return;
  } else if (tag.length > 11) {
    noTag.className = "hidden";
    longTag.className = "";
    manyTag.className = "hidden";
    overLap.className = "hidden";
    return;
  } else if (tagValueList.length > 10) {
    noTag.className = "hidden";
    manyTag.className = "";
    longTag.className = "hidden";
    overLap.className = "hidden";
    return;
  } else {
    longTag.className = "hidden";
    noTag.className = "hidden";
    manyTag.className = "hidden";
    overLap.className = "hidden";
  }

  if (!tagValue.includes(tag)) {
    if (tagValueList.length <= 10) {
      document.getElementById("tag_value").value += tag + " ";
      addTag.id = tagId;
      addTag.className = "highlight";
      addTag.innerText = tag;
      addTag.onclick = function () {
        removeTag(tagId);
      };
      tagArea.appendChild(addTag);
      document.getElementById("tag").value = "#";
      manyTag.className = "hidden";
    } else {
      manyTag.className = "";
    }
    noTag.className = "hidden";
    longTag.className = "hidden";
    overLap.className = "hidden";
  } else {
    document.getElementById("tag").value = "#";
    overLap.className = "";
    longTag.className = "hidden";
    noTag.className = "hidden";
    manyTag.className = "hidden";
  }
});

function getValue(e) {
  var result = e.target.innerText;
  var tagArea = document.getElementById("tag_area");
  var tagValue = document.getElementById("tag_value").value;
  var overLap = document.getElementById("overlap");
  var manyTag = document.getElementById("manytag");
  var longTag = document.getElementById("longtag");
  var noTag = document.getElementById("notag");
  var addTag = document.createElement("span");
  var tagValueList = tagValue.split(" ");

  if (!tagValue.includes(result)) {
    if (tagValueList.length <= 10) {
      var tagId = result + "_in";
      document.getElementById("tag_value").value += result + " ";
      addTag.id = tagId;
      addTag.className = "highlight";
      addTag.innerText = result;
      addTag.onclick = function () {
        removeTag(tagId);
      };
      tagArea.appendChild(addTag);
      manyTag.className = "hidden";
    } else {
      manyTag.className = "";
    }
    noTag.className = "hidden";
    longTag.className = "hidden";
    overLap.className = "hidden";
  } else {
    longTag.className = "hidden";
    noTag.className = "hidden";
    manyTag.className = "hidden";
    overLap.className = "";
  }
}

function removeTag(tag_id) {
  var tagValue = document.getElementById("tag_value").value;
  var result = tag_id.substring(0, tag_id.length - 3);
  console.log(result);
  var idx = tagValue.indexOf(result);

  document.getElementById("tag_value").value = tagValue.replace(
    tagValue.substring(idx, idx + result.length + 1),
    ""
  );

  document.getElementById(tag_id).remove();
  manyTag.className = "hidden";
  noTag.className = "hidden";
  longTag.className = "hidden";
  overLap.className = "hidden";
}

// 캘린더 호출
document.addEventListener("DOMContentLoaded", function () {
  // 캘린더 생성
  var calendarEl = document.getElementById("calendar");
  var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: "dayGridMonth", // 달력 형식
    height: 500, // 달력 높이
    titleFormat: "YYYY년 MM월", // 달력 제목 포맷

    // 달력 헤더 순서
    headerToolbar: {
      start: "",
      center: "title",
      end: "prev,next",
    },
    selectable: true, // 달력 날짜 선택 가능 여부

    /* 드래그하면 마지막 날짜가 지정한 날짜의 다음날까지 포함해서 출력된다.
       ex) 2022-08-20 ~ 2022-08-21 까지 캘린더에 드래그하면 결과값은 2022-08-20 ~ 2022-08-22
      우리가 의도했던 결과와 다르므로 결과값을 임의로 조정해주어야 한다. */
    select: function (info) {
      startDate = info.start; // 시작일자 Date 형식으로 저장
      endDate = new Date(info.end.setDate(info.end.getDate() - 1)); // 마지막 날의 day를 -1하여 Date 형식으로 저장
      var startYear = startDate.getFullYear();
      var startMonth = startDate.getMonth() + 1;
      var startDay = startDate.getDate();
      var endYear = endDate.getFullYear();
      var endMonth = endDate.getMonth() + 1;
      var endDay = endDate.getDate();

      // "YYYY-MM-DD" 형식으로 출력하게끔 만든다.
      // 한 자리 숫자를 두 자리 숫자로 만들기 위해 한 자리 수 앞에 0을 붙여줘야 한다.
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

function writeCheck() {
  var title = true;
  var schedule = true;

  if (scheduleForm.title.value.length === 0) {
    document.getElementById("notitle").className = "";
    title = false;
  } else {
    document.getElementById("notitle").className = "hidden";
  }

  if (scheduleForm.firstdate.value.length === 0) {
    document.getElementById("noschedule").className = "";
    schedule = false;
  } else {
    document.getElementById("noschedule").className = "hidden";
  }

  if (title === false || schedule === false) {
    return;
  }

  document.scheduleForm.submit();
}
