// var tag = document.getElementById("tag").value;
// var tagId = tag + "_in";
var tagArea = document.getElementById("tag_area");
// var tagValue = document.getElementById("tag_value").value;
var duplicateTag = document.getElementById("duplicate_tag");
var tooManyTag = document.getElementById("too_many_tag");
var tooLongTag = document.getElementById("too_long_tag");
var blankTag = document.getElementById("blank_tag");
var tagValueList = document.getElementById("tag_value").value.split(" ");
// var closeBtn = document.querySelector(".modal_cancel");
// var addBtn = document.querySelector(".modal_add");
var addTagBtn = document.getElementById("add_tag");
// var modal = document.querySelector(".modal_zone");
// var startDate, endDate;

// closeBtn.addEventListener("click", function () {
//   modal.classList.add("modal_hidden");
// });

addTagBtn.addEventListener("click", function () {
    directlyInsertTag();
});

function clickInsertTag(id) {
    if (commonTagValidation() && duplicateTagValidation(id)) {
        const tagName = document.getElementById(id).innerText;
        const tagId = tagName + "_in";
        const createTagSpan = document.createElement("span");
        document.getElementById("tag_value").value += tagName + " ";
        createTagSpan.id = tagId;
        createTagSpan.className = "highlight";
        createTagSpan.innerText = tagName;
        createTagSpan.onclick = function () {
            removeTag(tagId);
        };
        tagArea.appendChild(createTagSpan);
        tooManyTag.className = "hidden";
    }
}

function directlyInsertTag() {
    const tagName = document.getElementById("tag").value;
    if (commonTagValidation() && directlyTagValidation() && duplicateTagValidation()) {
        const tagId = tagName + "_in";
        const createTagSpan = document.createElement("span");
        document.getElementById("tag_value").value += tagName + " ";
        createTagSpan.id = tagId;
        createTagSpan.className = "highlight";
        createTagSpan.innerText = tagName;
        createTagSpan.onclick = function () {
            removeTag(tagId);
        };
        tagArea.appendChild(createTagSpan);
        document.getElementById("tag").value = "#";
    }
}

function directlyTagValidation() {
    const tagName = document.getElementById("tag").value;
    if (tagName === "#") {
        blankTag.classList.remove("hidden");
        return false;
    }

    if (tagName.length > 11) {
        tooLongTag.classList.remove("hidden");
        return false;
    }

    blankTag.classList.add("hidden");
    tooLongTag.classList.add("hidden");
    tooManyTag.classList.add("hidden");
    duplicateTag.classList.add("hidden");
    return true;
}

function commonTagValidation() {
    if (tagValueList.length > 10) {
        tooManyTag.classList.remove("hidden");
        return false;
    }

    blankTag.classList.add("hidden");
    tooLongTag.classList.add("hidden");
    tooManyTag.classList.add("hidden");
    duplicateTag.classList.add("hidden");
    return true;
}

function duplicateTagValidation(... id) {
    const tagName = document.getElementById("tag").value;
    const tagValue = document.getElementById("tag_value").value;
    console.log(tagName);
    console.log(tagValue);
    if (tagValue.includes(id)) {
        duplicateTag.classList.remove("hidden");
        return false;
    }

    blankTag.classList.add("hidden");
    tooLongTag.classList.add("hidden");
    tooManyTag.classList.add("hidden");
    duplicateTag.classList.add("hidden");
    return true;
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
    tooManyTag.className = "hidden";
    blankTag.className = "hidden";
    tooLongTag.className = "hidden";
    duplicateTag.className = "hidden";
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
            var startDate = info.start; // 시작일자 Date 형식으로 저장
            var endDate = new Date(info.end.setDate(info.end.getDate() - 1)); // 마지막 날의 day를 -1하여 Date 형식으로 저장
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