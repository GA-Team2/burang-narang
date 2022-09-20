/* cancle 메소드 모음 */

// spot list 추가 취소
function cancle() {
    $('.black').addClass('hidden');
}
// 플랜 작성 취소
function plan_cancle() {	
	document.querySelector(".plan_info").classList.add('hidden');
	history.go(-1);
}