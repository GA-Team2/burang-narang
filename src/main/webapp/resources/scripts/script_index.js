//풀캘린더 이벤트 변수
const events = [];

$(document).ready(function () {
	const content = $("#content");

	/**
	 * 시간마다 백그라운드를 바꾸는 function
	 */
	$(function(){
	  var now = new Date();
	  var hour = now.getHours();
	  if (hour >= 7 && hour < 10) {
		  content.addClass("bgSunrise");
	  } else if (hour >= 10 && hour < 16) {
		  content.addClass("bgAfter");
	  } else if (hour >= 16 && hour < 18) {
		  content.addClass("bgSunset");
	  } else {
		  content.addClass("bgNight");
	    $("#gnb_traffic h2").css("color", "#eeecc0");
	    $("#main_menu").css("color", "#eeecc0");
	  }
  });

	/**
	 * 로그인 시 인트로 애니메이션을 제거하는 function
	 */
	$(function(){
		const left1 = $("#think_left");
		const left2 = $("#think_left3");
		const right = $("#think_right");
		const left1_text = $("#content>label:nth-of-type(1)");
		const left2_text = $("#content>label:nth-of-type(3)");
		const right_text = $("#content>label:nth-of-type(2)");
		const lion = $("#lion_click");
	  // var nick = $("#session_nick").val();
		var nick = "test";
	  //비로그인 case
	  if (nick === "") {
		  content.delay(3500).animate(
	      {
	        opacity: 1,
	      },
	      1000,
	      "linear"
	    );

		  left1.delay(2000).addClass("animate__bounceIn");
		  left1.delay(2000).fadeIn(100);
		  left1_text.delay(4100).fadeIn(100);

		  left2.delay(2000).addClass("animate__bounceIn");
		  left2.delay(2000).fadeIn(100);
		  left2_text.delay(4100).fadeIn(100);

		  right.delay(2000).addClass("animate__bounceIn");
		  right.delay(2000).fadeIn(100);
		  right_text.delay(4100).fadeIn(100);
	
	    $("#lion").click(function () {
	      if (left1.is(":visible")) {
			  left1.delay(100).fadeOut(100);
			  left1_text.fadeOut(100);
			  lion.fadeIn(100);
	      } else {
			  left1.addClass("animate__bounceIn");
			  left1.fadeIn(100);
			  left1_text.delay(100).fadeIn(100);
			  lion.fadeOut(100);
	      }
	
	      if (left2.is(":visible")) {
			  left2.delay(100).fadeOut(100);
			  left2_text.fadeOut(100);
			  lion.fadeIn(100);
	      } else {
			  left2.addClass("animate__bounceIn");
			  left2.fadeIn(100);
			  left2_text.fadeIn(100);
			  lion.fadeOut(100);
	      }
	
	      if (right.is(":visible")) {
			  right.delay(100).fadeOut(100);
			  right_text.fadeOut(100);
	        $("#lion_click").fadeIn(100);
	      } else {
			  right.addClass("animate__bounceIn");
			  right.fadeIn(100);
			  right_text.delay(100).fadeIn(100);
	        $("#lion_click").fadeOut(100);
	      }
	    });
	  //로그인 case
	  } else {
		  content.css("opacity", 1);
		  left1.css("display", "block");
		  left2.css("display", "block");
		  right.css("display", "block");
	    $("#main_title")
	      .css("top", "10%")
	      .css("left", "12%")
	      .css("width", "380px")
	      .css("height", "150px");
	    $("#main_title").removeClass("main_title_ani");
	    $("#title_blind").removeClass("title_blind_ani");
	    $("#title_blind").css("display", "none");
	    $("#flight").removeClass("flight_ani");
	    $("#flight").css("display", "none");
		  left1_text.css("display", "block");
		  right_text.css("display", "block");
		  left2_text.css("display", "block");
	  }
  });

	/**
	 * fullCalendar 스크롤 제거
	 */
	$(function(){
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
    events: function (info, successCallback, failureCallback) {

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
function CEvent(list){
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