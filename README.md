# 2022-Buna Project

## 💻 프로젝트 소개
- **프로젝트명** : 부랑나랑 (Buna)
- **프로젝트 기간** : 2022.09.14 ~ 2022.09.29 / 2022.10.10 ~ 2022.11.01
- 간편하게 부산 여행 계획을 짤 수 있는 부산 만의 여행 플래너 웹사이트

## 📑 사이트 링크
<a href="http://burangnarang.com/">burangnarang.com</a>

## 👀 멤버 소개
- **김규빈**
	- Team Leader
	- 웹사이트 기획 및 DB (~~Oracle DB~~ -> MySQL) 구축
	- 새 플랜 작성 Modal 페이지 구현
		- Java, Spring Framework, Spring Boot, MyBatis, JSP, HTML, CSS, Javascript ( + JQuery, FullCalendar) 사용
	- 새 플랜 작성, 플랜 수정, 여행 일정표 페이지의 지도 API 구현
		- ~~카카오 맵~~ -> 네이버 맵 Open API ( + Javascript) 사용
	- AWS EC2 서버 구축 / 배포 / 관리
	    - AWS EC2(Ubuntu), AWS RDS 사용
- **한애채**
	- 웹사이트 기획 및 DB (~~Oracle DB~~ -> MySQL) 구축
	- 새 플랜 작성, 플랜 수정 페이지 구현
		- Java, Spring Framework, Spring Boot, MyBatis, JSP, HTML, CSS, Javascript ( + JQuery) 사용 
- **한병태**
	- 웹사이트 기획 및 DB (~~Oracle DB~~ -> MySQL) 구축
	- Main Page, 로그인 / 회원가입 페이지 구현
		-  Java, Spring Framework, Spring Boot, MyBatis, JSP, HTML, CSS, Javascript ( + JQuery, FullCalendar) 사용
- **강승구**
	-  웹사이트 기획 및 DB (~~Oracle DB~~ -> MySQL) 구축
	-  인기 여행 플랜, 행사 / 이벤트 페이지 구현
		-  Java, Spring Framework, Spring Boot, MyBatis, JSP, HTML, CSS, Javascript ( + JQuery, Bootstrap) 사용
- **장희정**
	- 웹사이트 기획 및 DB (~~Oracle DB~~ -> MySQL) 구축
	- 여행 일정표, My Page 페이지 구현
		-  Java, Spring Framework, Spring Boot, MyBatis, JSP, HTML, CSS, Javascript ( + JQuery) 사용

## ⚒ 사용 기술 및 개발 환경
OS : Windows 10

Tools : ~~Eclipse 2020-06~~ -> IntelliJ IDEA, ~~Oracle SQL Developer~~ -> MySQL Workbench 8.0

Frondend : HTML5, CSS3, Javascript( + JQuery, Bootstrap, FullCalendar)

Backend : JAVA 8, Spring Framework, Spring Boot 2.6, MyBatis, JSP

Database : ~~Oracle XE 11g~~ -> MySQL 8.0

Build Tool : ~~Maven~~ -> Gradle

Web Application Server : Apache Tomcat 9

Open API : ~~카카오 지도 Open API~~ -> 네이버 맵 Open API

Cloud Server : AWS EC2 (Ubuntu 18.04), AWS RDS (MySQL)

## 📐 Flowchart
<img src="./images/flowchart.jpg">

## 📊 ER Diagram
<img src="./images/erd.jpg">

## ⚙️ AWS Architecture Diagram
<img src="./images/aws.png">

## 🖇 테이블 정의서
<details>
<summary>MEMBERINFO</summary>
<div markdown="1">
<img src="./images/table1.JPG">
</div>
</details>
<details>
<summary>PLANINFO</summary>
<div markdown="1">
<img src="./images/table2.JPG">
</div>
</details>
<details>
<summary>PLANDETAIL</summary>
<div markdown="1">
<img src="./images/table3.JPG">
</div>
</details>
<details>
<summary>TAGLIST</summary>
<div markdown="1">
<img src="./images/table4.JPG">
</div>
</details>
<details>
<summary>LIKEINFO</summary>
<div markdown="1">
<img src="./images/table9.JPG">
</div>
</details>
<details>
<summary>SPOTDETAIL</summary>
<div markdown="1">
<img src="./images/table5.JPG">
</div>
</details>
<details>
<summary>RESTAURANT</summary>
<div markdown="1">
<img src="./images/table6.JPG">
</div>
</details>
<details>
<summary>ACCOMODATION</summary>
<div markdown="1">
<img src="./images/table8.JPG">
</div>
</details>
<details>
<summary>EVENT</summary>
<div markdown="1">
<img src="./images/table7.JPG">
</div>
</details>
<details>
<summary>TRAFFIC</summary>
<div markdown="1">
<img src="./images/table10.JPG">
</div>
</details>

