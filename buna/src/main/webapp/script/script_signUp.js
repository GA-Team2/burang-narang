/**
 * 
 */
function sign_ok(){
	if(signUp.m_nickname.value.length == 0){
		var nickWarn1 = document.getElementById("nicknameWarn1");
		var nickWarn2 = document.getElementById("nicknameWarn2");
		var nickWarn2_1 = document.getElementById("nicknameWarn2_1");
		nickWarn1.style.display = 'block';
		nickWarn2.style.display = 'none';
		nickWarn2v.style.display = 'none';
		signUp.m_nickname.focus();
		return;
	} else {
		var nickWarn1 = document.getElementById("nicknameWarn1");
		nickWarn1.style.display = 'none';
	}
	
	
	
	if(signUp.m_nickname.value.length > 6){
		var nickWarn3 = document.getElementById("nicknameWarn3");
		var nickWarn2 = document.getElementById("nicknameWarn2");
		var nickWarn2_1 = document.getElementById("nicknameWarn2_1");
		nickWarn3.style.display = 'block';
		nickWarn2.style.display = 'none';
		nickWarn2_1.style.display = 'none';
		signUp.m_nickname.focus();
		return;
	} else {
		var nickWarn3 = document.getElementById("nicknameWarn3");
		nickWarn3.style.display = 'none';
	}
	
	
	var nickC = document.getElementById("nickC_forJs").value;
	if(signUp.m_nickname.value.length !=0 && nickC == 2){
		var nickWarn4 = document.getElementById("nicknameWarn4");
		var nickWarn2 = document.getElementById("nicknameWarn2");
		var nickWarn2_1 = document.getElementById("nicknameWarn2_1");
		nickWarn4.style.display = 'block';
		nickWarn2.style.display = 'none';
		nickWarn2_1.style.display = 'none';
		signUp.m_nickname.focus();
		return;
	} else {
		var nickWarn4 = document.getElementById("nicknameWarn4");
		nickWarn1.style.display = 'none';
	}
	
	if(signUp.m_password.value.length == 0){
		var pwdWarn1 = document.getElementById("pwdWarn1");
		pwdWarn1.style.display = 'block';
		signUp.m_password.focus();
		return;
	} else {
		var pwdWarn1 = document.getElementById("pwdWarn1");
		pwdWarn1.style.display = 'none';
	}
	
	var pattern1 = /[0-9]/;

    var pattern2 = /[a-zA-Z]/;

    var pattern3 = /[~!@\#$%<>^&*]/;
    
    if(!pattern1.test(signUp.m_password.value)||!pattern2.test(signUp.m_password.value)||!pattern3.test(signUp.m_password.value)||signUp.m_password.value.length<8||signUp.m_password.value.length>50){
    	var pwdWarn2 = document.getElementById("pwdWarn2");
		pwdWarn2.style.display = 'block';
		signUp.m_password.focus();
        return;
    } else {
    	var pwdWarn2 = document.getElementById("pwdWarn2");
		pwdWarn2.style.display = 'none';
	}
	
	if(signUp.pwdCommit.value != signUp.m_password.value){
		var pwdWarn3 = document.getElementById("pwdWarn3");
		pwdWarn3.style.display = 'block';
		signUp.pwdCommit.focus();
		return;
	} else {
		var pwdWarn3 = document.getElementById("pwdWarn3");
		pwdWarn3.style.display = 'none';
	}
	
	if(signUp.m_birthyear.value.length == 0){
		var birthWarn1 = document.getElementById("birthWarn1");
		birthWarn1.style.display = 'block';
		signUp.m_birthyear.focus();
		return;
	} else {
		var birthWarn1 = document.getElementById("birthWarn1");
		birthWarn1.style.display = 'none';
	}
	
	if(signUp.m_birthyear.value < 1922 || signUp.m_birthyear.value > 2022){
		var birthWarn2 = document.getElementById("birthWarn2");
		birthWarn2.style.display = 'block';
		signUp.m_birthyear.focus();
		return;
	} else {
		var birthWarn2 = document.getElementById("birthWarn2");
		birthWarn2.style.display = 'none';
	}
	
	if(isNaN(signUp.m_birthyear.value)){
		var birthWarn3 = document.getElementById("birthWarn3");
		birthWarn3.style.display = 'block';
		signUp.m_birthyear.focus();
		return;
	} else {
		var birthWarn3 = document.getElementById("birthWarn3");
		birthWarn3.style.display = 'none';
	}
	
	for(i=0;i<2;i++) {
      if(!document.signUp.m_gender[0].checked && !document.signUp.m_gender[1].checked) {
			var genderWarn = document.getElementById("genderWarn");
			genderWarn.style.display = 'block';
			signUp.m_gender.focus();
			return;
        } else if(document.signUp.m_gender[0].checked || document.signUp.m_gender[1].checked) {
			var genderWarn = document.getElementById("genderWarn");
			genderWarn.style.display = 'none';
			break;
		}
    }
	
	
	document.signUp.submit();
}