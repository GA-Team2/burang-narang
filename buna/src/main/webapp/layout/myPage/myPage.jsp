<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="plan.PlanInfoDTO"%>
<%@page import="plan.PlanDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
%>
<%
	//테스트용
	String m_nickname="gk";
	
	//세션 값 받아오기
	session.getAttribute("nick");
	
	MemberDAO Mdao = MemberDAO.getInstance();
	MemberDTO member = Mdao.getMember(m_nickname);
	
	//member객체를 "member"에 저장
	request.setAttribute("member", member);

	//플랜 목록 가져오기
	PlanDAO Pdao = PlanDAO.getInstance();
	ArrayList<PlanInfoDTO> list = Pdao.getPlanInfo(m_nickname);
	
	request.setAttribute("infolist", list);

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
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
        <h1><span class="bold">MY PAGE</span></h1>
        <ul class="mypage_nav">
            <li class="active">나의 플랜목록</li>
            <li>회원정보수정</li>
        </ul>
        
        <div class="mypage_content">
            <!-- 나의 플랜목록 -->
            <div class="mypage_plan active">
                <form action="" method="post" name="myplan">
                    <h2>나의 플랜 목록</h2>
                   	<c:forEach var="i" begin="0" 
                   			   end="<%=list.size()-1%>">
	                    <div class="myplan_wrap">
	                        <div class="myplan_content">
                        		<a href="../planDetail/myPlan.jsp?rownum=${infolist[i].p_rownum}">
	                                <p>
	                                	<span class="bold">제목 </span>
	                                	${infolist[i].p_title}
	                                </p>
	                                <p>
	                                	<span class="bold">일정 </span>
	                                	${infolist[i].p_firstdate} - ${infolist[i].p_lastdate}
	                                </p>
	                                <p>
	                                	<span class="bold">태그 </span> ${infolist[i].t_namelist}
	                                </p>
                        		</a>
	                        </div>
	                        <div class="myplan_management">
	                            <input type="button" name="plan_edit" value="수정" onclick="">
	                            <input type="button" name="plan_delete" value="삭제" onclick="delete_ok()"><br>
	                            <input type="button" name="plan_share" value="공유" class="share" onclick="sharecheck()">
	                        </div>
                    	</div>
                   	</c:forEach>
                </form>
            </div>
            
	       	<!-- 회원 정보 수정 -->
	        <div class="mypage_edit">
	            <form action="editOk.jsp?current_nickname=<%=URLEncoder.encode(member.getM_nickname(), "utf-8")%>" 
	            	  method="post" name="info_edit_form">
	                <h2>회원 정보 수정</h2>
	                <div>
	                    <span class="bold">닉네임</span>
	                    <input type="text" name="m_nickname" 
	                    	   id="nickname" value="${member.m_nickname}">
	                    <input type="button" value="중복확인" 
	                    	   onclick="nickname_check()">
	                    <input type="hidden" id="Duplication"
	                    	   value="NicknameChecked" onclick="nickname_check()">
	                 	<p id="nicknameCheckResult"></p>
	                </div>
	                <div>
	                    <span class="bold">비밀번호</span>
	                    <input type="password" name="m_password" id="password">
	                 	<p id="pwCheckResult"></p>
	                </div>
	                <div>
	                    <span class="bold">비밀번호 확인</span>
	                    <input type="password" name="pwd_check" id="pwcheck">
	                 	<p id="pwConfirmCheckResult"></p>
	                </div>
	                <div>
	                    <span class="bold">생년</span>
	                    <select name="m_birthyear" id="year"></select>년
	                </div>
	                <div>
	                    <span class="bold">성별</span>
	                    <input type="radio" name="m_gender" value="1" checked>남성
	                    <input type="radio" name="m_gender" value="2">여성
	                </div>
	                <div>
		                <input type="button" name="info_edit"
		                	   value="정보 수정" id="infoCheck" onclick="info_Check()">
		                <input type="button" name="info_delete" value="회원 탈퇴"
		                	   onclick="location.href='signOut.jsp?current_nickname=<%=URLEncoder.encode(member.getM_nickname(), "utf-8")%>'">
	            	</div>
	            </form>
	        </div> <!-- mypage_edit -->
        </div> <!-- mypage_plan -->
    </div> <!--mypage_wrap-->
    
    
    <script>
    	var birthYear = "${member.m_birthyear}";
    	var gender = "${member.m_gender}";
    </script>
</body>
</html>
