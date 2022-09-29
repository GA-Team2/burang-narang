var planCount = [];

//뒤로가기 방지
window.history.forward();
function noBack() {
  window.history.forward();
}

function cancle_location(mypage) {
	if (mypage == "true") {
		location.href="myPage.jsp";
	} else {
		location.href="index.jsp";
	}
}

$(document).ready(function () {
  var likecheck = $("#likecheck").val();

  if (likecheck == 1) {
    //이미 좋아요를 한 경우
    $("#like").removeClass("xi-heart-o");
    $("#like").addClass("xi-heart");
  } else if (likecheck == 0) {
    //좋아요 하지 않았을 경우
    $("#like").removeClass("xi-heart");
    $("#like").addClass("xi-heart-o");
  }

  $(".schedule:nth-of-type(6n+1)").before("<div class='none' />");
  $(".schedule:nth-of-type(5n+1) div").removeClass("edge f_edge");
	$(".schedule:last-of-type div").removeClass("edge f_edge");

	//위치에서 부산/부산광역시 제거
	var location = document.getElementsByClassName("location");

	for (var i=0; i<location.length; i++) {
		var loca = location[i].innerText.split(" ");

		var locas = loca.slice(1, 4);

		location[i].innerText = locas.join(" ");
	}
  $.ajax({
    //               데이터를 요청항 url
    url: "http://localhost:8181/buna/plandetail",
    //               요청방식
    type: "get",
    //               송수신할 데이터 타입
    dataType: "json",
    data: { rownum: $("#ajaxrownum").val() },
    //               요청 성공시
    success: function (res) {
      //                  받아온 데이터 변수에 저장
      var list = res;
      //                  이벤트에 추가할 변수 선언
      console.log(list);

      for (var i = 0; i < Object.keys(list).length; i++) {
      placeSearch(
          list[i].s_location +
            " " +
            list[i].p_spotname +
            " " +
            list[i].s_pnumber,
          list[i].p_tripday,
          true
        );
        
      }
      zoomOut();
      console.log(planCount);
    },
  });
});
