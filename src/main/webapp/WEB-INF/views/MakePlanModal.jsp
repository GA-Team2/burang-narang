<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>새 플랜 작성 | 부랑나랑</title>
		<link rel="stylesheet" href="styles/normalize.css" />
		<!-- 새 플랜 작성 Modal 전체 CSS -->
		<link rel="stylesheet" href="styles/style_planinfo.css" />
		<!-- FullCalendar 관련 CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css">
	</head>
	<body>
		<!-- 새 플랜 작성 Modal -->
		<section id="modal_area" class="modal_zone">
			<div id="modal" class="modal_overlay">
				<div class="modal_bg"></div>
				<form name="scheduleForm">
					<div class="modal_context">
						<h1>새 플랜 작성</h1>
						
						<!-- 입력 영역 -->
						<div class="modal_input_area">
							<ul>
							
								<!-- 여행제목 -->
								<li>
									<label for="title">여행제목</label>
									<input type="text" name="title" id="title" placeholder="제목을 입력해주세요." />
									<!-- 제목 유효성 검사 -->
									<span id="notitle" class="hidden">제목을 입력해주세요.</span>
								</li>
								
								<!-- 여행기간 -->
								<li>
									<label for="schedule">여행기간</label>
									<input type="text"
									name="firstdate" id="start_schedule" size="10" readonly />
									<span>&nbsp;~&nbsp;</span>
									<input type="text" name="lastdate" id="end_schedule" size="10"
									readonly />
									
									<!-- 여행기간 유효성 검사 -->
									<span id="noschedule" class="hidden">여행기간을 입력해주세요.</span>
								</li>
								
								<!-- 태그 -->
								<li id="tag_input_area">
									<label for="tag">태그</label>
									<input type="text" name="tag" id="tag" size="15" value="#">
									<input type="button" id="add_tag" value="태그 추가">
									
									<!-- 태그 유효성 검사 -->
									<span id="duplicate_tag" class="hidden">이미 추가한 태그입니다.</span>
									<span id="too_many_tag" class="hidden">태그는 10개까지만 추가할 수 있습니다.</span>
									<span id="too_long_tag" class="hidden">태그는 10자까지 쓸 수 있습니다.</span>
									<span id="blank_tag" class="hidden">빈 태그를 추가할 수 없습니다.</span>
								</li>
								
								<!-- 태그 선택 결과를 보여주는 영역 -->							
								<li>
								 	<div id="tag_area"></div>
								 	
									<!-- 선택된 태그들을 다음 페이지로 전달하기 위한 input -->
								 	<input type="hidden" id="tag_value" name="taglist" value="" >
								</li>
							</ul>
							
							<!-- 추천 태그 영역 -->
							<div id="tag_recommend_area">
								<p>추천 태그</p>
								<div id="tag_recommend_list">
									
									<!-- 가져온 태그 리스트를 index 순으로 출력 -->
									<c:forEach var="list" items="${list}" begin="0" end="9" varStatus="vs">
										<span id="${list.tagName}" class="highlight" onclick="clickInsertTag(this.id)">${list.tagName}</span>
										
										<!-- 5개마다 개행 -->
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
						
							<!-- 추가 버튼 누르면 modal.js에서 유효성 검사 진행 -->
							<input type="button" class="modal_add" value="추가" onclick="writeCheck()" id="makeInfo" name="make"/>
							
							<!-- 취소 버튼 누르면 이전 페이지로 이동 -->
							<input type="button" class="modal_cancel" value="취소" onclick="history.back()" name="cancel"/>
						</div>
					</div>
				</form>
			</div>
		</section>
	</body>
	<!-- 모달 페이지의 전반적인 js -->
	<script src="scripts/modal.js"></script>
	<!-- 캘린더 설정 관련 js -->
	<script src="scripts/calendar.js"></script>
	<!-- FullCalendar -->
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/moment@2.27.0/min/moment.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@fullcalendar/moment@5.5.0/main.global.min.js"></script>
</html>
