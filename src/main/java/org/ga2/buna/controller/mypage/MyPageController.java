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
public class MyPageController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;
    private final DeleteMemberInfo deleteMemberInfo;
    private final DeletePlanInfo deletePlanInfo;
    private final EditMemberInfo editMemberInfo;

    //    @RequestMapping("/myPage/{nick}")
//    public String myPage(@PathVariable String nick, Model model) throws Exception {
//    @RequestMapping("/myPage")
    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) throws Exception {
//    @RequestMapping("myPage")
//    public String myPage(@RequestParam String nick, Model model) throws Exception {

//        HttpSession httpsession = request.getSession(); //이렇게 쓰는구만,,

        session.setAttribute("nickname", "강아지");
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        model.addAttribute("infolist", myPagePlan.list(model));
        model.addAttribute("member", memberInfo.list(model));

        return "MyPage";
    }
/*

    //수정폼 전송
    @PostMapping("/editmemberinfo")
    public String editMemberInfo(@RequestBody HttpServletRequest request, HttpSession session, Model model) throws Exception {

        model.addAttribute("request", request);
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        editMemberInfo.updateMember(model);

        return "redirect:/mypage";
    }
*/


    //탈퇴 페이지 이동
    @RequestMapping("/signOut")
    public String SignOut() {

        return "SignOut";
    }

    //탈퇴 처리
    @RequestMapping("/deleteMember")
    public String deleteMember(HttpSession session, Model model) throws Exception {

        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);

        deleteMemberInfo.deleteMember(model, session);

        return "redirect:/";
    }

    //플랜 삭제
    @PostMapping(value = "/deletePlan")
    public String deletePlan(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

        String rownum = request.getParameter("rownum");
        model.addAttribute("rownum", rownum);
        HttpSession session = request.getSession();
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;

        deletePlanInfo.deletePlan(model);

        return "redirect:/mypage";
    }


}
