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
});