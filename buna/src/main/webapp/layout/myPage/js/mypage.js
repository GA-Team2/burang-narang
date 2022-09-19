/* 탭메뉴 */
$(document).ready(function() {
	$(".mypage_nav li").click(function(){
		var index = $(this).index();
		$(".mypage_nav li").removeClass("active");
		$(".mypage_nav li").eq(index).addClass("active");
		$(".mypage_content>div").hide();
		$(".mypage_content>div").eq(index).show();
	});
});

/* 생년 select */
$(document).ready(function(){            
    var now = new Date();
    var year = now.getFullYear();
    
    //option value에 연도 추가
    for(var i = year-100 ; i <= year ; i++) {
        $('#year').append('<option value="' + i + '">' + i + '</option>');    
    }
	$("#year option").each(function(){
		if($(this).val() == birthYear){
			$(this).attr("selected", "true");
		}
	});
});

/* db정보 불러오기 */
$(document).ready(function(){
	$("input[type='radio']").each(function(){
		if($(this).val() == gender) {
			$(this).attr("checked", "true");
		}
	});
});

/* 비밀번호 일치 확인, 입력 시 경고문 없어지게 */
$(function() {
	$("#password").keyup(function(){
		$("#pwCheckResult").html('');
		$("#pwConfirmCheckResult").html('');
	});

	$("#pwcheck").keyup(function(){
		if($("#password").val()!= $("#pwcheck").val()) {
			$("#pwConfirmCheckResult").css({"color":"red"});
			$("#pwConfirmCheckResult").text("비밀번호가 일치하지 않습니다.");
		} else {
			$("#pwConfirmCheckResult").css({"color":"blue"});
			$("#pwConfirmCheckResult").text("비밀번호가 일치합니다.");
		}
	});
	
	$("#nickname").keyup(function(){
		$("#nicknameCheckResult").html('');
	});
});

/* 닉네임, 비밀번호 입력 확인 */
function info_Check() {
	//비밀번호 유효성 체크 정규식
	var regExp = /^.*(?=^.{8,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
    if(!$("#nickname").val()) {
		$("#nicknameCheckResult").text("닉네임을 입력하세요.");
		return;
	}
	if($("#nickname").val().length > 6) {
		$("#nicknameCheckResult").text("닉네임은 6자 이하로 입력해주세요.");
		return;
	}
    if(!$("#password").val()) {
		$("#pwCheckResult").text("비밀번호를 입력하세요.");
		return;
	}
    if(!$("#pwcheck").val()) {
		$("#pwConfirmCheckResult").text("비밀번호 확인란을 입력하세요.");
		return;
	}
	if(!regExp.test($("#password").val())) {
		$("#pwCheckResult").text("비밀번호는 소문자, 숫자, 특수문자를 포함하여 8자 이상 입력하세요.");
		return;
	}
	if($("#password").val() != $("#pwcheck").val()) {
		$("#pwConfirmCheckResult").text("비밀번호를 확인해주세요.");
		return;
	}
	
	document.info_edit_form.submit();
}

/* 닉네임 중복 체크 */
//function nickname_check() {
//	var inputNickname = $("#nickname").val();
//	//입력 받은 닉네임 값
//	
//	$.ajax({
//		url : "nameCheck.jsp",
//		type : "post",
//		data : {inputNickname: input},
//		dataType : 'json',
//		success : function(result){
//			if (result==0) {
//				$(".check").css({"color":"red"});
//				$(".check").text("사용 중인 닉네임입니다.");
//			} else {
//				$(".check").css({"color":"blue"});
//				$(".check").text("사용가능한 닉네임입니다.");
//			}
//		},
//		error : function() {
//			alert("서버 요청 실패");
//		}
//	});
//}


/* 플랜 삭제 확인창 */
function delete_ok() {
    var result = confirm("일정을 삭제하시겠습니까?");

    if (result==true) {
        //일정 db에서 삭제
    }
}

/* 공유 알림창 */
function sharecheck() {
    var result = confirm("확인버튼 클릭 시 나의 일정이 회원들에게 공유됩니다.");

    if (result==true) {
        //일정 등록
        //마이페이지 이동 or 일정 페이지 이동
    }
}

