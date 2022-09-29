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
<style type="text/css">
	.test { color: red;}
</style>
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
		function setCount() {
			document.cookie = "count=1";
		}
		
		function getCount() {
			var count = getCookie("count");
			
			return count;
		}
		
		function setCookie(sname) {
			// 쿠키 생성 후 모달 종료
			document.cookie = "cookie="+sname;
			$('.black').addClass('hidden');
			var cookie = getCookie("cookie");
			/* var w = "<li>"+cookie+"<br> </li>";
			$('.hi').append(cookie); */
			
			if(getCount() == null) setCount();
			var count = document.createTextNode(getCount());
			var cnt = getCount();
			
			var listDiv = document.createElement("div");
			var listText = document.createTextNode(cookie);
			var br = document.createElement("br");
			listDiv.appendChild(listText);
			listDiv.appendChild(count);
			listDiv.appendChild(br);
			listDiv.classList.add("test");
			listDiv.setAttribute("onClick", "change(this)");
			
			document.getElementById("hi").appendChild(listDiv);
			// delete cookie 추가
			
			cnt++;
			document.cookie = "count="+cnt;
		}
		
		function change(a) {
			//nextSibling
			var prev = a.previousSibling;
			var parent = a.parentNode;
			console.log(parent);
			if(prev != null) {
				// 노드 이동 로직 
				parent.insertBefore(a, prev);
				parent.insertBefore(prev, a);
			}
		}
		
		
		function getCookie(name) {
            var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
            return value? value[2] : null;
        }
	</script>
</body>
</html>