<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- tablib import -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	/* 
		파일 간의 한글 깨짐 방지 캐릭터 인코딩
	*/
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	/* 닉네임 중복여부를 가지고 오는 파라미터 변수 선언  */
	String nickC = request.getParameter("nickC");
	/* 중복체크 여부 및 닉네임 입력칸에 들어갈 닉네임을 가져오는 파라미터 변수 선언 */
	String nickR = request.getParameter("nickN");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpPage | 부랑나랑</title>

	<link rel="stylesheet" href="../../styles/normalize.css" />
    <link rel="stylesheet" href="../../styles/style_signUp.css" />
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="../../scripts/script_signUp.js"></script>
    
    <!-- 쿼리스트링을 숨겨주는 스크립트 -->
    <script>history.replaceState({}, null, location.pathname);</script>
</head>
<body>
	<!-- 받아온 nickR을 text value에 넣어 스크립트로 value를 넘겨주는 input -->
	<input type="text" value="<% if(nickR == null){out.print(0);} else {out.print(nickR);} %>" name="nickR_forJs" id="nickR_forJs">
	<!-- 받아온 nickC을 text value에 넣어 스크립트로 value를 넘겨주는 input -->
	<input type="text" value="<% if(nickC == null){out.print("2");} else {out.print(nickC);} %>" name="nickC_forJs" id="nickC_forJs">
	
	<!--
	 	전체 틀 
	 -->
	<div class="wrap inner">
	  <!-- 
	  	회원가입 영역 
	  -->
      <div class="signUpBox">
      	<img id="logo" src="../../images/logo_whole.png">
        <!-- 
        	회원정보 form 
        -->
        <form name="signUp" method="post" action="SignUpOk.jsp">
          <!-- 
          	닉네임 입력 영역 
          -->
          <div class="nicknameBox">
            <p>닉네임</p>
            <!-- 닉네임 입력 input(nickR 값이 null이 아닐 경우 value에 넣음) -->
            <input type="text" name="memberNickname" id="memberNickname" value="<% if(nickR != null){out.print(nickR);}%>" placeholder="닉네임은 최대 6자까지 가능합니다."/>
            <!-- 중복체크 버튼 -->
            <input type="button" name="nickCheck" id="nickCheck" onclick="nick_check()" value="중복체크">
            <!-- 
            	경고문은 모두 display:none 처리 
            -->
            <!-- 닉네임을 입력하지 않을 시 경고문 -->
           	<p id="nicknameWarn1">필수 항목입니다.</p>
           	<!-- 
           		닉네임 체크를 위한 조건문 
           	-->
           	<%
           		if("1".equals(nickC)){
           	%>		<!-- 중복체크 후 중복되는 닉네임이 존재 시 경고문 -->
  	         		<p id="nicknameWarn2">중복되는 닉네임이 존재합니다.</p>
           	<%		
           		} else if("0".equals(nickC)){
           	%>		<!-- 중복체크 후 중복되는 아이디가 존재 시 경고문 -->
  	         		<p id="nicknameWarn2_1">사용 가능한 닉네임입니다.</p>
           	<%
           		}
           	%>
           	<!-- 닉네임이 6자를 넘을 경우 경고문 -->
           	<p id="nicknameWarn3">닉네임은 최대 6자까지 가능합니다.</p>
           	<!-- 중복체크를 하지 않았을 시 경고문 -->
           	<p id="nicknameWarn4">중복체크를 하지않았습니다.</p>
          </div>
          <!--
          		비밀번호 입력 영역
          -->
          <div class="pwdBox">
            <p>비밀번호</p>
            <!-- 비밀번호 input -->
            <input type="password" name="memberPassword" id="memberPassword" placeholder="비밀번호는 영문자/특수문자를 포함한 8글자 이상이어야 합니다." />
            <!-- 비밀번호 미입력 시 경고문  -->
            <p id="pwdWarn1">필수 항목입니다.</p>
            <!-- 비밀번호에 영문자/특수문자를 포함하지 않은 경우 경고문 -->
            <p id="pwdWarn2">비밀번호는 영문자/특수문자를 포함한 8글자 이상이어야 합니다.</p>
          </div>
          <!--
           		비밀번호 확인 입력 영역 
           -->
          <div class="pwdCommitBox">
            <p>비밀번호 확인</p>
            <!-- 비밀번호 확인 input -->
            <input type="password" name="pwdCommit" id="pwdCommit" />
            <!-- 비밀번호와 일치하지 않을 경우 경고문 -->
            <p id="pwdWarn3">비밀번호와 일치하지않습니다.</p>
          </div>
          <!--
           		탄생년도 입력 영역 
           -->
          <div class="birthBox">
            <p>탄생년도</p>
            <!-- 탄생년도 input -->
            <input type="text" name="memberBirthday" id="memberBirthday" placeholder="년도만 써주세요" />
            <!-- 탄생년도 미입력 시 경고문 -->
            <p id="birthWarn1">필수 항목입니다.</p>
            <!-- 탄생년도가 1922년~2022년 사이로 입력되지 않았을 경우 경고문 -->
            <p id="birthWarn2">1922~2022년까지만 입력해주세요</p>
            <!-- 숫자를 제외한 다른 문자가 들어갔을 경우 경고문 -->
           	<p id="birthWarn3">숫자만 입력해주세요</p>
          </div>
          <!-- 
          		성별 선택 영역 
          -->
          <div class="genderBox">
          	   <!-- 남성 선택 radio(value를 1로 설정해서 boolean 기능으로 사용) -->
		            남성<input type="radio" name="memberGender" id="man" value="1" />
          	   <!-- 여성 선택 radio(value를 0로 설정해서 boolean 기능으로 사용) -->
		            여성<input type="radio" name="memberGender" id="woman" value="0" />
		    <!-- 성별 미선택 시 경고문 -->
            <p id="genderWarn">필수 항목입니다.</p>
          </div>
          <input id="signCommit" type="button" value="가입하기" onclick="sign_ok()" />
          <input id="home" type="button" value="홈으로" onclick="window.location.href='Index.jsp'">
        </form>
      </div>
    </div>
</body>
</html>