//뒤로가기 방지
window.history.forward();
function noBack(){window.history.forward();}




$(document).ready(function(){
	
	var rownum = document.getElementById("ajaxrownum").value;
	
//	var rownum = $("#ajaxrownum").val();
	
	console.log(rownum);

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
	
	
	
	var data = "rownum="+rownum;
	
		$.ajax({
//               데이터를 요청항 url
               url: 'planDetailServlet',
//               요청방식
			   data: data,
               type: 'post',
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
