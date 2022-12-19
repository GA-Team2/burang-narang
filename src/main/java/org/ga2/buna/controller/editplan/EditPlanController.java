package org.ga2.buna.controller.editplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.editplan.planWithSpotList;
import org.ga2.buna.service.editplan.PlanInfo;
import org.ga2.buna.service.makeplan.PopularTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 플랜 수정 및 인기 플랜 복사 페이지
 *
 * @author 한애채
 */
@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/edit")
public class EditPlanController {

    private final PlanInfo planInfo;
    private final planWithSpotList planWithSpotList;
    private final PopularTag popularTag;

    /**
     * 플랜 수정 및 인기 플랜 복사 페이지
     *
     * @param model   페이지에 표시할 데이터
     * @param request 페이지 요청 변수
     * @param session 회원 정보 받아오는 세션
     * @return 플랜 수정 및 인기 플랜 복사 페이지
     */
    @GetMapping
    public String planList(Model model, HttpServletRequest request, HttpSession session) {
        int rownum = Integer.parseInt(request.getParameter("rownum"));
        String mypage = request.getParameter("mypage");
        String pop = request.getParameter("pop");

        String nick = (String) session.getAttribute("nick_s");
        model.addAttribute("nick", nick);

        model.addAttribute("planInfo", planInfo.findInByRowNumber(rownum));
        model.addAttribute("totalTripDay", planInfo.getTotalTipDay(rownum));
        model.addAttribute("detailList", planWithSpotList.findAllByRowNumber(rownum));
        model.addAttribute("rownum", rownum);
        model.addAttribute("mypage", mypage);
        model.addAttribute("pop", pop);
        model.addAttribute("list", popularTag.findAll());

        return "EditPlan";
    }

}
