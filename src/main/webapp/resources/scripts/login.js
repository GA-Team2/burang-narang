let nick = document.getElementById("memberNickname");
let pwd = document.getElementById("memberPassword");
const nickWarn = document.getElementById("nickWarning");
const pwdWarn = document.getElementById("pwdWarning");
const login = document.loginForm;

function loginCheck(){
    ajax();
    warningNull();
    function ajax(){

        // XMLHttpRequest 객체 생성
        const xhr = new XMLHttpRequest();
        // HTTP 요청 초기화
        xhr.open('POST', '/login/loginCheck');

        // HTTP 요청 전송
        xhr.send(nick.value);

        // load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
        xhr.onload = () => {
            if (xhr.status === 200) {
                const list = JSON.parse(xhr.response);
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