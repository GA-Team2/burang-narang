package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.ga2.buna.service.mypage.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;
    private final DeleteMemberInfo deleteMemberInfo;
    private final DeletePlanInfo deletePlanInfo;
    private final EditMemberInfo editMemberInfo;
    private final SharePlan sharePlan;

    //    @RequestMapping("/myPage/{nick}")
//    public String myPage(@PathVariable String nick, Model model) throws Exception {
//    @RequestMapping("/myPage")
    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) throws Exception {
//    @RequestMapping("myPage")
//    public String myPage(@RequestParam String nick, Model model) throws Exception {

//        HttpSession httpsession = request.getSession(); //이렇게 쓰는구만,,

        session.setAttribute("nickname", "고슴도치");
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        model.addAttribute("infolist", myPagePlan.list(model));
        model.addAttribute("member", memberInfo.list(model));

        return "MyPage";
    }

    //수정폼 전송
    @PostMapping("/editmemberinfo")
    public String editMemberInfo(HttpServletRequest request, HttpSession session, Model model) throws Exception { //URLDecoder.decode() exception처리,,,

        model.addAttribute("request", request);
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        editMemberInfo.updateMember(model);

        return "redirect:/mypage";
    }


    //탈퇴 페이지 이동
    @RequestMapping("/signOut")
    public String SignOut() {

        return "SignOut";
    }


    //탈퇴 처리
    @PostMapping("/deleteMember")
    public String deleteMember(HttpServletRequest request, HttpSession session, Model model) throws Exception {

        model.addAttribute("request", request);
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);

        deleteMemberInfo.deleteMember(model);
        session.invalidate();

        return "redirect:/";
    }

    //플랜 삭제
    @RequestMapping("/deletepPlan")
    public String deletePlan(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        String p_rownum = request.getParameter("rownum");
        model.addAttribute("rownum", p_rownum);
        HttpSession session = request.getSession();
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;

        deletePlanInfo.deletePlan(model);

        return "redirect:/mypage";
    }

    @RequestMapping("/plandetail")
    public String plandetail(HttpServletRequest request, Model model) {

        String p_rownum = request.getParameter("rownum");
        model.addAttribute("rownum", p_rownum);

        return "/PlanDetail";
    }

    @RequestMapping("/shareplan")
    public String shareplan(HttpServletRequest request, Model model) {

        String p_rownum = request.getParameter("rownum");
        model.addAttribute("rownum", p_rownum);

        sharePlan.execute(model);

        return "redirect:/mypage";
    }

}
