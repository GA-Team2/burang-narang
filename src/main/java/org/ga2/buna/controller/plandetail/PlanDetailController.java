package org.ga2.buna.controller.plandetail;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.plandetail.LikeCheck;
import org.ga2.buna.service.plandetail.PlanDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 플랜 디테일
 */
@Controller
@RequiredArgsConstructor
public class PlanDetailController {

    private final PlanDetail planDetail;
    private final LikeCheck likeCheck;

    @RequestMapping("/plandetail")
    public String plandetail(HttpServletRequest request, Model model) {

        model.addAttribute("request", request);
        planDetail.execute(model);

        return "PlanDetail";
    }

    @RequestMapping("/likecheck")
    public String likecheck(@RequestParam int rownum, Model model) {

        model.addAttribute("rownum", rownum);
        model.addAttribute("likeNum", likeCheck.getLikeNum(model));

        return "redirect:/mypage";
    }
}
