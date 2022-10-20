var s_year = document.getElementById('year');
var db_birthYear = document.getElementById('db_birthYear').value;
var db_gender = document.getElementById('db_gender').value;
var edit_pw = document.getElementById('password');
var edit_chpw = document.getElementById('pwcheck');
var check_result = document.getElementById('pwCheckResult');
var confirm_result = document.getElementById('pwConfirmCheckResult');

/* 뒤로가기 방지 */
window.history.forward();
window.onpageshow = function() {
	if(event.persisted) noBack();
}

window.onload = function() {
	noBack();
	tapmenu();
	select_year();
	get_dbinfo_birth();
	pw_confirm();
	get_dbinfo_gender();
}



//뒤로가기 방지
function noBack() {
	window.history.forward();
}

/* 탭메뉴 */
function tapmenu() {
	$("#mypage_nav li").click(function() {
		var index = $(this).index();
		$("#mypage_nav li").removeClass("active");
		$("#mypage_nav li").eq(index).addClass("active");
		$("#mypage_content>div").hide();
		$("#mypage_content>div").eq(index).show();
	});
}

/* 생년 select box 생성 */
function select_year() {
	var now = new Date();
	var year = now.getFullYear();

	for (var i = year - 100; i <= year; i++) {
		s_year.innerHTML += '<option value ="' + i + '">' + i + '</option>';
	}
}

/* db에 저장된 생년 불러와서 수정 폼에 저장 */
function get_dbinfo_birth() {
	for (var i = 0; i < s_year.options.length; i++) {
		if (s_year[i].value == db_birthYear) {
			s_year[i].selected = true;
		}
	}
}

/* db에 저장된 성별 불러와서 수정 폼에 저장 */
function get_dbinfo_gender() {
	var s_gender = document.getElementsByName('memberGender');

	for (var i = 0; i < s_gender.length; i++) {
		if (s_gender[i].value == db_gender) {
			s_gender[i].checked = true;
		}
	}
}

/* 비밀번호 입력 일치 확인 */
function pw_confirm() {
	edit_pw.addEventListener('keyup', function(){
		check_result.innerText = '';
		confirm_result.innerText = '';
	});

	edit_chpw.addEventListener('keyup', function(){
		if (edit_pw.value != edit_chpw.value) {
			confirm_result.style.color = 'red';
			confirm_result.innerText = '비밀번호가 일치하지 않습니다.';
		} else {
			confirm_result.style.color = 'blue';
			confirm_result.innerText = '비밀번호가 일치합니다.';
		}
	})
}


// onclick

/* 비밀번호 입력 확인 */
function info_Check() {
	// 비밀번호 유효성 체크 정규식
	var regExp = /^.*(?=^.{8,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

	if (edit_chpw.value && !edit_pw.value) {
		check_result.innerText = "비밀번호를 입력하세요";
		return;
	}
	if (edit_pw.value && !edit_chpw.value) {
		confirm_result.innerText = "비밀번호 확인란을 입력하세요.";
		return;
	}
	if ((edit_pw.value && edit_chpw.value) && !regExp.test(edit_pw.value)) {
		check_result.innerText = "비밀번호는 소문자, 숫자, 특수문자를 포함하여 8자 이상 입력하세요.";
		return;
	}
	 if (edit_pw.value != edit_chpw.value) {
	 	confirm_result.innerText = "비밀번호를 확인해주세요.";
	 	return;
	 }
	document.info_edit_form.submit();
}

/* 플랜 삭제 확인창 */
function delete_ok(rownum) {
	var result = confirm("일정을 삭제하시겠습니까?");

	if (result == true) {
		delete_plan_ajax(rownum);
	}
}

/* 공개 알림창 */
function sharecheck(shared, rownum) {
	var result;

	if (shared == 1) {
		result = confirm("확인버튼 클릭 시 나의 일정이 비공개 됩니다.");
		if (result == true) {
			location.href = "/shareplan?p_rownum=" + rownum + "&shared=" + shared;
		}
	} else {
		result = confirm("확인버튼 클릭 시 나의 일정이 회원들에게 공유됩니다.");
		if (result == true) {
			location.href = "/shareplan?p_rownum=" + rownum + "&shared=" + shared;
		}
	}
}


/* 플랜 삭제 ajax */
function delete_plan_ajax(rownum) {
// XMLHttpRequest 객체 생성
	const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
	xhr.open('POST', "/deletePlan?rownum="+rownum);
// HTTP 요청 전송
	xhr.send();
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
	xhr.onload = () => {
		if (xhr.status === 200) {
			alert("플랜이 삭제되었습니다.");
			location.href="mypage";
		} else {
			alert("삭제 실패");
			console.error('Error', xhr.status, xhr.statusText);
		}
	}
}


/* 회원 탈퇴 ajax */
function delete_member_ajax() {
// XMLHttpRequest 객체 생성
	const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
	xhr.open('GET', '/checkpw');
// HTTP 요청 전송
	xhr.send();
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
	xhr.onload = () => {
		if (xhr.status === 200) {
			alert("탈퇴 되었습니다.");
			location.href="/";
		} else {
			alert("탈퇴 실패");
			console.error('Error', xhr.status, xhr.statusText);
		}
	}
}
