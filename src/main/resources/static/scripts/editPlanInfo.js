/**
 *  planDetail 작성 중 planInfo 수정하려고 할 때 플랜 모달 수정하는 메서드
 */
function getPlanInfo() {
    modalArea.classList.remove("modal_hidden");
    infoBtn.setAttribute("value", "수정");
    infoBtn.name = "edit";
    const cancel = planInfo.cancel;
    cancel.setAttribute("onclick", "closeEdit()");
}

/**
 * plan Info 갱신하는 메서드
 */
function editCheck() {
    const pr_title = p_title.value;
    const pr_first = p_firstdate.value;
    const pr_last = p_lastdate.value;
    const pr_taglist = t_namelist.value;

    if (titleValue != pr_title) {
        p_title.setAttribute("value", titleValue);
        document.getElementById("plan_title").children[0].innerHTML = titleValue;
    }
    if (taglistValue != pr_taglist) t_namelist.setAttribute("value", taglistValue);

    // 날짜가 변경되었다면 editplan 실행
    if (firstValue != pr_first || lastValue != pr_last) {
        editPlanInfo();
    } else closeEdit();
}

/**
 *  plan info의 날짜가 변경되었다면 실행되는 메서드
 */
function editPlanInfo() {
    if (window.confirm("날짜를 수정하시겠습니까?\n수정하시면 작성된 플랜은 삭제됩니다.")) {
        // plan detail 전체 삭제
        const tabCon = document.getElementById("day_tab_con");
        const tabLength = tabCon.children.length
        for (let i = 0; i < tabLength; i++) {
            tabCon.children[0].remove();
        }
        const planCon = document.getElementById("plan_lists_container");
        const planLength = planCon.children.length;
        for (let i = 0; i < planLength; i++) {
            planCon.children[0].remove();
        }
        planDetail.scrollTop = 0;
        resetDay();
        clearPlace();
        makePlanInfo();
    } else closeEdit();
}

/**
 *  plan Info 수정 페이지 닫는 메서드
 */
function closeEdit() {
    modalArea.classList.add("modal_hidden");
}