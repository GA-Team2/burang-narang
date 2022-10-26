//로그인 여부 체크
// TOP 이미지, 게시판 제목 클릭 시
function click_on() {
    // 세션값(아이디) 여부 체크
    const check = document.getElementById('nickCheck').value;
    console.log("nick : " + check);
    if (check == 'null' || check == "") {
        alert("로그인을 하셔야합니다")
        // 세션값(아이디)이 없을경우 로그인 페이지로 보냄
        location.href = "/login";
        // a태그에 false를 반환하여 a태그에 있는 페이지로는 이동 안함
        return false;
    }
    // 세션값(아이디)이 존재하면 a태그로 true반환 planDetail 페이지로 이동
    return true;
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
            var thumb = $(slider.$slides[i]).data();
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

function searchBoard(searchNum) {
    const xhr = new XMLHttpRequest();


    xhr.open('GET', "/popularity/board?searchTag=searchTag" + searchNum);
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send();
    xhr.onload = () => {
        if (xhr.status === 200) {
            console.log('통신 성공');
            const result = JSON.parse(xhr.response);

            let output = "";
            console.log(result)
            for (let i in result ){
                for (let j in result[i]){
                    // console.log(result[i][j]);
                output += '<h1>'+j + '-->'+result[i][j]+'</h1>';

                // output += '<h1>'+result[i].planRownum+'</h1>';
                // output += '<h1>'+result[i].planTitle+'</h1>';
                // output += '<h1>'+result[i].tagNamelist+'</h1>';
                // output += '<h1>'+result[i].planRegdate+'</h1>';
                // output += '<h1>'+result[i].planLike+'</h1>';

                }
            }
            document.body.innerHTML += output;
        } else {
            alert("실패");
            console.error('Error', xhr.status, xhr.statusText);
        }
    }
}


// function pagingBoard() {
// 	const xhr = new XMLHttpRequest();
// 	// const date = {"like" : true};
// 	xhr.open('POST',"/PopularityPlan?like=true",true);
// 	xhr.setRequestHeader("Content-Type", "application/json");
// 	xhr.send();
//
// 	xhr.onreadystatechange = function (){
// 		if (xhr.readyState === 4) { //수신 완료
// 			if (xhr.status === 200) {
// 			console.log(xhr.responseText); // 통신 성공
// 			console.log('통신 성공');
// 			} else {
// 			console.log('서버 에러 발생');
// 			}
// 		} else { //통신 완료 전
// 			console.log('통신 중');
// 		}
// 	}
//
// }
