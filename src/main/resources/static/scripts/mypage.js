var inputYear = document.getElementById('year');
var db_birthYear = document.getElementById('db_birthYear');
var db_gender = document.getElementById('db_gender');
var edit_pw = document.getElementById('password');
var edit_chpw = document.getElementById('pwcheck');
var check_result = document.getElementById('pwCheckResult');
var confirm_result = document.getElementById('pwConfirmCheckResult');
var publicView = document.getElementsByClassName('share');
var publicCheck = document.getElementsByClassName('publicCheck');
var inputGender = document.getElementsByName('memberGender');
var currentpw = document.getElementById("currentpassword");
var currentpwcheck = document.getElementById("currentpwcheck");
var pwajax = document.getElementById("pwajax");

window.onload = function () {
    tapmenu();
    select_year();
    get_dbinfo_birth();
    get_dbinfo_gender();
    pw_confirm();
    public_check();
}

/* 탭메뉴 */
function tapmenu() {
    $("#mypage_nav li").click(function () {
        var index = $(this).index();
        $("#mypage_nav li").removeClass("active");
        $("#mypage_nav li").eq(index).addClass("active");
        $("#mypage_content>div").hide();
        $("#mypage_content>div").eq(index).show();
    });
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

/* 플랜 공개/비공개 여부 체크해서 버튼 value값 변경하기 */
function public_check() {
    for (var i = 0; i < publicView.length; i++) {
        if (publicCheck[i].value == 1) {
            publicView[i].value = '일정 비공개';
        } else if (publicCheck[i].value == 0) {
            publicView[i].value = '일정 공개';
        }
    }
}


// onclick 함수

/* 비밀번호 입력 확인 */
function info_Check() {
    // 비밀번호 유효성 체크 정규식
    const regExp = /^.*(?=^.{8,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

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


/* 플랜 삭제 확인창 */
function delete_ok(rownum) {
    let result = confirm("일정을 삭제하시겠습니까?");
    if (result == true) {
        delete_plan_ajax(rownum);
    }
}


/* 공개/비공개 알림창 */
function sharecheck(shared, rownum) {
    let result;

    if (shared == 1) {
        result = confirm("확인버튼 클릭 시 일정이 비공개됩니다.");
        if (result == true) {
            location.href = "/mypage/share?rownum=" + rownum + "&shared=" + shared;
        }
    } else {
        result = confirm("확인버튼 클릭 시 일정이 공개됩니다.");
        if (result == true) {
            location.href = "/mypage/share?rownum=" + rownum + "&shared=" + shared;
        }
    }

}


/* 플랜 삭제 ajax */
function delete_plan_ajax(rownum) {
// XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
    xhr.open('GET', "/mypage/deletep?rownum=" + rownum);
// HTTP 요청 전송
    xhr.send();
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        if (xhr.status === 200) {
            alert("플랜이 삭제되었습니다.");
            location.href = "mypage";
        } else {
            alert("삭제 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
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
            location.href = "mypage";
        } else {
            alert("수정 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}


/* 회원 정보 수정 ajax */
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
            currentpwcheck.innerText = '비밀번호가 일치합니다.';
            currentpwcheck.style.color = 'blue';
            pwajax.disabled = true;
        } else if (xhr.status === 201 && result == 0) {
            currentpwcheck.innerText = '비밀번호가 일치하지 않습니다.';
            currentpwcheck.style.color = 'red';
            // return;
        } else {
            alert("통신 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}