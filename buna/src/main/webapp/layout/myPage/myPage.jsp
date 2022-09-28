<%@page import="java.sql.Timestamp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="plan.PlanInfoDTO"%>
<%@page import="plan.PlanDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<%
	//테스트용
	String nick="gk";
	session.setAttribute("nick_s", nick);
	
	//세션 값 받아오기
// 	String nickSession = (String)session.getAttribute("nick_s");
// 	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
	
	MemberDAO Mdao = MemberDAO.getInstance();
	MemberDTO member = Mdao.getMember(nick);
	
	//member객체를 "member"에 저장 -> String 타입이 된다. 
	request.setAttribute("member", member);

	//플랜 목록 가져오기
	PlanDAO dao = PlanDAO.getInstance();
	ArrayList<PlanInfoDTO> list = dao.getPlanInfo(nick);
	request.setAttribute("infolist", list);
	
	//d-day 계산
	Timestamp now = new Timestamp(System.currentTimeMillis());
%>
<!DOCTYPE html>
<html>
<head>
<title>[마이페이지] | 부랑나랑</title>
<link rel="stylesheet" href="styles/normalize.css">
<link rel="stylesheet" href="styles/myPage_style.css?v=3">
<script type="text/javascript" src="scripts/jquery-3.6.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
<script type="text/javascript" src="scripts/mypage.js"></script>
</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
    
    <div class="header">
        <img src="images/logo.png" alt="" onclick="location.href='index.jsp'">
    </div> <!--헤더 끝-->

${now }
    <div class="inner">
	    <h1>MY PAGE</h1>
<%--     	<h3><span>${member.m_nickname }</span>님 즐거운 여행되세요~</h3> --%>
        <!--nav-->
        <div class="mypage_wrap">
            <ul class="mypage_nav">
                <li class="active">나의 플랜목록</li>
                <li>회원정보수정</li>
            </ul>
            
            <div class="mypage_content">
                <!-- 나의 플랜목록 -->
                <div class="mypage_plan active">
                    <h2>나의 플랜 목록</h2>
                    <c:if test="${infolist.size() != 0 }"> <!-- List컬렉션이니까 size 사용 -->
                        <c:forEach var="i" begin="0" end="<%=list.size()-1%>">
                            <div class="myplan_wrap">
                                <div class="myplan_content">
                                    <div class="con">
                                    	<p class="image">
	                                    	<img src="images/mtop${i+1}.jpg">
                                    	</p>
                                    	<div class="plan_con">
	                                        <div class="plantitle">
	                                        	<p>
		                                            <span class="bold">여행 이름 </span>
		                                            ${infolist[i].p_title}
	                                            </p>
	                                            <p>
		                                            <span class="bold">여행 일정</span>
  		                                            <c:set value="${fn:substring(infolist[i].p_firstdate, 0, 10)}"
		                                                var="firstdate"/>
		                                            <c:set value="${fn:substring(infolist[i].p_lastdate, 0, 10)}"
		                                                var="lastdate"/>
		                                            <c:choose>
		                                                <c:when test="${firstdate eq lastdate}">
		                                                    ${firstdate}
		                                                </c:when>
		                                                <c:otherwise>
		                                                    ${firstdate} ~ ${lastdate}
		                                                </c:otherwise>
		                                            </c:choose>
	                                            </p>
	                                        </div>
	                                        <div class="tag">
	                                            <span class="bold">태그 </span> <b>${infolist[i].t_namelist}</b>
	                                        </div>
			                                <div class="myplan_management">
			                                	<input type="button" class="detail" value="자세히 보기" onclick="location.href='planDetail.jsp?rownum=${infolist[i].p_rownum}'">
			                                    <c:set value="${infolist[i].p_public}" var="shared" />
			                                    <c:choose>
			                                        <c:when test="${shared == 1}">
			                                            <input type="button" name="plan_share" value="일정 비공개" class="share" onclick="sharecheck('${infolist[i].p_public}', ${infolist[i].p_rownum})">
			                                        </c:when>
			                                        <c:otherwise>
			                                            <input type="button" name="plan_share" value="일정 공개" class="share" onclick="sharecheck('${infolist[i].p_public}', ${infolist[i].p_rownum})">
			                                        </c:otherwise>
			                                    </c:choose>
			                                    <input type="button" name="plan_delete" class="p_delete" value="일정 삭제" onclick="delete_ok(${infolist[i].p_rownum})"><br>
			                                </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
                
                <!-- 회원 정보 수정 -->
                <div class="mypage_edit">
    <%--                 <form action="infoEditOk.jsp?current_nickname=<%=URLEncoder.encode(member.getM_nickname(), "utf-8")%>"  --%>
                    <h2>회원 정보 수정</h2>
                    <div class="form_wrap">
	                    <form action="infoEditOk.jsp" 
	                        method="post" name="info_edit_form">
	                        <div class="edit_content">
		                        <div>
		                            <span class="bold">닉네임</span> ${member.m_nickname }
		                        </div>
		                        <div>
		                            <span class="bold">새 비밀번호</span>
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
		                            <input type="radio" name="m_gender" value="0">여성
		                        </div>
		                        <div style="text-align: center">
		                            <input type="button" name="info_edit"
		                                value="정보 수정" id="infoCheck" onclick="info_Check()">
		                            <input type="button" name="info_delete" value="회원 탈퇴"
		                                onclick="location.href='signOut.jsp?nick=<%=nick%>'">
		    <%--                                onclick="location.href='signOut.jsp?nick=<%=URLEncoder.encode(member.getM_nickname(), "utf-8")%>'"> --%>
		                        </div>
		                    </div>
	                    </form>
                    </div>
                </div> <!-- mypage_edit -->
            </div> <!-- mypage_plan -->
        </div> <!--mypage_wrap-->
    </div>    
    
    
    <!-- 생년, 성별 바로 나타내기 위해 보내는 변수 -->
    <script>
    	var birthYear = "${member.m_birthyear}";
    	var gender = "${member.m_gender}";
    </script>
</body>
</html>
