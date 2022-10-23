//TOP3 슬라이드
$(document).ready(function(){
		  $('.Pp_rankBox').slick({
			  slidesToShow: 3,
			  slidesToScroll: 3,
			  autoplay: false,
			  autoplaySpeed: 2000,
			  dots : true,
			  prevArrow: $('.prevArrow'), 
			  nextArrow: $('.nextArrow'),
			    customPaging : function(slider, i) {
			    var thumb = $(slider.$slides[i]).data();
				switch (i) {
				case 0 : i = "전체";		break;
				case 1 : i = "남자";		break;
				case 2 : i = "여자";		break;
				case 3 : i = "~20대";	break;
				case 4 : i = "30대";		break;
				case 5 : i = "40대";		break;
				case 6 :
				case 7 :
				case 8 : i = "50대";		break;
				}
			    return '<a class="dot">'+i+'</a>';
			    },
		  });
		});

//로그인 여부 체크
// TOP 이미지, 게시판 제목 클릭 시
function click_on() {
	// 세션값(아이디) 여부 체크
	// const check = '<%= nick %>';
	const check = document.getElementById('nickCheck').value;
	console.log(check);
	if (check == 'null' || check == "") {
		alert("로그인을 하셔야합니다")
		// 세션값(아이디)이 없을경우 로그인 페이지로 보냄
		location.href = "Login.jsp";
		// a태그에 false를 반환하여 a태그에 있는 페이지로는 이동 안함
		return false;
	}
	// 세션값(아이디)이 존재하면 a태그로 true반환 planDetail 페이지로 이동
	return true;
}
