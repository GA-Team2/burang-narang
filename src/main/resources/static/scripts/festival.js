//로그인 여부 체크
// TOP 이미지, 게시판 제목 클릭 시
function click_on() {
    // 세션값(아이디) 여부 체크
    const check = document.getElementById('nickCheck').value;
    console.log(check);
    if (check == 'null' || check == "") {
        alert("로그인 하세요")
        // 세션값(아이디)이 없을경우 로그인 페이지로 보냄
        location.href = "/login";
        // a태그에 false를 반환하여 a태그에 있는 페이지로는 이동 안함
        return false;
    }
    // 세션값(아이디)이 존재하면 a태그로 true반환 MakePlan 페이지로 이동
    return confirm("플랜 작성페이지로 이동하시겠습니까?");
}
