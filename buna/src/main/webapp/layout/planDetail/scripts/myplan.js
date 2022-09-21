
//$(document).ready(function(){
//	$("#date").eq(0).children("li").removeClass("p_tripday");
//});


function like(rownum) {
	//세션값이 없으면 로그인 페이지로 이동
	if (nick == null) {
		console.log(nick);
		alert("추천 기능은 회원만 사용할 수 있습니다.");
		location.href="index.jsp";
	} else {
		var likecheck = $("#likecheck").val();
	
		if(likecheck==1) { //이미 좋아요를 한 경우
			$("#like").removeClass("xi-heart-o");
			$("#like").addClass("xi-heart");
		} else if (likecheck==0) {
			$("#like").removeClass("xi-heart");
			$("#like").addClass("xi-heart-o");
		}
		
		location.href="likeUpdate.jsp?rownum="+rownum;
	}	
}

$(document).ready(function(){
	var likecheck = $("#likecheck").val();
	
	if(likecheck==1) { //이미 좋아요를 한 경우
		$("#like").removeClass("xi-heart-o");
		$("#like").addClass("xi-heart");
	} else if (likecheck==0) {
		$("#like").removeClass("xi-heart");
		$("#like").addClass("xi-heart-o");
	}
	
});