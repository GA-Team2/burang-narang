var publicView = document.getElementsByClassName('share');
var publicCheck = document.getElementsByClassName('publicCheck');

window.onload = function () {
    public_check();
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
/* 플랜 삭제 확인창 */
function delete_ok(rownum, i) {
    let result = confirm("일정을 삭제하시겠습니까?");
    if (result == true) {
        delete_plan_ajax(rownum, i);
    }
}


/* 공개/비공개 알림창 */
function sharecheck(shared, rownum, i) {
    let result;
    if (shared == 1) {
        result = confirm("확인버튼 클릭 시 일정이 비공개됩니다.");
        if (result == true) {
            shareajax(shared, rownum, i);
            // location.href = "/mypage/share?rownum=" + rownum + "&shared=" + shared;
        }
    } else {
        result = confirm("확인버튼 클릭 시 일정이 공개됩니다.");
        if (result == true) {
            shareajax(shared, rownum, i);
            // location.href = "/mypage/share?rownum=" + rownum + "&shared=" + shared;
        }
    }
}

function shareajax(shared, rownum, i) {
// XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
    xhr.open('GET', "/mypage/share?rownum=" + rownum + "shared = " + shared);
// HTTP 요청 전송
    xhr.send();
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        if (xhr.status === 200) {
            alert("플랜이 삭제되었습니다.");
            document.getElementById("plan"+i).remove();
        } else {
            alert("삭제 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}



/* 플랜 삭제 ajax */
function delete_plan_ajax(rownum, i) {
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
            document.getElementById("plan"+i).remove();
        } else {
            alert("삭제 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}