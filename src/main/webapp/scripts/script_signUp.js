/**
 *회원가입 유효성 검사
 */
function sign_ok(){
	var nickWarn1 = document.getElementById("nicknameWarn1");
	var nickWarn2 = document.getElementById("nicknameWarn2");
	var nickWarn2_1 = document.getElementById("nicknameWarn2_1");
	var nickWarn3 = document.getElementById("nicknameWarn3");
	var nickWarn4 = document.getElementById("nicknameWarn4");
	var pwdWarn1 = document.getElementById("pwdWarn1");
	var pwdWarn2 = document.getElementById("pwdWarn2");
	var pwdWarn3 = document.getElementById("pwdWarn3");
	var birthWarn1 = document.getElementById("birthWarn1");
	var birthWarn2 = document.getElementById("birthWarn2");
	var birthWarn3 = document.getElementById("birthWarn3");
	var genderWarn = document.getElementById("genderWarn");

	if(signUp.m_nickname.value.length == 0){
		nickWarn1.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.m_nickname.focus();
		return;
	} else {
		nickWarn1.style.display = 'none';
	}



	if(signUp.m_nickname.value.length > 6){
		nickWarn3.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.m_nickname.focus();
		return;
	} else {
		nickWarn3.style.display = 'none';
	}


	var nickC = document.getElementById("nickC_forJs").value;
	if(signUp.m_nickname.value.length !=0 && nickC == 2){
		nickWarn4.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.m_nickname.focus();
		return;
	} else {
		nickWarn1.style.display = 'none';
	}

	if(signUp.m_password.value.length == 0){
		pwdWarn1.style.display = 'block';
		signUp.m_password.focus();
		return;
	} else {
		pwdWarn1.style.display = 'none';
	}

	var pattern1 = /[0-9]/;

    var pattern2 = /[a-zA-Z]/;

    var pattern3 = /[~!@\#$%<>^&*]/;

    if(!pattern1.test(signUp.m_password.value)||!pattern2.test(signUp.m_password.value)||!pattern3.test(signUp.m_password.value)){
		pwdWarn2.style.display = 'block';
		signUp.m_password.focus();
        return;
    } else if(signUp.m_password.value.length<8||signUp.m_password.value.length>50) {
		pwdWarn2.style.display = 'block';
		signUp.m_password.focus();
		return;
	} else {
		pwdWarn2.style.display = 'none';
	}

	if(signUp.pwdCommit.value != signUp.m_password.value){
		pwdWarn3.style.display = 'block';
		signUp.pwdCommit.focus();
		return;
	} else {
		pwdWarn3.style.display = 'none';
	}

	if(signUp.m_birthyear.value.length == 0){
		birthWarn1.style.display = 'block';
		signUp.m_birthyear.focus();
		return;
	} else {
		birthWarn1.style.display = 'none';
	}

	if(signUp.m_birthyear.value < 1922 || signUp.m_birthyear.value > 2022){
		birthWarn2.style.display = 'block';
		signUp.m_birthyear.focus();
		return;
	} else {
		birthWarn2.style.display = 'none';
	}

	if(isNaN(signUp.m_birthyear.value)){
		birthWarn3.style.display = 'block';
		signUp.m_birthyear.focus();
		return;
	} else {
		birthWarn3.style.display = 'none';
	}

	for(i=0;i<2;i++) {
      if(!document.signUp.m_gender[0].checked && !document.signUp.m_gender[1].checked) {
			genderWarn.style.display = 'block';
			signUp.m_gender.focus();
			return;
        } else if(document.signUp.m_gender[0].checked || document.signUp.m_gender[1].checked) {
			genderWarn.style.display = 'none';
			break;
		}
    }

	var nickR = document.getElementById("nickR_forJs").value;
	if(nickR != 0 && nickR != signUp.m_nickname.value) {
		nickWarn4.style.display = 'block';
		if(nickWarn2_1 != null){
	    	nickWarn2_1.classList.add("hidden");
	    }
		signUp.m_nickname.focus();
		return;
	} else if(nickR == 0) {
		signUp.m_nickname.focus();
		return;
	}

	document.signUp.submit();
}

/**
 * 중복확인 유효성 검사
 */
function nick_check(){
		var nickWarn1 = document.getElementById("nicknameWarn1");
		var nickWarn2 = document.getElementById("nicknameWarn2");
		var nickWarn2_1 = document.getElementById("nicknameWarn2_1");
	if(signUp.m_nickname.value.length == 0){
		nickWarn1.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.m_nickname.focus();
		return;
	} else {
    	var nick_input = document.getElementById("m_nickname").value;
		nickWarn1.style.display = 'none';

		location.href = "nickCheck.jsp?nick=" + nick_input;
	}
}
