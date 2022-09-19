<%@page import="org.ga2.buna.dto.TagDto"%>
<%@page import="org.ga2.buna.dao.TagDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	TagDao tDao = new TagDao();
	ArrayList<TagDto> tagList = tDao.listTag();
	request.setAttribute("tagList", tagList);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>새 플랜 작성 | 부랑나랑</title>
<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.css" />
</head>
<body>
	<!-- 새 플랜 작성 Modal -->
	<section id="modal_area" class="modal_zone">
		<div id="modal" class="modal_overlay">
			<div class="modal_bg"></div>
			<div class="modal_context">
				<h1>새 플랜 작성</h1>

				<!-- 입력 영역 -->
				<div class="modal_input_area">
					<ul>
						<li><label for="title">제목</label> <input type="text"
							name="title" id="title" placeholder="제목을 입력해주세요." /></li>
						<li><label for="schedule">일정</label> <input type="text"
							name="schedule" id="start_schedule" size="10" readonly /> <span>&nbsp;~&nbsp;</span>
							<input type="text" name="schedule" id="end_schedule" size="10"
							readonly /></li>
						<li>
						<label for="tag">태그</label>
						<input type="text" name="tag" id="tag" size="15">
							<input type="button" id="tag_insert" value="태그 추가">
							</li>							
							<li>
							 <textarea id="tag_list" rows="5" cols="40" readonly></textarea>
							 </li>
					</ul>
							<div id="tag_recommend_area">
								<p>추천 태그</p>
								<div id="tag_recommend_list">
									<c:forEach var="list" items="${tagList}" begin="0" end="9" varStatus="vs">
										<input type="checkbox" class="tag" name="tag"
											value="${list.tagName}"
											id="${list.tagName}" onclick="getValue(event)" />
										<label for="${list.tagName}" class="highlight">${list.tagName}</label>
										<c:if test="${vs.index == 4}"><br></c:if>
									</c:forEach>
								</div>
							</div>
				</div>
				<!-- 캘린더 영역 -->
				<div class="modal_calendar_area">
					<div id="calendar"></div>
				</div>

				<!-- 버튼 영역 -->
				<div class="modal_button_area">
					<input type="button" class="modal_add" value="추가" /> <input
						type="button" class="modal_cancel" value="취소" />
				</div>
			</div>
		</div>
	</section>
</body>
<script src="scripts/modal.js"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/moment@2.27.0/min/moment.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@fullcalendar/moment@5.5.0/main.global.min.js"></script>
</html>
