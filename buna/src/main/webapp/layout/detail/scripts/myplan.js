//뒤로가기 방지
window.history.forward();
function noBack(){window.history.forward();}




$(document).ready(function(){
	
//	var rownum = document.getElementById("ajaxrownum").value;
	
//	var rownum = $("#ajaxrownum").val();
		$.ajax({
//               데이터를 요청항 url
               url: 'http://localhost:8181/buna/plandetail',
//               요청방식
               type: 'get',
//               송수신할 데이터 타입
               dataType: 'json',
               data: {rownum: $("#ajaxrownum").val()},
//               요청 성공시
               success: function(res){
//                  받아온 데이터 변수에 저장
                  var list = res;
                  console.log(list);
//                  이벤트에 추가할 변수 선언
               }
            });
		
		
		
		
		

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
	
	var date = document.getElementById("date");
	
//	var url=' <c:forEach begin="1" + end="planDay"> '
//			+ '<div class="container"> <c:forEach var="detailList" items="${list}">'
//			+ '<c:choose> <c:when test="${detailList.p_tripday != 0 && detailList.p_tripdate != null}"> <div class="tripday"> '
//			+ 'DAY ${detailList.p_tripday }<br> 	${detailList.p_tripdate } '
//			+ '</div>'
//			+ '	<div class="schedule">'
//			+ '	<p>${detailList.p_spotname }</p>'
//			+ ' <c:if test="${fn:substring(detailList.s_serialnum, 0, 1) == \'"E\'}> '
//			+ ' <p>${detailList.e_venue }</p> '
//			+ ' </c:if> '
//			+ '	<div class="circle"><div class="edge"></div></div> '
//			+ '	<p>${detailList.s_location }</p> '
//			+ ' </div> '
//			+ ' </c:when> '
//			+ ' <c:otherwise> '
//			+ ' <div class="schedule"> '
//			+ ' <p>${detailList.p_spotname }</p> '
//			+ ' <c:if test="${fn:substring(detailList.s_serialnum, 0, 1) == \'"E\'}> '
//			+ '	<p>${detailList.e_venue }</p> '
//			+ ' </c:if> '
//			+ '	<div class="circle"><div class="edge"></div></div> '
//			+ '	<p>${detailList.s_location }</p> '
//			+ ' </div> '
//		+ ' </c:otherwise> '
//	+ ' </c:choose> '
//+ ' </c:forEach> '
//+ '	</div>'
//+ '</c:forEach>';
//	
//	date.innerHTML += url;
//	date.innerHTML += '</div>';

});
