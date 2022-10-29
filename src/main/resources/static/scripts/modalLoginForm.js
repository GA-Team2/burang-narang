const loginForm = document.loginForm;
nickName = loginForm.nick;
nickPass = loginForm.pwd;

/*
	makeplan시 로그인 하지 않았을때 발생하는 메서드
*/
// 로그인 모달 창
function loginAlert() {
	document.getElementById('login').classList.remove("hidden");
}
// 모달 창에서 로그인 시 loginOk로 넘어가서 login 체크
function login_check() {


	const nick = document.getElementById("nick").value;
	const pwd = document.getElementById('pwd').value;
}
// 로그인 취소
function cancel_login() {
	document.getElementById('login').classList.add("hidden");
}