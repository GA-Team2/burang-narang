//닉네임 Input
let nick = document.getElementById("memberNickname");
//패스워드 Input
let pwd = document.getElementById("memberPassword");
//닉네임 경고문
const nickWarn = document.getElementById("nickWarning");
//패스워드 경고문
const pwdWarn = document.getElementById("pwdWarning");
//로그인 Form name
const login = document.loginForm;

/**
 * 로그인 페이지 onload 함수
 */
window.onload = function () {
    enterEvent();
}

/**
 * 로그인 시 아이디와 패스워드 체크 함수
 *
 */
function loginCheck(){
    //input값이 둘 중 하나라도 null일 경우 ajax 콜이 되는 걸 방지하는 조건문
    if (nick.value.length == 0 || pwd.value.length == 0){
        //Input값이 null일 경우의 경고문 출력 함수 호이스팅
        warningNull();
        return;
    }
    //ajax 호이스팅
    ajax();

    /**
     * ajax 콜
     */
    function ajax() {
        const data = {
            'memberNickname': nick.value,
            'memberPassword': pwd.value
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
            } else if(xhr.status === 201) {
                login.submit();
            } else {
                console.error('Error', xhr.status, xhr.statusText);
            }
        }
    }
}


/**
 * Input값이 null일 경우 경고문 호출 함수
 */
function warningNull() {
    //닉네임과 패스워드가 모두 null일 경우
    if (nick.value.length == 0 && pwd.value.length == 0) {
        nickWarn.innerText = "닉네임을 입력해주세요.";
        nick.focus();
        return;
        //닉네임만 null일 경우
    } else if(nick.value.length == 0 && pwd.value.length != 0) {
        nickWarn.innerText = "닉네임을 입력해주세요.";
        pwdWarn.innerText = "";
        return;
        //패스워드만 null일 경우
    } else if(nick.value.length != 0 && pwd.value.length == 0) {
        nickWarn.innerText = "";
        pwdWarn.innerText = "패스워드를 입력해주세요.";
        pwd.focus();
        return;
    }
}

/**
 * Input값이 null이 아닌 경우 경고문 호출 함수
 * @param list DB로부터 가져온 유저 체크 용 닉네임과 패스워드를 저장한 list
 *
 */
function warningCheck(check){
    //list의 값이 null이 아니면 함수 실행
    if (check != null){
        //닉네임과 패스워드 모두 일치 시 로그인
        if(check == "ICP" && pwd.value.length != 0) {
            nickWarn.innerText = "";
            pwdWarn.innerText = "비밀번호가 맞지않습니다.";
            pwd.focus();
            //닉네임이 DB에 존재하지 않을 경우
        } else if(check == "NEN") {
            nickWarn.innerText = "존재하지않는 닉네임입니다.";
            pwdWarn.innerText = "";
            nick.focus();
        }
    }
}

/**
 * Enter 클릭시 submit이벤트 실행 함수
 */
function enterEvent() {

    document.getElementById("memberNickname")
        .addEventListener("keyup", function(e) {
            if (e.code === 'Enter') {
                document.getElementById("loginBtn").click();
            }
        });

    document.getElementById("memberPassword")
        .addEventListener("keyup", function(e) {
            if (e.code === 'Enter') {
                document.getElementById("loginBtn").click();
            }
        });
}