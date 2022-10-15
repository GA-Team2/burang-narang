/**
 *회원가입 유효성 검사
 */
function sign_ok(){
	//경고문 필드
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

	//닉네임 미입력 case
	if(signUp.MNickname.value.length == 0){
		nickWarn1.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.MNickname.focus();
		return;
	} else {
		nickWarn1.style.display = 'none';
	}


	//닉네임이 6글자 초과 case
	if(signUp.MNickname.value.length > 6){
		nickWarn3.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.MNickname.focus();
		return;
	} else {
		nickWarn3.style.display = 'none';
	}

	//닉네임 중복확인 미실시 방지 변수
	var nickC = document.getElementById("nickC_forJs").value;
	//닉네임 중복확인 미실시 방지 case
	if(signUp.MNickname.value.length !=0 && nickC == 2){
		nickWarn4.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.MNickname.focus();
		return;
	} else {
		nickWarn1.style.display = 'none';
	}

	//패스워드 미입력 case
	if(signUp.MPassword.value.length == 0){
		pwdWarn1.style.display = 'block';
		signUp.MPassword.focus();
		return;
	} else {
		pwdWarn1.style.display = 'none';
	}
	
	//패스워드 보안강화 유효성 강화 변수
	var pattern1 = /[0-9]/;

    var pattern2 = /[a-zA-Z]/;

    var pattern3 = /[~!@\#$%<>^&*]/;

	//패스워드 영어 + 특수문자 + 숫자 조합만 가능하도록 설정하는 case
    if(!pattern1.test(signUp.MPassword.value)||!pattern2.test(signUp.MPassword.value)||!pattern3.test(signUp.MPassword.value)){
		pwdWarn2.style.display = 'block';
		signUp.MPassword.focus();
        return;
    } else if(signUp.MPassword.value.length<8||signUp.MPassword.value.length>50) {
		pwdWarn2.style.display = 'block';
		signUp.MPassword.focus();
		return;
	} else {
		pwdWarn2.style.display = 'none';
	}

	//패스워드 확인 case
	if(signUp.pwdCommit.value != signUp.MPassword.value){
		pwdWarn3.style.display = 'block';
		signUp.pwdCommit.focus();
		return;
	} else {
		pwdWarn3.style.display = 'none';
	}

	//탄생년도 미입력 case
	if(signUp.MBirthday.value.length == 0){
		birthWarn1.style.display = 'block';
		signUp.MBirthday.focus();
		return;
	} else {
		birthWarn1.style.display = 'none';
	}

	//탄생년도가 1922~2022년 사이만 입력하도록 설정하는 case
	if(signUp.MBirthday.value < 1922 || signUp.MBirthday.value > 2022){
		birthWarn2.style.display = 'block';
		signUp.MBirthday.focus();
		return;
	} else {
		birthWarn2.style.display = 'none';
	}

	//탄생년도에 문자 입력 case
	if(isNaN(signUp.MBirthday.value)){
		birthWarn3.style.display = 'block';
		signUp.MBirthday.focus();
		return;
	} else {
		birthWarn3.style.display = 'none';
	}

	//성별 미선택 case
	for(i=0;i<2;i++) {
      if(!document.signUp.MGender[0].checked && !document.signUp.MGender[1].checked) {
			genderWarn.style.display = 'block';
			signUp.MGender.focus();
			return;
        } else if(document.signUp.MGender[0].checked || document.signUp.MGender[1].checked) {
			genderWarn.style.display = 'none';
			break;
		}
    }
	//중복확인 후 닉네임 변경 방지 case
	var nickR = document.getElementById("nickR_forJs").value;
	if(nickR != 0 && nickR != signUp.MNickname.value) {
		nickWarn4.style.display = 'block';
		if(nickWarn2_1 != null){
	    	nickWarn2_1.classList.add("hidden");
	    }
		signUp.MNickname.focus();
		return;
	} else if(nickR == 0) {
		signUp.MNickname.focus();
		return;
	}

	document.signUp.submit();
}

/**
 * 중복확인 유효성 검사
 */
function nick_check(){
	//경고문 필드
	var nickWarn1 = document.getElementById("nicknameWarn1");
	var nickWarn2 = document.getElementById("nicknameWarn2");
	var nickWarn2_1 = document.getElementById("nicknameWarn2_1");
	//넘겨줄 닉네임 필드
	var nick_input = document.getElementById("MNickname").value;
	//중복체크 시 닉네임 미입력 case
	if(signUp.MNickname.value.length == 0){
		nickWarn1.style.display = 'block';
		if(nickWarn2 == null){
			nickWarn2_1.classList.add("hidden");
		} else {
    		nickWarn2.classList.add("hidden");
		}
		signUp.MNickname.focus();
		return;
	} else {
		nickWarn1.style.display = 'none';

		location.href = "nickCheck.jsp?nick=" + nick_input;
	}
}
