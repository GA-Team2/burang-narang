<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- tablib import -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpPage | 부랑나랑</title>

	<link rel="stylesheet" href="../../styles/normalize.css" />
    <link rel="stylesheet" href="../../styles/style_signUp.css" />
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
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
        <form name="signUp" method="post" action="signup/ok">
          <!-- 
          	닉네임 입력 영역 
          -->
          <div class="nicknameBox">
            <p>닉네임</p>
            <!-- 닉네임 입력 input(nickR 값이 null이 아닐 경우 value에 넣음) -->
            <input type="text" name="memberNickname" id="memberNickname" placeholder="닉네임은 최대 6자까지 가능합니다."/>
            <!-- 닉네임 유효성 출력문 -->
           	<p id="nicknameWarn"></p>
          </div>
          <!--
          		비밀번호 입력 영역
          -->
          <div class="pwdBox">
            <p>비밀번호</p>
            <!-- 비밀번호 input -->
            <input type="password" name="memberPassword" id="memberPassword" placeholder="비밀번호는 영문자/특수문자를 포함한 8글자 이상이어야 합니다." />
            <!-- 비밀번호 유효성 출력문  -->
            <p id="pwdWarn"></p>
          </div>
          <!--
           		비밀번호 확인 입력 영역 
           -->
          <div class="pwdCommitBox">
            <p>비밀번호 확인</p>
            <!-- 비밀번호 확인 input -->
            <input type="password" name="pwdCommit" id="pwdCommit" />
            <!-- 비밀번호와 일치하지 않을 경우 경고문 -->
            <p id="pwdWarnCommit"></p>
          </div>
          <!--
           		탄생년도 입력 영역 
           -->
          <div class="birthBox">
            <p>탄생년도</p>
            <!-- 탄생년도 input -->
            <input type="text" name="memberBirthyear" id="memberBirthyear" placeholder="년도만 써주세요" />
            <!-- 탄생년도 유효성 경고문 -->
            <p id="birthWarn"></p>
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
            <p id="genderWarn"></p>
          </div>
          <input id="signCommit" type="button" value="가입하기" onclick="sign_ok()" />
          <input id="home" type="button" value="홈으로" onclick="window.location.href='/'">
        </form>
      </div>
    </div>
    <script src="../../scripts/script_signUp.js"></script>
</body>
</html>