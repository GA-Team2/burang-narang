//페이지 로딩 시 실행되는 함수
window.onload = function () {
    detail_sort();
    sessionCheck();
    like_icon();
    remove_busan();
    setMapMarkerAll(new URLSearchParams(window.location.search).get("rownum"));
    history.replaceState({}, null, location.pathname);
}

function sessionCheck() {
    if (document.getElementById('nick_s').value == "") {
        location.href = "/";
    }
}

/* 플랜 정렬 */
function detail_sort() {
    //일정 5개를 한 줄씩 묶어 5개 초과 시 .tripday 영역만큼 공간 띄우기
    //마지막 요소와 줄바꿈 되는 요소의 edge(연결선) 제거
    $(".schedule:nth-of-type(5n+1) .edge").remove();
    $(".schedule:last-child .edge").remove();
    $(".schedule:nth-of-type(5n+2)").before("<div class='none' />");

    let containers = document.getElementsByClassName("container");
    schedule = [];

    for (let i = 0; i < containers.length; i++) {
        schedule[i] = containers[i].getElementsByClassName("schedule");
        schedule[i][0].previousElementSibling.remove();
    }
}


/*
 * onclick 관련 함수
 * 취소 버튼 클릭 시 마이페이지에서 넘어왔을 경우 마이페이지로,
 * 그 외 페이지에서 넘어왔을 경우 인덱스페이지로 이동
 */
function cancle_location(mypage) {
    if (mypage == "true") {
        location.href = "/mypage";
    } else {
        location.href = "/";
    }
}


/* 페이지 로드 시 실행되는 함수 목록 */

const like = document.getElementById('like');

/* 추천 여부에 따른 아이콘 변경 */
function like_icon() {
    const likecheck = document.getElementById('likecheck').value;

    if (likecheck == 1) {
        like.classList.replace("xi-heart-o", "xi-heart");
    } else if (likecheck == 0) {
        like.classList.replace("xi-heart", "xi-heart-o");
    }
}

/* 받아온 주소 데이터에서 부산,부산광역시 제거 */
function remove_busan() {
    const location = document.getElementsByClassName("location");
    for (let i of location) {
        const loca = i.innerText.split(" ");
        locas = loca.slice(1, 4);
        i.innerText = locas.join(" ");
    }
}

function setMapMarkerAll(rownum) {
    // XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
    xhr.open('GET', '/detail/all?rownum=' + rownum);

// HTTP 요청 전송
    xhr.send();

// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        if (xhr.status === 200) {
            const spots = JSON.parse(xhr.response);
            initSpotSequence(spots[spots.length - 1].tripDay);

            spots.forEach(spot => setSpotSequence(spot.tripDay, spot.tripSequence));

            (async () => {
                try {
                    for (let spot of spots) {
                        const result = await addressSearch(spot.spotLocation);
                        setMapSpot(result, spot.tripDay, spot.tripSequence);
                    }
                } catch (e) {
                    console.log(e);
                }
            })();

            setMapZoom();
        } else {
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}

/* 좋아요 */
const likeNum = document.getElementById("likeNum");

function likeAjax(rownum) {
// XMLHttpRequest 객체 생성
    const xhr = new XMLHttpRequest();
// HTTP 요청 초기화
    xhr.open('GET', '/detail/like?rownum=' + rownum);
// HTTP 요청 전송
    xhr.send();
// load 이벤트는 HTTP 요청이 성공적으로 완료된 경우 발생
    xhr.onload = () => {
        const result = JSON.parse(xhr.response);
        if (xhr.status === 200) {
            likeNum.innerText = result.likeNumber;
            if (result.checkResult == 0) {
                like.classList.replace("xi-heart-o", "xi-heart");
            } else {
                like.classList.replace("xi-heart", "xi-heart-o");
            }
        } else {
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}
