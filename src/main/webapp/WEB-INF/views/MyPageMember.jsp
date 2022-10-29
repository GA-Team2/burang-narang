<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원정보수정 | 부랑나랑</title>
    <!-- css초기화 -->
    <link rel="stylesheet" href="/styles/normalize.css">
    <!-- myPage CSS 적용 -->
    <link rel="stylesheet" href="/styles/style_myPage.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

    <input type="hidden" value="${sessionScope.nick_s}" id="nick_s">
    <jsp:include page="Gnb.jsp"/>
    <div class="inner">
        <h1>MY PAGE</h1>
        <!--nav 영역-->
        <div class="mypage_wrap">
            <ul id="mypage_nav">
              <li><a href="/mypage">나의 플랜목록</a></li>
              <li class="active"><a href="/mypage/info">회원정보수정</a></li>
            </ul>

            <!-- mypage_content 시작 -->
            <div id="mypage_content">
                <!-- 회원 정보 수정 -->
                <div class="mypage_edit">
                    <h2>회원 정보 수정</h2>
                    <div class="form_wrap">
                        <form name="infoEdit" id="editform">
                            <div class="edit_content">
                                <div>
                                    <span class="bold">닉네임</span> ${member.memberNickname }
                                </div>
                                <div>
                                    <span class="bold">현재 비밀번호</span>
                                    <input type="password"
                                           name="memberPassword" id="currentpassword">
                                    <input type="button" value="일치확인" onclick="pwcheckajax()" id="pwajax">
                                    <p id="currentpwcheck"></p>
                                </div>
                                <div>
                                    <span class="bold">새 비밀번호</span>
                                    <input type="password"
                                           name="memberPassword" id="password">
                                    <p id="pwCheckResult"></p>
                                </div>
                                <div>
                                    <span class="bold">비밀번호 확인</span>
                                    <input type="password" id="pwcheck">
                                    <p id="pwConfirmCheckResult"></p>
                                </div>
                                <div>
                                    <span class="bold">생년</span>
                                    <select name="memberBirthyear"
                                            id="year"></select>년
                                </div>
                                <div>
                                    <span class="bold">성별</span>
                                    <input type="radio" name="memberGender" value="1">남성
                                    <input type="radio" name="memberGender" value="2">여성
                                    <input type="hidden" id="db_birthYear" value="${member.memberBirthyear}">
                                    <input type="hidden" id="db_gender" value="${member.memberGender}">
                                </div>
                                <div style="text-align: center">
                                    <input type="button" name="info_edit" value="정보 수정"
                                           id="infoCheck" onclick="info_Check()">
                                    <input type="button" name="info_delete" value="회원 탈퇴"
                                           onclick="location.href='/mypage/signout'">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- 회원 정보 수정 끝 -->
            </div>
            <!-- mypage_content끝 -->
        </div>
        <!--mypage_wrap끝-->
    </div>


<%--	<script>
        //쿼리스트링 숨겨주는 스크립트
        history.replaceState({}, null, location.pathname);
    </script>--%>
<!-- js -->
<script type="text/javascript" src="/scripts/mypage_member.js"></script>
</body>
</html>