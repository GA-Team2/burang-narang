/* planDetail 작성 중 planInfo 수정하려고 할 때 */
function getPlanInfo() {
    modalArea.classList.remove("modal_hidden");

    // onclick 메서드 수정
    infoBtn.setAttribute("value", "수정");
    infoBtn.name = "edit";

    const cancel = planInfo.cancel;
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
        document.getElementById("plan_title").children[0].innerHTML = titleValue;
    }

    // 태그 리스트 갱신
    if(taglistValue != pr_taglist) t_namelist.setAttribute("value", taglistValue);

    // 날짜가 변경되었다면 editplan 실행
    if(firstValue != pr_first || lastValue != pr_last){
        editPlanInfo();
    } else modalArea.classList.add('modal_hidden');
}

/* plan info의 날짜가 변경되었다면 실행되는 메서드 */
function editPlanInfo() {
    if(window.confirm("날짜를 수정하시겠습니까?\n수정하시면 작성된 플랜은 삭제됩니다.")) {
        // plan detail 전체 삭제
        const tabCon = document.getElementById("day_tab_con");
        const tabLength = tabCon.children.length
        for(let i = 0; i < tabLength; i++){
            tabCon.children[0].remove();
        }

        const planCon = document.getElementById("plan_lists_container");
        const planLength = planCon.children.length;
        for(let i = 0; i < planLength; i++){
            planCon.children[0].remove();
        }

        planDetail.scrollTop = 0;
        resetDay();
        clearPlace();
        makePlanInfo();

    } else modalArea.classList.add("modal_hidden");
}

/* plan Info 수정 페이지 닫는 메서드 */
function closeEdit() {
    modalArea.classList.add("modal_hidden");
}