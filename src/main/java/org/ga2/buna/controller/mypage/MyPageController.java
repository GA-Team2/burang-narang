package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.mypage.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 마이페이지 관련 컨트롤러
 * @author 장희정
 */
//@Controller
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;
    private final DeleteMemberInfo deleteMemberInfo;
    private final DeletePlanInfo deletePlanInfo;

    @GetMapping()
    public String myPage(HttpSession session, Model model) throws Exception {

        model.addAttribute("infolist", myPagePlan.list(model, session));
        model.addAttribute("member", memberInfo.list(model, session));

        return "MyPage";
    }

    //탈퇴 페이지 이동
    @RequestMapping("/signOut")
    public String SignOut() {
        return "SignOut";
    }

    //탈퇴 처리
    @RequestMapping("/deleteMember")
    public String deleteMember(HttpSession session, Model model) throws Exception {

        String nick = (String) session.getAttribute("nick_s");
        model.addAttribute("nick", nick);

        deleteMemberInfo.deleteMember(model, session);

        return "redirect:/";
    }

    //플랜 삭제
    @RequestMapping("/deletePlan")
    public String deletePlan(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        String rownum = request.getParameter("rownum");
        model.addAttribute("rownum", rownum);
        HttpSession session = request.getSession();
        String nick = (String) session.getAttribute("nick_s");

        deletePlanInfo.deletePlan(model);

        return "redirect:/mypage";
    }


}
