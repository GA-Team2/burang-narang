 <%@page import="java.net.URLDecoder"%>
<%@page import="org.ga2.buna.dto.PlanInfoDTO"%>
<%@page import="org.ga2.buna.dao.PlanDAO"%>
<%@page import="org.ga2.buna.dto.MemberDTO"%>
<%@page import="org.ga2.buna.dao.MemberDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	//세션 값 받아오기
	String nickSession = (String) session.getAttribute("nick_s");
	String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
	
	MemberDAO Mdao = MemberDAO.getInstance();
	
	//memberDTO 받아오기(정보 수정용)
	MemberDTO member = Mdao.getMember(nick);
	//member객체를 "member"에 저장 -> String 타입이 된다. 
	request.setAttribute("member", member);
	
	//플랜 목록 가져오기
	PlanDAO dao = PlanDAO.getInstance();
	ArrayList<PlanInfoDTO> list = dao.getPlanInfo(nick);
	request.setAttribute("infolist", list);
%>

<!DOCTYPE html>
<html>
<head>
	<title>마이페이지 | 부랑나랑</title>
	<!-- css초기화 -->
	<link rel="stylesheet" href="styles/normalize.css">
	<!-- myPage CSS 적용 -->
	<link rel="stylesheet" href="styles/myPage_style.css">
	<script	src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<!-- 뒤로가기 방지 -->
<body>
	<div class="header">
		<img src="images/logo.png" alt="" onclick="location.href='Index.jsp'">
	</div>
	<!--헤더 끝-->

	<div class="inner">
		<h1>MY PAGE</h1>
		<!--nav 영역-->
		<div class="mypage_wrap">
			<ul id="mypage_nav">
				<li class="active">나의 플랜목록</li>
				<li>회원정보수정</li>
			</ul>

			<div id="mypage_content">
				<!-- 나의 플랜목록 -->
				<div class="mypage_plan active">
					<h2>나의 플랜 목록</h2>
					<!-- 
						플랜을 작성하지 않아도 마이페이지 접속이 가능하도록
						ArrayList의 size가 0이 아닐 때만 size만큼 반복하면서
						 여행 이름, 일정, 태그 출력
					-->
					<c:if test="${infolist.size() != 0 }">
						<c:forEach var="i" begin="0" end="<%=list.size() - 1%>">
							<div class="myplan_wrap">
								<div class="myplan_content">
									<div class="con">
										<p class="image">
											<img src="images/mtop${i+1}.jpg">
										</p>
										<div class="plan_con">
											<div class="plantitle">
												<p>
													<span class="bold">여행 이름 </span> ${infolist[i].planTitle}
												</p>
												<p>
													<span class="bold">여행 일정</span>
													<c:set
														value="${fn:substring(infolist[i].planFirstDate, 0, 10)}"
														var="firstdate" />
													<c:set
														value="${fn:substring(infolist[i].planLastDate, 0, 10)}"
														var="lastdate" />
													<c:choose>
														<%--여행 일수가 1일인 경우는 첫번째날만 출력되게--%>
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
												<span class="bold">태그 </span> <b>${infolist[i].tagNameList}</b>
											</div>
											<div class="myplan_management">
												<!-- 플랜 자세히보기 -->
												<input type="button" class="detail" value="자세히 보기"
													onclick="location.href='PlanDetail.jsp?mypage=true&rownum=${infolist[i].planRowNum}'">
												<!-- 공개여부가 1이면 비공개 버튼 출력, 0이면 공개버튼 출력 -->
												<c:set value="${infolist[i].planPublic}" var="shared" />
												<c:choose>
													<c:when test="${shared == 1}">
														<input type="button" name="plan_share" value="일정 비공개"
															class="share"
															onclick="sharecheck('${infolist[i].planPublic}', ${infolist[i].planRowNum})">
													</c:when>
													<c:otherwise>
														<input type="button" name="plan_share" value="일정 공개"
															class="share"
															onclick="sharecheck('${infolist[i].planPublic}', ${infolist[i].planRowNum})">
													</c:otherwise>
												</c:choose>
												<input type="button" name="plan_delete" class="p_delete"
													value="일정 삭제" onclick="delete_ok(${infolist[i].planRowNum})"><br>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>

				<!-- 
					회원 정보 수정 메뉴 
					getMember()로 얻어온 정보를 저장해서 출력
				-->
				<div class="mypage_edit">
					<h2>회원 정보 수정</h2>
					<div class="form_wrap">
						<form action="InfoEditOk.jsp" method="post" name="info_edit_form">
							<div class="edit_content">
								<div>
									<span class="bold">닉네임</span> ${member.memberNickname }
								</div>
								<div>
									<span class="bold">새 비밀번호</span>
									<input type="password"
										name="memberPassword" id="password">
									<p id="pwCheckResult"></p>
								</div>
								<div>
									<span class="bold">비밀번호 확인</span>
									<input type="password"
										name="pwd_check" id="pwcheck">
									<p id="pwConfirmCheckResult"></p>
								</div>
								<div>
									<span class="bold">생년</span>
									<select name="memberBirthyear"
										id="year"></select>년
								</div>
								<div>
									<span class="bold">성별</span>
									<input type="radio"
										name="memberGender" value="1" checked>남성
									<input type="radio"
										name="memberGender" value="0">여성
								</div>
								<div style="text-align: center">
									<input type="button" name="info_edit" value="정보 수정"
										id="infoCheck" onclick="info_Check()">
									<input type="button" name="info_delete" value="회원 탈퇴"
										onclick="location.href='SignOut.jsp'">
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- mypage_edit끝 -->
			</div>
			<!-- mypage_plan끝 -->
		</div>
		<!--mypage_wrap끝-->
	</div>


	<!-- 생년, 성별 바로 나타내기 위해 보내는 변수 -->
	<script>
    	var db_birthYear = "${member.memberBirthyear}";
    	var db_gender = "${member.memberGender}";
    </script>
	<!-- js -->
	<script type="text/javascript" src="scripts/mypage.js"></script>
</body>
</html>