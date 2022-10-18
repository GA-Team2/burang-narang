package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.mypage.MyPagePlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.net.URLDecoder;

/**
 * 멤버 정보 관리를 위한 컨트롤러
 * @author 장희정
 */
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final MyPagePlan myPagePlan;

//    @RequestMapping("/myPage/{nick}")
//    public String myPage(@PathVariable String nick, Model model) throws Exception {
//    @RequestMapping("/myPage")
    @RequestMapping("/myPage")
    public String myPage(HttpSession session, Model model) throws Exception {
//    @RequestMapping("myPage")
//    public String myPage(@RequestParam String nick, Model model) throws Exception {

        session.setAttribute("nickname", "강아지");
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        model.addAttribute("infolist", myPagePlan.list(model));

        return "MyPage";
    }

/*
    //수정폼 전송
    @RequestMapping("/editMemberInfo")
    public String editMemberInfo() {

        return "MyPage";
    }

    //탈퇴 페이지 이동
    @RequestMapping("/signOut")
    public String SignOut() {

        return "SignOut";
    }

    //탈퇴 처리
    @RequestMapping("/deleteMember")
    public String delete() {

        return "MyPage";
    }
*/
}
