package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.MyPagePlan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 멤버 정보 관리를 위한 컨트롤러
 * @author 장희정
 */
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final MyPagePlan myPagePlan;


    @RequestMapping("/myPage")
//    public String myPage(HttpSession session, Model model) throws Exception {
    public String myPage(@RequestParam("nick") String nick, Model model) throws Exception {

//        String nick = (String) session.getAttribute("nick");
        model.addAttribute("nick", nick);
        System.out.println("nick = @@@@@@@ " + nick);
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