## 📑 페이지별 기능
<details>
<summary>Main Page</summary>
<div markdown="1">
<img src="./images/mainpage.jpg">
<p>▣ 로그인한 회원이 이미 작성한 플랜이 있을 경우, 여행일까지의 D-Day를 표시</p>
<p>▣ 여행 혼잡도 캘린더를 이용해 상대적으로 여유로운 여행 날짜 선택을 도움</p>
<p>▶ 날짜별 모든 회원의 플랜 수를 이용해 기준별로 세 가지 색상으로 표시</p>
</div>
</details>
<details>
<summary>로그인 / 회원 가입</summary>
<div markdown="1">
<img src="./images/login.jpg"><img src="./images/signup.jpg">
</div>
</details>
<details>
<summary>새 플랜 작성</summary>
<div markdown="1">
<img src="./images/newplan2.jpg"><img src="./images/newplan1.jpg">
<p>▣ 원하는 여행 날짜를 드래그하면 날짜 입력란에 자동으로 입력</p>
<p>▣ 추천 태그를 이용한 간편한 태그 추가 가능</p>
<p>▣ 부산의 교통, 숙소, 맛집, 행사 등을 클릭만으로 편리한 플랜 작성 가능</p>
<p>▣ 일자별로 장소 추가, 삭제 가능</p>
<p>▣ 장소 간의 순서 변경 가능</p>
<p>▣ 원하는 장소 검색 가능</p>
<p>▣ 장소를 선택하면 지도에 마커가 찍히면서 장소 간의 경로를 제공해 대략적인 이동 거리 파악 가능</p>
<p>▣ 작성 완료 시 인기 공유 플랜 페이지에 공개 여부 확인 후 자동 등록</p>
</div>
</details>
<details>
<summary>여행 일정표</summary>
<div markdown="1">
<img src="./images/detail.jpg">
<p>▣ 플랜 작성 결과 를 일자별로 도식화하여 한 눈에 볼 수 있게 표시</p>
<p>▣ 인기 공유 플랜에서 선택된 일정의 경우 내 플랜으로 가져오기 기능 활성화</p>
<p>▣ 선택한 플랜 장소들의 최종 경로를 지도에 표시</p>
<p>▣ 추천 기능을 통해 인기 공유 플랜의 순위에 반영</p>
</div>
</details>
<details>
<summary>플랜 수정</summary>
<div markdown="1">
<img src="./images/editplan1.jpg"><img src="./images/editplan2.jpg">
<p>▣ 작성된 플랜 수정 가능</p>
<p>▣ 이미 등록된 장소의 경로를 미리 표시</p>
<p>▣ 날짜를 수정할 경우 장소가 바뀔 확률이 높기 때문에 등록된 장소를 전체 삭제하여 선택의 편의성 제공</p>
</div>
</details>
<details>
<summary>인기 여행 플랜</summary>
<div markdown="1">
<img src="./images/bestplan.jpg">
<p>▣ 추천 수가 높은 TOP 3 여행 플랜을 상단에 표시</p>
<p>▣ 회원이 등록한 플랜들을 리스트화하여 표시</p>
<p>▣ 인기 등록 태그별, 추천 수별 플랜 조회 가능</p>
<p>▣ 인기 있는 플랜을 선택해 내 플랜으로 커스터 마이징 가능</p>
</div>
</details>
<details>
<summary>행사 / 이벤트</summary>
<div markdown="1">
<img src="./images/event.jpg">
<p>▣ 부산에서 열리는 행사들을 월별로 조회 가능</p>
<p>▣ 행사 사진을 클릭할 경우 행사별 공식 사이트로 이동</p>
<p>▣ 내 플랜에 추가 버튼을 클릭 시 새 플랜 작성 페이지로 넘어가 행사를 기준으로 플랜을 작성할 수 있도록 유도</p>
</div>
</details><details>
<summary>My Page</summary>
<div markdown="1">
<img src="./images/mypage1.jpg"><img src="./images/mypage2.jpg">
<p>▣ 자신이 쓴 플랜 목록 조회 가능</p>
<p>▣ 자세히 보기 버튼을 통해 여행 일정표 페이지로 넘어가 자세한 플랜 정보 열람 가능</p>
<p>▣ 일정 공개 / 비공개 버튼을 통해 인기 여행 플랜 리스트에 공개 여부 설정 가능</p>
<p>▣ 등록한 일정 삭제 가능</p>
<p>▣ 회원 정보 수정 및 회원 탈퇴 가능</p>
</div>
</details>
