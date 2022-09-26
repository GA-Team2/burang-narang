//뒤로가기 방지
window.history.forward();
function noBack() {
  window.history.forward();
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

var planlist = [];
	
() => {
	// ajax 선언
	$.ajax({
		// 데이터를 요청할 url
		url: 'planDetailServlet',
		type: 'get',
		// 수신할 데이터 타입
		dataType: 'json',
		// 요청 성공시
		success: function(data) {
			$.each(data, function(index, item) {
				planlist.push(index);
				planlist.push(item.p_spotname);
				planlist.push(item.s_location);
				planlist.push(item.s_pnumber);
				planlist.push(item.p_spotname);
			});
		},
		error: function() {
			alert('error');
		}
	});
}

console.log(planlist);
});
