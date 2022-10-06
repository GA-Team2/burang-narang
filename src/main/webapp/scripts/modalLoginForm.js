/*
	makeplan시 로그인 하지 않았을때 발생하는 메서드
*/
// 로그인 모달 창
function login_alert() {
	document.getElementById('login').classList.remove("hidden");
	$('.login_form').load('makePlanLoginForm.jsp');
}
// 모달 창에서 로그인 시 loginOk로 넘어가서 login 체크
function login_check() {
	var nick = document.getElementById("nick").value;
	var pwd = document.getElementById('pwd').value;
	$('.login_form').load('makePlanLoginOK.jsp?nick='+nick+'&pwd='+pwd);
}
// 로그인 취소
function cancel_login() {
	document.getElementById('login').classList.add("hidden");
}