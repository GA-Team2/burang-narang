<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<%
	String m_nickname="gk";

	MemberDAO dao = MemberDAO.getInstance();
	MemberDTO member = dao.getMember(m_nickname);
%>
<!DOCTYPE html>
<html>
<head>
<title>[마이페이지] | 부랑나랑</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/myPage_style.css">
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>

</head>
<body>

    <div class="mypage_wrap">

        <ul class="mypage_nav">
            <li><span class="bold">MY PAGE</span></li>
            <li><a href="">회원정보수정</a></li>
            <li><a href="">나의 플랜목록</a></li>
        </ul>
        
        
        <div class="mypage_content">
            <!-- 나의 플랜목록 -->
            <div class="mypage_plan">
                <form action="" method="post" name="myplan">
                    <h1>나의 플랜 목록</h1>
                    <div class="myplan_wrap">
                        <div class="myplan_content">
                            <a href="../planDetail/myPlan.jsp">
                                <p class="myplan_date"><span class="bold">제목 </span> 바다여행</p>
                                <p class="myplan_date"><span class="bold">일정 </span> 1월 1일-1월 2일</p>
                                <p class="myplan_date"><span class="bold">태그 </span> #바다 #어쩌구 #저쩌구</p>
                            </a>
                        </div>
                        <div class="myplan_management">
                            <input type="button" name="plan_edit" value="수정" onclick="">
                            <input type="button" name="plan_delete" value="삭제" onclick="delete_ok()"><br>
                            <input type="button" name="plan_share" value="공유" class="share" onclick="sharecheck()">
                        </div>
                    </div>
                </form>
            </div>

        	<!-- 회원 정보 수정 -->
            <div class="mypage_edit">
                <form action="editOk.jsp?current_nickname=<%=URLEncoder.encode(member.getM_nickname(), "utf-8")%>" method="post" name="info_edit_form">
                    <h1>회원 정보 수정</h1>
                    <p>
                        <span class="bold">닉네임</span>
                        <input type="text" name="m_nickname" id="nickname" value="<%=member.getM_nickname()%>">
                        <input type="button" value="중복확인" onclick="nickname_check()">
                        <input type="hidden" id="Duplication" value="NicknameChecked" onclick="nickname_check()">
                    </p>
                    <p>
                        <span class="bold">비밀번호</span>
                        <input type="password" name="m_password" id="password">
                    </p>
                    <p>
                        <span class="bold">비밀번호 확인</span>
                        <input type="password" name="pwd_check" id="pwcheck">
                    </p>
                    <p>
                        <span class="bold">생년</span>
                        <select name="m_birthyear" id="year"></select>년
                    </p>
                    <p>
                        <span class="bold">성별</span>
                        <input type="radio" name="m_gender" value="1" checked>남성
                        <input type="radio" name="m_gender" value="2">여성
                    </p>
                    <p class="checkResult"></p>
                    <input type="button" name="info_edit" value="정보 수정" id="infoCheck" onclick="info_Check()">
                    <input type="button" name="info_delete" value="회원 탈퇴" onclick="location.href='signOut.jsp?current_nickname=<%=URLEncoder.encode(member.getM_nickname(), "utf-8")%>'">
                </form>
            </div>
        </div>
    </div> <!--mypage_wrap-->
</body>
</html>
