//풀캘린더 이벤트 변수
const events = [];

$(document).ready(function () {

    /*쿼리스트링을 숨겨주는 기능*/
    history.replaceState({}, null, location.pathname);

    backgroundChange();

    /**
     * 메인페이지 호출마다 배경화면이 바뀌는 함수
     */
    function backgroundChange() {
        const images = ['../images/backgroundImg/busan1.jpg', '../images/backgroundImg/busan2.jpg', '../images/backgroundImg/busan3.jpg', '../images/backgroundImg/busan4.jpg',
            '../images/backgroundImg/busan5.jpg', '../images/backgroundImg/busan6.jpg'];

        const img_number = 6;

        const getRandom = () => {
            return Math.floor(Math.random() * img_number);
        }

        function paintImage(imgNumber) {
            const backgroundImg = "url('" + images[imgNumber] + "')";
            document.body.style.backgroundImage = backgroundImg;
            if (imgNumber == 0) {
                // document.getElementById("planMake").style.color = '#FF00FF';
            }
        }

        function init() {
            const imgNumber = getRandom();
            paintImage(imgNumber);
        }

        init();
    }
    /**
     * fullCalendar 스크롤 제거
     */
    $(function () {
        $(".fc-scroller").removeAttr("style");
    });
});

document.addEventListener("DOMContentLoaded", function () {
    var calendarEl = document.getElementById("calendar");
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: "dayGridMonth",
        /**
         * 이벤트 function
         * @author 한병태
         */
        events: function (info, successCallback) {

            // XMLHttpRequest 객체 생성
            const xhr = new XMLHttpRequest();
            // HTTP 요청 초기화
            xhr.open('GET', '/check');

            // HTTP 요청 전송
            xhr.send();

            // load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
            xhr.onload = () => {
                if (xhr.status === 200) {
                    const list = JSON.parse(xhr.response);
                    events.length = 0;
                    CEvent(list);
                    successCallback(events);
                } else {
                    console.error('Error', xhr.status, xhr.statusText);
                }
            }
        },
    });
    calendar.render();
});

/**]
 * event안에 들어갈 날짜와 혼잡신호등 function
 * @param list
 * @constructor 한병태
 */
function CEvent(list) {
    if (list != null) {
        //							list 안의 데이터만큼 반복문
        for (var i in list) {
            //								일일 방문량이 5 미만일 경우
            if (list[i].datecount < 5) {
                //									이벤트 변수에 테이터 추가
                events.push({
                    //										시작일
                    start: list[i].planTripdate,
                    //										디스플레이 추가
                    display: "background",
                    //										배경색
                    backgroundColor: "green",
                });
                //								일일 방문량이 5이상 10미만일 경우
            } else if (list[i].datecount < 10) {
                events.push({
                    start: list[i].planTripdate,
                    display: "background",
                    backgroundColor: "yellow",
                });
                //								나머지 케이스
            } else {
                events.push({
                    start: list[i].planTripdate,
                    display: "background",
                    backgroundColor: "red",
                });
            }
        }
    }
}