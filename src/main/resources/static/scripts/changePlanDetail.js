/**
 * 플랜의 순서를 바꾸는 메서드 - 앞 순서의 플랜과 순서 변경
 *
 * @param 순서 변경 버튼 요소
 */
function changeUpPlan(up) {
    const thisPlan = up.parentNode.parentNode;
    const plan = getPlanSeq(thisPlan);
    const parent = thisPlan.parentNode;

    if (document.getElementById("plan_list" + plan.tripDay + "_" + (plan.seq - 1)) != null) {
        const prev = document.getElementById("plan_list" + plan.tripDay + "_" + (plan.seq - 1));
        changePlanSeq(prev, plan.tripDay, plan.seq);
        changePlanSeq(thisPlan, plan.tripDay, plan.seq - 1);
        moveSpotSequence("up", plan.tripDay, plan.seq);
        parent.insertBefore(thisPlan, prev);
    }
}

/**
 * 플랜의 순서를 바꾸는 메서드 - 뒷 순서의 플랜과 순서 변경
 *
 * @param 순서 변경 버튼 요소
 */
function changeDownPlan(down) {
    const thisPlan = down.parentNode.parentNode;
    const plan = getPlanSeq(thisPlan);
    const parent = thisPlan.parentNode;

    if (document.getElementById("plan_list" + plan.tripDay + "_" + (plan.seq + 1)) != null) {
        const next = document.getElementById("plan_list" + plan.tripDay + "_" + (plan.seq + 1));
        changePlanSeq(next, plan.tripDay, plan.seq);
        changePlanSeq(thisPlan, plan.tripDay, plan.seq + 1);
        moveSpotSequence("down", plan.tripDay, plan.seq);
        parent.insertBefore(next, thisPlan);
    }
}

/**
 * 순서를 변경할 플랜의 플랜 순서 갱신
 *
 * @param 플랜 요소, 여행 일자, 플랜 순서
 */
function changePlanSeq(plan, tday, seq) {
    plan.children[0].children[1].innerHTML = seq;
    plan.children[1].children[1].innerHTML = "일정" + seq;
    plan.children[1].children[2].setAttribute("value", seq);
    plan.setAttribute("id", "plan_list" + tday + "_" + seq);
}

/**
 * 플랜 요소 삭제 메서드
 *
 * @param 삭제 버튼
 */
function removePlan(removeButton) {
    const thisPlan = removeButton.parentNode.parentNode;
    const plan = getPlanSeq(thisPlan);

    // 지도 좌표 삭제
    deleteSpot(plan.tripDay, plan.seq);

    while (document.getElementById("plan_list" + plan.tripDay + "_" + (plan.seq + 1)) != null) {
        const next = document.getElementById("plan_list" + plan.tripDay + "_" + (plan.seq + 1));
        changePlanSeq(next, plan.tripDay, plan.seq);

        plan.seq++;
    }
    setDay(plan.tripDay, plan.seq);
    thisPlan.remove();
}

/**
 * 플랜 요소의 여행 일자와 플랜 순서를 반환하는 메서드
 *
 * @param 플랜 요소
 * @returns 여행 일자, 플랜 순서
 */
function getPlanSeq(thisPlan) {
    const planId = thisPlan.getAttribute("id");
    const plan = {
        tripDay: Number(planId.substring(9, planId.indexOf("_", 9))),
        seq: Number(planId.substring(planId.indexOf("_", 9) + 1))
    };
    return plan;
}