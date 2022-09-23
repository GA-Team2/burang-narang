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
			    if (i=='0'){
			      i = "전체";
			    } else if (i=='1'){
			      i = "남자";
			    } else {
			      i = "여자"
			    }
			    return '<a class="dot">'+i+'</a>';
			    },
		  });
		});