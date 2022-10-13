/* planDetail 작성 중 planInfo 수정하려고 할 때 */
function getPlanInfo() {
    // 모달 생성
    $('.modal_zone').removeClass('modal_hidden');
    var modal = document.querySelector(".modal_zone");
    if(modal.classList.contains("hidden")) modal.classList.remove("hidden");

    // onclick 메서드 수정
    infoBtn.setAttribute("value", "수정");
    infoBtn.name = "edit";

    var cancel = document.querySelector(".modal_cancel");
    cancel.setAttribute("onclick", "closeEdit()");
}

/* plan Info 갱신 */
function editCheck() {
    const pr_title = p_title.value;
    const pr_first = p_firstdate.value;
    const pr_last = p_lastdate.value;
    const pr_taglist = t_namelist.value;

    // 제목 갱신
    if(titleValue != pr_title){
        p_title.setAttribute("value", titleValue);
        document.querySelector(".plan_sub").children[0].innerHTML = titleValue;
    }

    // 태그 리스트 갱신
    if(taglistValue != pr_taglist) t_namelist.setAttribute("value", taglistValue);

    // 날짜가 변경되었다면 editplan 실행
    if(firstValue != pr_first || lastValue != pr_last){
        editPlanInfo();
    } else $('.modal_zone').addClass('modal_hidden');
}

/* plan info의 날짜가 변경되었다면 실행되는 메서드 */
function editPlanInfo() {
    if(window.confirm("날짜를 수정하시겠습니까?\n수정하시면 작성된 플랜은 삭제됩니다.")) {
        //info 수정
        //detail 전체 삭제
        var tab_con = document.querySelector(".day_plan_tab");
        var i = tab_con.children.length;
        for(var j = 0; j < i; j++){
            tab_con.children[0].remove();
        }
        var plan_con = document.querySelector(".day_plan_con");
        var x = plan_con.children.length;
        for(var j = 0; j < x; j++){
            plan_con.children[0].remove();
        }

        planDetail.scrollTop = 0;
        resetDay();
        clearPlace();

        makePlanInfo();
    } else $('.modal_zone').addClass('modal_hidden');
}

/* plan Info 수정 페이지 닫는 메서드 */
function closeEdit() {
    $('.modal_zone').addClass('modal_hidden');
}