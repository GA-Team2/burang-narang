 window.history.forward();
 function noBack(){window.history.forward();}

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
    
    //option value에 연도값 추가
    for(var i = year-100 ; i <= year ; i++) {
        $('#year').append('<option value="' + i + '">' + i + '</option>');    
    }
});



/* db정보 불러오기 */
$(document).ready(function(){
	//성별 저장
	$("input[type='radio']").each(function(){
		if($(this).val() == gender) {
			$(this).attr("checked", "true");
		}
	});
	
	//생년 저장
	$("#year option").each(function(){
		if($(this).val() == birthYear){
			$(this).attr("selected", "true");
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
		$("#duplication").val("unchecked");
	});
});



/* 닉네임, 비밀번호 입력 확인 */
function info_Check() {
	//비밀번호 유효성 체크 정규식
	var regExp = /^.*(?=^.{8,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
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


/* 플랜 삭제 확인창 */
function delete_ok(rownum) {
    var result = confirm("일정을 삭제하시겠습니까?");

    if (result==true) {
        location.href="planDelete.jsp?p_rownum="+rownum;
    }
    console.log(rownum);
}


/* 공유 알림창 */
function sharecheck(shared, rownum) {
	var result;
	if (shared == 1) {
		result = confirm("확인버튼 클릭 시 나의 일정이 비공개 됩니다.");
	    if (result==true) {
	        location.href="planShare.jsp?p_rownum="+rownum+"&shared="+shared;
	    } else {
	    	console.log(shared);
	    	console.log(rownum);
	    }
	} else {
	    result = confirm("확인버튼 클릭 시 나의 일정이 회원들에게 공유됩니다.");
	    if (result==true) {
	        location.href="planShare.jsp?p_rownum="+rownum+"&shared="+shared;
	    } else {
	    	console.log(shared);
	    	console.log(rownum);
	    }
	}
}

