function login_alert() {
	document.getElementById('login').classList.remove("hidden");
	$('.login_form').load('makePlanLoginForm.jsp');
}

function login_check() {
	var nick = document.getElementById("nick").value;
	var pwd = document.getElementById('pwd').value;
	console.log(nick);
	$('.login_form').load('makePlanLoginOK.jsp?nick='+nick+'&pwd='+pwd);
}

function cancel_login() {
	document.getElementById('login').classList.add("hidden");
}