package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.mypage.MemberInfo;
import org.ga2.buna.service.mypage.MyPagePlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 멤버 정보 관리를 위한 컨트롤러
 * @author 장희정
 */
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;

//    @RequestMapping("/myPage/{nick}")
//    public String myPage(@PathVariable String nick, Model model) throws Exception {
//    @RequestMapping("/myPage")
    @GetMapping("/myPage")
    public String myPage(HttpSession session, Model model) throws Exception {
//    @RequestMapping("myPage")
//    public String myPage(@RequestParam String nick, Model model) throws Exception {

        session.setAttribute("nickname", "미어캣");
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        model.addAttribute("infolist", myPagePlan.list(model));
        model.addAttribute("member", memberInfo.list(model));

        return "MyPage";
    }

    //수정폼 전송
    @PostMapping("/editMemberInfo")
    public String editMemberInfo(HttpServletRequest request, HttpSession session, Model model) throws Exception { //URLDecoder.decode() exception처리,,,

        model.addAttribute("request", request);
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);

        return "redirect:/myPage";
    }


    //탈퇴 페이지 이동
    @RequestMapping("/signOut")
    public String SignOut() {

        return "SignOut";
    }

    /*
    //탈퇴 처리
    @RequestMapping("/deleteMember")
    public String delete() {

        return "MyPage";
    }
*/
}
