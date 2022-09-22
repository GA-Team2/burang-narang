$(document).ready(function(){
	var likecheck = $("#likecheck").val();
	
	if(likecheck==1) { 
		//이미 좋아요를 한 경우
		$("#like").removeClass("xi-heart-o");
		$("#like").addClass("xi-heart");
	} else if (likecheck==0) {
		//좋아요 하지 않았을 경우
		$("#like").removeClass("xi-heart");
		$("#like").addClass("xi-heart-o");
	}
<<<<<<< HEAD
});

function like(rownum, nick) {
	
	/*
	 * 로그인 확인 불필요 
	if(nick == null) {
		alert("추천 기능은 회원만 사용가능합니다.");
		location.href="../../index.jsp";
	} else {
	*/ 
	$.ajax({
		url : "likeUpdate.jsp",
		type : "post",
		data : {"rownum" : rownum,
				"nick" : nick},
		success : function(result){
			if (result==1) { //업데이트 성공
				$("#like").removeClass("xi-heart-o");
				$("#like").addClass("xi-heart");
			} else if(result==-1) { //삭제 성공
				$("#like").removeClass("xi-heart");
				$("#like").addClass("xi-heart-o");
			}
		},
		error : function(request) {
	        console.log(request.responseText);
	        event.preventDefault();
		}
	});
}
=======
});
>>>>>>> 7514e05cf59a2404f731407a7d739d4dd728d767
