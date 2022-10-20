package org.ga2.buna.controller.plandetail;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.plandetail.CheckLikeDB;
import org.ga2.buna.service.plandetail.LikeNum;
import org.ga2.buna.service.plandetail.PlanDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 플랜 디테일
 */
@Controller
@RequiredArgsConstructor
public class PlanDetailController {

    private final PlanDetail planDetail;
    private final LikeNum likeNum;
    private final CheckLikeDB checkLikeDB;

    @RequestMapping("/detail")
    public String plandetail(HttpServletRequest request, HttpSession session, Model model) {

        model.addAttribute("request", request);
        planDetail.execute(model);
        model.addAttribute("likeNum", likeNum.getLikeNum(model));
        model.addAttribute("checkLike", checkLikeDB.getDB(model));

        return "PlanDetail";
    }

    @RequestMapping("/likecheck")
    public String likecheck(@RequestParam int rownum, Model model) {

        model.addAttribute("rownum", rownum);

        return "/mypage";
    }

}
