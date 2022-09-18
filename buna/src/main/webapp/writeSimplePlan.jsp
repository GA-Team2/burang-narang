<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>새 플랜 작성 | 부랑나랑</title>
    <link rel="stylesheet" href="css/normalize.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.css"
    />
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
              <li>
                <label for="title">제목</label>
                <input
                  type="text"
                  name="title"
                  id="title"
                  placeholder="제목을 입력해주세요."
                />
              </li>
              <li>
                <label for="schedule">일정</label>
                <input
                  type="text"
                  name="schedule"
                  id="start_schedule"
                  size="10"
                  readonly
                />
                <span>&nbsp;~&nbsp;</span>
                <input
                  type="text"
                  name="schedule"
                  id="end_schedule"
                  size="10"
                  readonly
                />
              </li>
              <li>
                <label for="tag">태그</label>
                <input
                  type="text"
                  name="tag"
                  id="tag"
                  placeholder="원하는 태그가 없을 경우 직접 입력해주세요."
                />
              </li>
              <li>
                <div class="taglist">
                  <input
                    type="checkbox"
                    class="tag"
                    name="tag"
                    value="#가나다"
                    id="#가나다"
                    onclick="getValue(event)"
                  /><label for="#가나다" class="highlight">#가나다</label>

                  <input
                    type="checkbox"
                    class="tag"
                    name="tag"
                    value="#라마바"
                    id="#라마바"
                    onclick="getValue(event)"
                  /><label for="#라마바" class="highlight">#라마바</label>

                  <input
                    type="checkbox"
                    class="tag"
                    name="tag"
                    value="#사아자"
                    id="#사아자"
                    onclick="getValue(event)"
                  /><label for="#사아자" class="highlight">#사아자</label>
                </div>
              </li>
            </ul>
          </div>

          <!-- 캘린더 영역 -->
          <div class="modal_calendar_area">
            <div id="calendar"></div>
          </div>

          <!-- 버튼 영역 -->
          <div class="modal_button_area">
            <input type="button" class="modal_add" value="추가" />
            <input type="button" class="modal_cancel" value="취소" />
          </div>
        </div>
      </div>
    </section>
  </body>
  <script src="scripts/modal.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/moment@2.27.0/min/moment.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@fullcalendar/moment@5.5.0/main.global.min.js"></script>
</html>
