var inputYear = document.getElementById('year');
var db_birthYear = document.getElementById('db_birthYear');
var db_gender = document.getElementById('db_gender');
var edit_pw = document.getElementById('password');
var edit_chpw = document.getElementById('pwcheck');
var check_result = document.getElementById('pwCheckResult');
var confirm_result = document.getElementById('pwConfirmCheckResult');
var inputGender = document.getElementsByName('memberGender');
var currentpw = document.getElementById("currentpassword");
var currentpwcheck = document.getElementById("currentpwcheck");
var pwajax = document.getElementById("pwajax");

window.onload = function () {
    select_year();
    get_dbinfo_birth();
    get_dbinfo_gender();
    pw_confirm();
}

/* 생년 select box 생성 */
function select_year() {
    var now = new Date();
    var year = now.getFullYear();

    for (var i = year - 100; i <= year; i++) {
        inputYear.innerHTML += '<option value ="' + i + '">' + i + '</option>';
    }
}

/* db에 저장된 생년 불러와서 수정 폼에 저장 */
function get_dbinfo_birth() {
    for (var i = 0; i < inputYear.options.length; i++) {
        if (inputYear[i].value === db_birthYear.value) {
            inputYear[i].selected = true;
        }
    }
}

/* db에 저장된 성별 불러와서 수정 폼에 저장 */
function get_dbinfo_gender() {
    for (var i = 0; i < inputGender.length; i++) {
        if (inputGender[i].value === db_gender.value) {
            inputGender[i].checked = true;
        }
    }
}

/* 비밀번호 입력 일치 확인 */
function pw_confirm() {
    currentpw.addEventListener('keyup', function () {
        currentpwcheck.innerText = '';
        pwajax.disabled = '';
        currentpwcheck.style.color = 'red';
    });

    edit_pw.addEventListener('keyup', function () {
        check_result.innerText = '';
        confirm_result.innerText = '';
    });

    edit_chpw.addEventListener('keyup', function () {
        if (edit_pw.value != edit_chpw.value) {
            confirm_result.style.color = 'red';
            confirm_result.innerText = '비밀번호가 일치하지 않습니다.';
        } else {
            confirm_result.style.color = 'blue';
            confirm_result.innerText = '비밀번호가 일치합니다.';
        }
    })
}

// onclick 함수

/* 비밀번호 입력 확인 */
function info_Check() {
    // 비밀번호 유효성 체크 정규식
    const regExp = /^.*(?=^.{8,49}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

    if (!currentpw.value) {
        currentpwcheck.innerText = "현재 비밀번호를 입력하세요";
        return;
    }
    if (pwajax.disabled === false) {
        currentpwcheck.innerText = '비밀번호 일치 확인을 해주세요.';
        return;
    }
    if (edit_chpw.value && !edit_pw.value) {
        check_result.innerText = "변경할 비밀번호를 입력하세요";
        return;
    }
    if (edit_pw.value && !edit_chpw.value) {
        confirm_result.innerText = "비밀번호 확인란을 입력하세요.";
        return;
    }
    if ((edit_pw.value && edit_chpw.value) && !regExp.test(edit_pw.value)) {
        check_result.innerText = "비밀번호는 소문자, 숫자, 특수문자를 포함하여 8자 이상 입력하세요.";
        return;
    }
    if (edit_pw.value != edit_chpw.value) {
        confirm_result.innerText = "비밀번호를 확인해주세요.";
        return;
    }

    edit_memberinfo_ajax();
}

/* 선택된 성별 값 가져오기 */
function getgender() {
    for (var i = 0; i < inputGender.length; i++) {
        if (inputGender[i].checked) {
            return inputGender[i].value;
        }
    }
}


/* 회원 정보 수정 ajax */
function edit_memberinfo_ajax() {
    /* 선택된 성별 값 */
    var gender = getgender();

    //보낼 데이터
    const data = JSON.stringify({
        "memberPassword": edit_pw.value,
        "memberBirthyear": inputYear.value,
        "memberGender": gender
    });

    console.log(data);

// XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
    xhr.open('POST', "/mypage/edit");
    xhr.setRequestHeader('Content-type', 'application/json');
// form 데이터 전송
    xhr.send(data);
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        if (xhr.status === 201) {
            alert("회원정보가 수정되었습니다.");
            location.href = "/mypage";
        } else {
            alert("수정 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}


/* 정보 수정 시 비밀번호 일치 확인 */
function pwcheckajax() {
    const inputpw = JSON.stringify({
        "memberPw": currentpw.value
    });
// XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
    xhr.open('POST', "/mypage/check");
    xhr.setRequestHeader('Content-type', 'application/json');
// form 데이터 전송
    xhr.send(inputpw);
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        const result = xhr.response;
        if (xhr.status === 201 && result == 1) {
            currentpwcheck.style.color = 'blue';
            currentpwcheck.innerText = '비밀번호가 일치합니다.';
            pwajax.disabled = true;
        } else if (xhr.status === 201 && result == 0) {
            currentpwcheck.innerText = '비밀번호가 일치하지 않습니다.';
            // return;
        } else {
            alert("통신 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}