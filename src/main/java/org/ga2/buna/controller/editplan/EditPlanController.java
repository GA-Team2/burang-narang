package org.ga2.buna.controller.editplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.editplan.DetailList;
import org.ga2.buna.service.editplan.PlanInfo;
import org.ga2.buna.service.makeplan.PopularTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/edit")
public class EditPlanController {

    private final PlanInfo planInfo;
    private final DetailList detailList;
    private final PopularTag popularTag;

    @GetMapping
    public String planList(Model model, HttpServletRequest request, HttpSession session) {
        int rownum = Integer.parseInt(request.getParameter("rownum"));
        String mypage = request.getParameter("mypage");
        String pop = request.getParameter("pop");

        String nick = (String) session.getAttribute("nick_s");
        model.addAttribute("nick", nick);

        log.info("플랜 번호 = {}", rownum);
        model.addAttribute("planInfo", planInfo.findInByRowNumber(rownum));
        model.addAttribute("totalTripDay", planInfo.getTotalTipDay(rownum));
        model.addAttribute("detailList", detailList.findAllByRowNumber(rownum));
        model.addAttribute("rownum", rownum);
        model.addAttribute("mypage", mypage);
        model.addAttribute("pop", pop);
        model.addAttribute("list", popularTag.findAll());

        log.debug(detailList.findAllByRowNumber(rownum).toString());

        return "EditPlan";
    }

}
