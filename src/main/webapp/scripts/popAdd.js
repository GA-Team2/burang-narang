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