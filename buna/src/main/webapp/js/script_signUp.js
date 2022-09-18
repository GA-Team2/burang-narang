/**
 * 
 */
function sign_ok(){
	if(signUp.m_nickname.value.length == 0){
		var nickWarn1 = document.getElementById("nicknameWarn1");
		nickWarn1.style.display = block;
		signUp.m_nickname.focus();
		return;
	}
	
	if(signUp.m_nickname.value.length < 6){
		var nickWarn2 = document.getElementById("nicknameWarn3");
		nickWarn2.style.display = block;
		signUp.m_nickname.focus();
		return;
	}
	
	if(signUp.m_password.value.length == 0){
		var pwdWarn1 = document.getElementById("pwdWarn1");
		pwdWarn1.style.display = block;
		signUp.m_password.focus();
		return;
	}
	
	var pattern1 = /[0-9]/;

    var pattern2 = /[a-zA-Z]/;

    var pattern3 = /[~!@\#$%<>^&*]/;
    
    if(!pattern1.test(signUp.m_password.value)||!pattern2.test(signUp.m_password.value)||!pattern3.test(signUp.m_password.value)||signUp.m_password.value.length<8||signUp.m_password.value.length>50){
    	var pwdWarn2 = document.getElementById("pwdWarn2");
		pwdWarn2.style.display = block;
		signUp.m_password.focus();
        return;
    }
	
	if(signUp.pwdCommit.value.length == 0){
		var pwdWarn3 = document.getElementById("pwdWarn3");
		pwdWarn1.style.display = block;
		signUp.pwdCommit.focus();
		return;
	}
}