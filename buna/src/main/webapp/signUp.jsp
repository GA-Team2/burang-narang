<%@page import="signUpPackage.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	/* 중복확인 체크를 위한 signOk.jsp로부터 넘겨받은 nickname */
	String nickC = request.getParameter("nickC");
	String nickR = request.getParameter("nickN");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpPage | 부랑나랑</title>

	<link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/style_signUp.css" />
    <link rel="stylesheet" href="template.css?ver=1.3">
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="script/script_signUp.js"></script>
    <script>
    	function nick_check(){
    		if(signUp.m_nickname.value.length == 0){
	    		var nickWarn1 = document.getElementById("nicknameWarn1");
	    		var nickWarn2 = document.getElementById("nicknameWarn2");
	    		var nickWarn2_1 = document.getElementById("nicknameWarn2_1");
	    		nickWarn1.style.display = 'block';
	    		if(nickWarn2 == null){
	    			nickWarn2_1.classList.add("hidden");
	    		} else {
		    		nickWarn2.classList.add("hidden");
	    		}
	    		signUp.m_nickname.focus();
	    		return;
    		} else {
		    	var nick_input = document.getElementById("m_nickname").value;
    			var nickWarn1 = document.getElementById("nicknameWarn1");
    			nickWarn1.style.display = 'none';
    			
    			location.href = "nickCheck.jsp?nick=" + nick_input;
    		}
    	}
    </script>
</head>
<body>
	<input type="text" value="<% if(nickC == null){out.print("2");} else {out.print(nickC);} %>" name="nickC_forJs" id="nickC_forJs">
	<div class="wrap inner">
      <div class="signUpBox">
        <h1>부랑나랑</h1>
        <form name="signUp" method="post" action="signUpOk.jsp">
          <div class="nicknameBox">
          <!-- 밑의 경고문은 모두 display:none 처리 -->
            <p>닉네임</p>
            <input type="text" name="m_nickname" id="m_nickname" value='<% if(nickR != null){out.print(nickR);}%>'/>
            <input type="button" name="nickCheck" id="nickCheck" onclick="nick_check()" value="중복체크">
           	<p id="nicknameWarn1">필수 항목입니다.</p>
           	<!-- 닉네임 체크를 위한 조건문 -->
           	<%
           		if("1".equals(nickC)){
           	%>
  	         		<p id="nicknameWarn2">중복되는 닉네임이 존재합니다.</p>
           	<%		
           		} else if("0".equals(nickC)){
           	%>
  	         		<p id="nicknameWarn2_1">사용 가능한 닉네임입니다.</p>
           	<%
           		}
           	%>
           	<p id="nicknameWarn3">닉네임은 최대 6자까지 가능합니다.</p>
           	<p id="nicknameWarn4">중복체크를 하지않았습니다.</p>
          </div>
          <div class="pwdBox">
            <p>비밀번호</p>
            <input type="password" name="m_password" id="m_password" />
            <p id="pwdWarn1">필수 항목입니다.</p>
            <p id="pwdWarn2">비밀번호는 영문자/특수문자를 포함한 8글자 이상이어야 합니다.</p>
          </div>
          <div class="pwdCommitBox">
            <p>비밀번호 확인</p>
            <input type="password" name="pwdCommit" id="pwdCommit" />
            <p id="pwdWarn3">비밀번호와 일치하지않습니다.</p>
          </div>
          <div class="birthBox">
            <p>탄생년도</p>
            <input type="text" name="m_birthyear" id="m_birthyear" placeholder="년도만 써주세요" />
            <p id="birthWarn1">필수 항목입니다.</p>
            <p id="birthWarn2">1922~2022년까지만 입력해주세요</p>
           	<p id="birthWarn3">숫자만 입력해주세요</p>
          </div>
          <div class="genderBox">
		            남성<input type="radio" name="m_gender" id="man" value="1" />
		            여성<input type="radio" name="m_gender" id="woman" value="0" />
            <p id="genderWarn">필수 항목입니다.</p>
          </div>
          <input type="button" value="가입하기" onclick="sign_ok()" />
        </form>
      </div>
    </div>
</body>
</html>