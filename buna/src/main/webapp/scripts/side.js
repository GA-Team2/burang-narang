// 사이드 바 이동
$(document).ready(function () {
    // side x좌표 이동 
    $('.side_button').click(function () {
        // r 값 : 오른쪽에서 x 좌표 위치
        // 초기값 0
        var r = $('.side_bar').css('right');
        var w = '-' + $('.side_bar').css('width');
        console.log(w);
        if (r == '0px') {
            $('.side_bar').animate({ 'right': w }, 500);
            // 바뀐 좌표 재 대입
            r = $('.side_bar').css('right');
        } else {
            $('.side_bar').animate({ 'right': 0 }, 500);
            // 바뀐 좌표 재 대입
            r = $('.side_bar').css('right');
        }
    });
});