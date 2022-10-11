
$(document).ready(function () {
	/**
	 * 시간마다 백그라운드를 바꾸는 function
	 */
	$(function(){
	  var now = new Date();
	  var hour = now.getHours();
	  if (hour >= 7 && hour < 10) {
		  $("#content").addClass("bgSunrise");
	  } else if (hour >= 10 && hour < 16) {
		  $("#content").addClass("bgAfter");
	  } else if (hour >= 16 && hour < 18) {
		  $("#content").addClass("bgSunset");
	  } else {
		  $("#content").addClass("bgNight");
	    $("#gnb_traffic h2").css("color", "#eeecc0");
	    $("#main_menu").css("color", "#eeecc0");
	  }
  });

	/**
	 * 로그인 시 인트로 애니메이션을 제거하는 function
	 */
	$(function(){
	  var nick = $("#session_nick").val();
	  if (nick == "null") {
	    $("#content").delay(3500).animate(
	      {
	        opacity: 1,
	      },
	      1000,
	      "linear"
	    );

	    $("#think_left").delay(2000).addClass("animate__bounceIn");
	    $("#think_left").delay(2000).fadeIn(100);
	    $("#content>label:nth-of-type(1)").delay(4100).fadeIn(100);

	    $("#think_left3").delay(2000).addClass("animate__bounceIn");
	    $("#think_left3").delay(2000).fadeIn(100);
	    $("#content>label:nth-of-type(3)").delay(4100).fadeIn(100);

	    $("#think_right").delay(2000).addClass("animate__bounceIn");
	    $("#think_right").delay(2000).fadeIn(100);
	    $("#content>label:nth-of-type(2)").delay(4100).fadeIn(100);
	
	    $("#lion").click(function () {
	      if ($("#think_left").is(":visible")) {
	        $("#think_left").delay(100).fadeOut(100);
	        $("#content>label:nth-of-type(1)").fadeOut(100);
	        $("#lion_click").fadeIn(100);
	      } else {
	        $("#think_left").addClass("animate__bounceIn");
	        $("#think_left").fadeIn(100);
	        $("#content>label:nth-of-type(1)").delay(100).fadeIn(100);
	        $("#lion_click").fadeOut(100);
	      }
	
	      if ($("#think_left3").is(":visible")) {
	        $("#think_left3").delay(100).fadeOut(100);
	        $("#content>label:nth-of-type(3)").fadeOut(100);
	        $("#lion_click").fadeIn(100);
	      } else {
	        $("#think_left3").addClass("animate__bounceIn");
	        $("#think_left3").fadeIn(100);
	        $("#content>label:nth-of-type(3)").fadeIn(100);
	        $("#lion_click").fadeOut(100);
	      }
	
	      if ($("#think_right").is(":visible")) {
	        $("#think_right").delay(100).fadeOut(100);
	        $("#content>label:nth-of-type(2)").fadeOut(100);
	        $("#lion_click").fadeIn(100);
	      } else {
	        $("#think_right").addClass("animate__bounceIn");
	        $("#think_right").fadeIn(100);
	        $("#content>label:nth-of-type(2)").delay(100).fadeIn(100);
	        $("#lion_click").fadeOut(100);
	      }
	    });
	  } else {
	  	$("#content").css("opacity", 1);
	    $("#think_left").css("display", "block");
	    $("#think_left3").css("display", "block");
	    $("#think_right").css("display", "block");
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
	    $("#content>label:nth-of-type(1)").css("display", "block");
	    $("#content>label:nth-of-type(2)").css("display", "block");
	    $("#content>label:nth-of-type(3)").css("display", "block");
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
      //				ajax 선언
      $.ajax({
        //					데이터를 요청할 url
        url: "/buna/datacheck",
        //					요청방식
        type: "get",
        //					수신할 데이터 타입
        dataType: "json",
        //					요청 성공시
        success: function (res) {
          //						받아온 데이터 변수에 저장
          var list = res;
          //						이벤트에 추가할 변수 선언
          var events = [];
          //						리스트가 null이 아닐시
          if (list != null) {
            //							list 안의 데이터만큼 반복문
            for (var i in list) {
              //								일일 방문량이 5 미만일 경우
              if (list[i].datecount < 5) {
                //									이벤트 변수에 테이터 추가
                events.push({
                  //										시작일
                  start: list[i].p_tripdate,
                  //										디스플레이 추가
                  display: "background",
                  //										배경색
                  backgroundColor: "green",
                });
                //								일일 방문량이 5이상 10미만일 경우
              } else if (list[i].datecount < 10) {
                events.push({
                  start: list[i].p_tripdate,
                  display: "background",
                  backgroundColor: "yellow",
                });
                //								나머지 케이스
              } else {
                events.push({
                  start: list[i].p_tripdate,
                  display: "background",
                  backgroundColor: "red",
                });
              }
            }
          }
          //						Callback성공시 function
          successCallback(events);
        },
      });
    },
  });
  calendar.render();
});
