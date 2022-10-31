const loginForm = document.loginForm;
nickName = loginForm.nick;
nickPwd = loginForm.pwd;


/**
 * 로그인 시 아이디와 패스워드 체크 함수
 *
 */
function loginCheck() {
    //input값이 둘 중 하나라도 null일 경우 ajax 콜이 되는 걸 방지하는 조건문
    if (nickName.value.length == 0 || nickPwd.value.length == 0) {
        //Input값이 null일 경우의 경고문 출력 함수 호이스팅
        warningNull();
        return;
    }
    //ajax 호이스팅
    ajax();
}

/**
 * Input값이 null일 경우 경고문 호출 함수
 */
function warningNull() {
    //닉네임과 패스워드가 모두 null일 경우
    if (nickName.value.length == 0 && nickPwd.value.length == 0) {
        nickWarn.innerText = "닉네임을 입력해주세요.";
        nickName.focus();
        return;
        //닉네임만 null일 경우
    } else if (nickName.value.length == 0 && nickPwd.value.length != 0) {
        nickWarn.innerText = "닉네임을 입력해주세요.";
        pwdWarn.innerText = "";
        return;
        //패스워드만 null일 경우
    } else if (nickName.value.length != 0 && nickPwd.value.length == 0) {
        nickWarn.innerText = "";
        pwdWarn.innerText = "패스워드를 입력해주세요.";
        nickPwd.focus();
        return;
    }
}

/**
 * Input값이 null이 아닌 경우 경고문 호출 함수
 * @param list DB로부터 가져온 유저 체크 용 닉네임과 패스워드를 저장한 list
 *
 */
function warningCheck(check) {
    //list의 값이 null이 아니면 함수 실행
    if (check != null) {
        //닉네임과 패스워드 모두 일치 시 로그인
        if (check == "ICP" && pwd.value.length != 0) {
            nickWarn.innerText = "";
            pwdWarn.innerText = "비밀번호가 맞지않습니다.";
            nickPwd.focus();
            //닉네임이 DB에 존재하지 않을 경우
        } else if (check == "NEN") {
            nickWarn.innerText = "존재하지않는 닉네임입니다.";
            pwdWarn.innerText = "";
            nickName.focus();
        }
    }
}

/**
 * ajax 콜
 */
function ajax() {
    const data = {
        'memberNickname': nickName.value,
        'memberPassword': nickPwd.value
    };


    // XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
    // HTTP 요청 초기화
    xhr.open('POST', '/login/check');

    xhr.setRequestHeader('Content-Type', 'application/JSON');
    // HTTP 요청 전송
    xhr.send(JSON.stringify(data));

    // load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        if (xhr.status === 200) {
            //요청 데이터를 제이슨 타입으로 파싱 후 list에 저장
            const check = xhr.response;
            //Input값이 null이 아닐 때 경고문 출력 함수 호이스팅(매개변수에 list 대입)
            warningCheck(check);
        } else if (xhr.status === 201) {
            completeLogin(nickName.value);
        } else {
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}

function completeLogin(nick) {
    // XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
    // HTTP 요청 초기화
    xhr.open('GET', '/new/login?nick=' + nick);

    //xhr.setRequestHeader('Content-Type', 'application/JSON');
    // HTTP 요청 전송
    xhr.send(nick);

    // load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        if (xhr.status === 200) {
            planDetail.m_nickname.value = nickName.value;
            document.getElementById('login').classList.add("hidden");
            document.getElementById("plan_submit").setAttribute("onClick", "planCheck()");
        } else {
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}

/*
	makeplan시 로그인 하지 않았을때 발생하는 메서드
*/

// 로그인 모달 창
function loginAlert() {
    document.getElementById('login').classList.remove("hidden");
}

// 로그인 취소
function cancel_login() {
    document.getElementById('login').classList.add("hidden");
}