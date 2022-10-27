// 캘린더 호출
document.addEventListener("DOMContentLoaded", function () {
    // 캘린더 생성
    const calendarEl = document.getElementById("calendar");
    const calendar = new FullCalendar.Calendar(calendarEl, {
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
            changeDateFormat(info);
        },
    });
    calendar.render();
});

function changeDateFormat(info) {
    const startDate = info.start; // 시작일자 Date 형식으로 저장
    const endDate = new Date(info.end.setDate(info.end.getDate() - 1)); // 마지막 날의 day를 -1하여 Date 형식으로 저장
    const startYear = startDate.getFullYear();
    const startMonth = startDate.getMonth() + 1;
    const startDay = startDate.getDate();
    const endYear = endDate.getFullYear();
    const endMonth = endDate.getMonth() + 1;
    const endDay = endDate.getDate();

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
}