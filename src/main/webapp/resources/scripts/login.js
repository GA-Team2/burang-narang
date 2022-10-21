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
 * 로그인 시 아이디와 패스워드 체크 함수
 */
function loginCheck(){
    //ajax 호이스팅
    ajax();
    //Input값이 null일 경우의 경고문 출력 함수 호이스팅
    warningNull();

    /**
     * ajax 콜
     */
    function ajax(){

        // XMLHttpRequest 객체 생성
        const xhr = new XMLHttpRequest();
        // HTTP 요청 초기화
        xhr.open('POST', '/login/loginCheck');

        // HTTP 요청 전송
        xhr.send(nick.value);

        // load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
        xhr.onload = () => {
            if (xhr.status === 200) 
                //요청 데이터를 제이슨 타입으로 파싱 후 list에 저장
                const list = JSON.parse(xhr.response);
                //Input값이 null이 아닐 때 경고문 출력 함수 호이스팅(매개변수에 list 대입)
                warningCheck(list);
            } else {
                console.error('Error', xhr.status, xhr.statusText);
            }
        }
    }
}

function warningNull() {
    if (nick.value.length == 0 && pwd.value.length == 0) {
        nickWarn.innerText = "닉네임을 입력해주세요.";
        nick.focus();
    } else if(nick.value.length == 0 && pwd.value.length != 0) {
        nickWarn.innerText = "닉네임을 입력해주세요.";
        pwdWarn.innerText = "";
    } else if(nick.value.length != 0 && pwd.value.length == 0) {
        nickWarn.innerText = "";
        pwdWarn.innerText = "패스워드를 입력해주세요.";
        pwd.focus();
    }
}

function warningCheck(list){
    if (list != null){
        if (nick.value == list[0] && pwd.value == list[1]){
            login.submit();
        } else if(nick.value == list[0] && pwd.value != list[1] && pwd.value.length == 0) {
            nickWarn.innerText = "";
            pwdWarn.innerText = "비밀번호가 맞지않습니다.";
            pwd.focus();
        } else if(nick.value != list[0]) {
            nickWarn.innerText = "존재하지않는 닉네임입니다.";
            pwdWarn.innerText = "";
            nick.focus();
        }
    }
}