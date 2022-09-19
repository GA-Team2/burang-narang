<%@page import="signUpPackage.SignUpDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String nick_check = request.getParameter("nickname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpPage | 부랑나랑</title>

	<link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/style_signUp.css" />
    
</head>
<body>
	<div class="wrap inner">
      <div class="signUpBox">
        <h1>부랑나랑</h1>
        <form name="signUp" method="post" action="signUpOk.jsp">
          <div class="nicknameBox">
            <p>닉네임</p>
            <input type="text" name="m_nickname" />
           	<p id="nicknameWarn1">필수 항목입니다.</p>
           	<c:set var="nick_check" value="<%= nick_check %>"></c:set>
           	<c:if test="${nick_check != null}">
  	         	<p id="nicknameWarn2">중복되는 닉네임이 존재합니다.</p>
           	</c:if>
           	<p id="nicknameWarn3">닉네임은 최대 6자까지 가능합니다.</p>
          </div>
          <div class="pwdBox">
            <p>비밀번호</p>
            <input type="text" name="m_password" />
            <p id="pwdWarn1">필수 항목입니다.</p>
            <p id="pwdWarn2">비밀번호는 영문자/특수문자를 포함해야합니다</p>
          </div>
          <div class="pwdCommitBox">
            <p>비밀번호 확인</p>
            <input type="text" name="pwdCommit" />
            <p id="pwdWarn3">필수 항목입니다.</p>
          </div>
          <div class="birthBox">
            <p>탄생년도</p>
            <input type="text" name="m_birthyear" placeholder="년도만 써주세요" />
            <p class=""></p>
          </div>
          <div class="genderBox">
		            남성<input type="radio" name="m_gender" id="man" value="man" />
		            여성<input type="radio" name="m_gender" id="woman" value="woman" />
          </div>
          <input type="submit" value="가입하기" onclick="" />
        </form>
      </div>
    </div>
</body>
</html>