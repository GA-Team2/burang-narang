<%@page import="bn.spot.SpotDB"%>
<%@page import="bn.spot.Spot"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- js -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<% 
		Spot spot = new Spot();
		spot = (new SpotDB()).getSpot("스팟 이름");
	%>
	
	<%= spot.getS_name() %> <br>
	<%= spot.getS_type() %> <br>
	<%= spot.getS_content() %> <br>
	<%= spot.getS_pop() %> <br>
	
	<input type="submit" value="추가하기" onclick="setCookie('<%= spot.getS_name() %>')">
	
	<script>
		function setCookie(sname) {
			// 쿠키 생성 후 모달 종료
			document.cookie = "cookie="+sname;
			$('.black').addClass('hidden');
			var cookie = getCookie("cookie");
			var w = "<li>"+cookie+"<br> </li>";
			$('.hi').append(cookie);
		}
		
		function getCookie(name) {
            var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
            return value? value[2] : null;
        }
	</script>
</body>
</html>