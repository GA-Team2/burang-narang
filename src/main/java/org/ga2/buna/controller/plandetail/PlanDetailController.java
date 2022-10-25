package org.ga2.buna.controller.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.plandetail.CheckLikeDB;
import org.ga2.buna.service.plandetail.LikeNum;
import org.ga2.buna.service.plandetail.PlanDetail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 플랜 디테일
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/detail")
public class PlanDetailController {

    private final PlanDetail planDetail;
    private final LikeNum likeNum;
    private final CheckLikeDB checkLikeDB;

    /**
     * 디테일 페이지 플랜 관련 정보 출력
     */
    @RequestMapping()
    public String plandetail(HttpServletRequest request, HttpSession session, Model model) {

        String nick = (String) session.getAttribute("nick_s");
        int rownum = Integer.parseInt(request.getParameter("rownum"));
        String mypage = request.getParameter("mypage");
        String pop = request.getParameter("pop");

        log.debug("받아온 rownum => {}", rownum);
        model.addAttribute("rownum", rownum);
        model.addAttribute("mypage", mypage);
        model.addAttribute("pop", pop);

        model.addAttribute("likeNum", likeNum.getLikeNum(rownum));
        model.addAttribute("checkLike", checkLikeDB.getDB(nick, rownum));
        Map<String, Object> param = planDetail.execute(rownum, mypage, pop);

        model.addAttribute("list", param.get("list"));
        model.addAttribute("totalTripDay", param.get("totalTripDay"));
        model.addAttribute("seqNumber", param.get("seqNumber"));

        return "PlanDetail";
    }
}
