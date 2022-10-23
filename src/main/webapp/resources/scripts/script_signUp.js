/**
 *회원가입 유효성 검사
 */

//경고문 필드


function sign_ok(){

	const nick = document.getElementById("memberNickname").value;
	let nickWarn = document.getElementById("nicknameWarn");
	const pwdWarn = document.getElementById("pwdWarn");
	const pwdWarnCommit = document.getElementById("pwdWarnCommit");
	const birthWarn = document.getElementById("birthWarn");
	const genderWarn = document.getElementById("genderWarn");

	//닉네임 유효성
	if(signUp.memberNickname.value.length == 0){
		nickWarn.innerText = '필수 항목입니다.';
		signUp.memberNickname.focus();
		return;
	} else if(signUp.memberNickname.value.length > 6){
		nickWarn.innerText = '닉네임은 최대 6자까지 가능합니다.';
		signUp.memberNickname.focus();
		return;
	} else {
		nickWarn.innerText = '';
	}

	var message = ajax(nick);
	console.log(message);

	//닉네임 중복여부
	if(message === 'exist') {
		nickWarn.innerText = '중복되는 닉네임이 존재합니다.';
		signUp.memberNickname.focus();
		nickWarn.style.color = 'red';
		return;
	} else if(message === 'available') {
		nickWarn.innerText = '사용가능한 닉네임 입니다.'
		nickWarn.style.color = 'blue';
	}

	//패스워드 미입력 case
	if(signUp.memberPassword.value.length == 0){
		pwdWarn.innerText = '필수 항목입니다.';
		signUp.memberPassword.focus();
		return;
	} else {
		pwdWarn.innerText = '';
	}
	
	//패스워드 보안강화 유효성 강화 변수
	var pattern1 = /[0-9]/;

    var pattern2 = /[a-zA-Z]/;

    var pattern3 = /[~!@\#$%<>^&*]/;

	//패스워드 영어 + 특수문자 + 숫자 조합만 가능하도록 설정하는 case
    if(!pattern1.test(signUp.memberPassword.value)||!pattern2.test(signUp.memberPassword.value)||!pattern3.test(signUp.memberPassword.value)){
		pwdWarn.innerText = '비밀번호는 영문자/특수문자를 포함한 8글자 이상이어야 합니다.';
		signUp.memberPassword.focus();
        return;
    } else if(signUp.memberPassword.value.length<8||signUp.memberPassword.value.length>50) {
		pwdWarn.innerText = '비밀번호는 영문자/특수문자를 포함한 8글자 이상이어야 합니다.';
		signUp.memberPassword.focus();
		return;
	} else {
		pwdWarn.innerText = '';
	}

	//패스워드 확인 case
	if(signUp.pwdCommit.value != signUp.memberPassword.value){
		pwdWarnCommit.innerText = '비밀번호와 일치하지않습니다.';
		signUp.pwdCommit.focus();
		return;
	} else {
		pwdWarnCommit.innerText = '';
	}

	//탄생년도 유효성
	if(signUp.memberBirthyear.value.length == 0){
		birthWarn.innerText = '필수 항목입니다.';
		signUp.memberBirthyear.focus();
		return;
	} else if(signUp.memberBirthyear.value < 1922 || signUp.memberBirthyear.value > 2022){
		birthWarn.innerText = '1922~2022년까지만 입력해주세요.';
		signUp.memberBirthyear.focus();
		return;
	} else if(isNaN(signUp.memberBirthyear.value)){
		birthWarn.innerText = '숫자만 입력해주세요.';
		signUp.memberBirthyear.focus();
		return;
	} else {
		birthWarn.innerText = '';
	}

	//성별 미선택 case
	for(i=0;i<2;i++) {
      if(!document.signUp.memberGender[0].checked && !document.signUp.memberGender[1].checked) {
			genderWarn.innerText = '필수 항목입니다.';
			return;
        } else if(document.signUp.memberGender[0].checked || document.signUp.memberGender[1].checked) {
			genderWarn.style.display = 'none';
			break;
		}
    }

	alert("가입이 완료되었습니다.");
	document.signUp.submit();
}

/**
 * 중복체크를 위한 ajax 콜 함수
 */
function ajax(nick) {
	var message;

	// XMLHttpRequest 객체 생성
	const xhr = new XMLHttpRequest();
	// HTTP 요청 초기화
	xhr.open('POST', 'signup/check', false);

	// HTTP 요청 전송
	xhr.send(nick);

	// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
	xhr.onload = () => {
		if (xhr.status === 201) {
			const str = xhr.response;
			message = str;
			console.log(message);
		} else {
			console.error('Error', xhr.status, xhr.statusText);
		}
	}
	return message;
}

/**
 * 중복체크 유효성 경고문을 위한 함수
 * @param str
 */
// function nickCheck(str) {
//
// 	let nickWarn = document.getElementById("nicknameWarn");
//
// 	let message = '';
//
// 	if (str == 'exist') {
// 		message = str;
// 		return message;
// 	} else if(str === 'available') {
// 		return 'available';
// 	}
// }