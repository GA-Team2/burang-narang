//로그인 여부 체크
// TOP 이미지, 게시판 제목 클릭 시
function click_on() {
    // 세션값(아이디) 여부 체크
    const check = document.getElementById('nickCheck').value;
    if (check == 'null' || check == "") {
        alert("로그인이 필요한 서비스입니다.")
        // 세션값(아이디)이 없을경우 로그인 페이지로 보냄
        location.href = "/login";
        // a태그에 false를 반환하여 a태그에 있는 페이지로는 이동 안함
        return false;
    }
    // 세션값(아이디)이 존재하면 a태그로 true반환 planDetail 페이지로 이동
    return true;
}

//해시태그 검색(비동기)
function searchAjax(searchNum) {
    //객체 생성
    const xhr = new XMLHttpRequest();
    //GET방식, 태그 번호를 매개변수로 받아서 검색
    xhr.open('GET', "/popularity/search?searchTag=searchTag" + searchNum);
    //전송 형식 -> json
    xhr.setRequestHeader('Content-type', 'application/json');
    //전송
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            //문자열을 배열 객체로 변환
            const sech = JSON.parse(xhr.response);
            let output = "";
            for (let i in sech) {
                output += `<tr class='Pp_table_content'>
                    <td>${sech[i].planRowNumber}</td>
                    <td><a href='/detail?rownum=${sech[i].planRowNumber}&pop=true' onclick='return click_on()'>${sech[i].planTitle}</a></td>
                    <td><div class='etc'>${sech[i].tagNameList}</div></td>
                    <td>${sech[i].memberNickName}</td>
                    <td>${sech[i].planRegisterDate}</td>
                    <td>${sech[i].planLike}</td></tr>`
            }
            //받아온 객체를 해당 클래스 아래에 집어넣음
            document.getElementById('searchBody').innerHTML = output;
            document.getElementById('Pp_page').innerHTML = '[1]';
        } else {
            alert("통신 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}

//내 게시글 검색(비동기)
function nickAjax(searchNick) {
    console.log(searchNick)
    //객체 생성
    const xhr = new XMLHttpRequest();
    //GET방식, 태그 번호를 매개변수로 받아서 검색
    xhr.open('GET', "/popularity/nick?nick=" + searchNick);
    //전송 형식 -> json
    xhr.setRequestHeader('Content-type', 'application/json');
    //전송
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            //문자열을 배열 객체로 변환
            const nicksech = JSON.parse(xhr.response);
            console.log(nicksech);
            let output = "";
            for (let i in nicksech) {
                output += `<tr class='Pp_table_content'>
                    <td>${nicksech[i].planRowNumber}</td>
                    <td><a href='/detail?rownum=${nicksech[i].planRowNumber}&pop=true' onclick='return click_on()'>${nicksech[i].planTitle}</a></td>
                    <td><div class='etc'>${sech[i].tagNameList}</div></td>
                    <td>${nicksech[i].memberNickName}</td>
                    <td>${nicksech[i].planRegisterDate}</td>
                    <td>${nicksech[i].planLike}</td></tr>`
            }
            //받아온 객체를 해당 클래스 아래에 집어넣음
            document.getElementById('searchBody').innerHTML = output;
            document.getElementById('Pp_page').innerHTML = '[1]';
        } else {
            alert("통신 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}

//페이징(비동기)
function pagingAjax(pageNum, like) {
    //객체생성
    const xhr = new XMLHttpRequest();
    //GET방식, page번호와 추천순으로 정렬할것인지 매개변수를 받음
    xhr.open('GET', "/popularity/paging?page=" + pageNum + "&like=" + like);
    //전송 방식 -> json
    xhr.setRequestHeader('Content-type', 'application/json');
    //전송
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            //문자열을 배열 객체로 변환
            const page = JSON.parse(xhr.response);
            let output = "";
            for (let i in page) {
                output += `<tr class='Pp_table_content'>
                <td>${page[i].planRowNumber}</td>
                <td><a href='/detail?rownum=${page[i].planRowNumber}&pop=true' onclick='return click_on()'>${page[i].planTitle}</a></td>
                <td><div class='etc'>${page[i].tagNameList}</div></td>
                <td>${page[i].memberNickName}</td>
                <td>${page[i].planRegisterDate}</td>
                <td>${page[i].planLike}</td></tr>`
            }
            //받아온 배열 객체를 해당 클래스 밑에 집어넣음
            document.getElementById('searchBody').innerHTML = output;
        } else {
            alert("통신 실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}

//TOP3 슬라이드
$(document).ready(function () {
    $('.Pp_rankBox').slick({
        slidesToShow: 3,
        slidesToScroll: 3,
        autoplay: false,
        autoplaySpeed: 2000,
        dots: true,
        prevArrow: $('.prevArrow'),
        nextArrow: $('.nextArrow'),
        customPaging: function (slider, i) {
            // var thumb = $(slider.$slides[i]).data();
            switch (i) {
                case 0 :
                    i = "전체";
                    break;
                case 1 :
                    i = "남자";
                    break;
                case 2 :
                    i = "여자";
                    break;
                case 3 :
                    i = "~20대";
                    break;
                case 4 :
                    i = "30대";
                    break;
                case 5 :
                    i = "40대";
                    break;
                case 6 :
                case 7 :
                case 8 :
                    i = "50대~";
                    break;
            }
            return '<a class="dot">' + i + '</a>';
        },
    });
});