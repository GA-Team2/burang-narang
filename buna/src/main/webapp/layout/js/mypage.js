
/* 회원정보수정 유효성 체크 */
function check() {
    if (!profile_edit.pwd.value || !profile_edit.pwd_check.value) {
        alert("비밀번호를 입력하세요.");
        profile._edit.pwd.focus();
        return;
    }
    if (profile_edit.pwd.value!=profile_edit.pwd_check.value) {
        alert("비밀번호가 일치하지 않습니다.");
        profile._edit.pwd_check.focus();
        return;
    }
    if (!profile_edit.nickname.value) {
        alert("닉네임을 입력하세요.");
        profile._edit.nickname.focus();
        return;
    }
    if (!profile_edit.email.value) {
        alert("이메일을 입력하세요.");
        profile._edit.email.focus();
        return;
    }
    
    profile_edit.submit();
}

/* 회원 탈퇴 확인창 */
function signout() {
    var result=confirm("정말로 탈퇴하시겠습니까?");

    if (result==true) {
        //회원 db삭제
        //메인 이동
    }
}


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