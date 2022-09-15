/* 탭 메뉴 */
$(document).ready(function() {
    $(".date li").click(function() {
        var idx = $(this).index();
        $(".date li").removeClass("active");
        $(".date li").eq(idx).addClass("active");
        $(".schedule > div").hide();
        $(".schedule > div").eq(idx).show();
    })
});