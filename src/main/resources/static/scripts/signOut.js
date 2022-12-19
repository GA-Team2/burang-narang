/* 회원 탈퇴 ajax */
function delete_member_ajax() {
    const pwdata = JSON.stringify({
        "memberPw": document.getElementById("pw").value
    });
// XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
    xhr.open('POST', '/mypage/check');
    xhr.setRequestHeader('Content-type', 'application/json');
// HTTP 요청 전송
    xhr.send(pwdata);
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        const result = xhr.response;
        if (xhr.status === 201 && result == 1) {
            alert("탈퇴 되었습니다.");
            location.href = "/mypage/deletem";
        } else if (xhr.status === 201 && result == 0) {
            alert("비밀번호가 일치하지 않습니다.");
        } else {
            alert("탈퇴 실패");
            console.error('Error', xhr.status, xhr.statusText, xhr.response);
        }
    }
}
