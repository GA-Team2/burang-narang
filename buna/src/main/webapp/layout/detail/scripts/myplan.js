//뒤로가기 방지
window.history.forward();
function noBack(){window.history.forward();}



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


		$.ajax({
//               데이터를 요청항 url
               url: 'planDetailServlet?nickname='+nickname+'&rownum='+rownum,
//               요청방식
               type: 'get',
//               송수신할 데이터 타입
               dataType: 'json',
//               요청 성공시
               success: function(res){
//                  받아온 데이터 변수에 저장
                  var list = res;
                  console.log(list);
//                  이벤트에 추가할 변수 선언
               }
            });
});
