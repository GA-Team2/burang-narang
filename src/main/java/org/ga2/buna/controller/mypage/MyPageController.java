package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.mypage.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 마이페이지 컨트롤러
 * @author 장희정
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;
    private final DeleteMemberInfo deleteMemberInfo;


    //마이페이지 나의 플랜 목록 출력
    @RequestMapping
    public String myPage(HttpSession session, Model model, Map<String, Object> map) {

        String nick = (String) session.getAttribute("nick_s");

        model.addAttribute("firstDate", map.get("firstDate"));
        model.addAttribute("lastDate", map.get("lastDate"));
        model.addAttribute("infolist", myPagePlan.list(map, nick));
        return "MyPage";
    }

    //마이페이지 회원 수정폼에 출력할 회원정보 조회
    @RequestMapping("/info")
    public String info(HttpSession session, Model model) {
        String nick = (String) session.getAttribute("nick_s");
        model.addAttribute("member", memberInfo.list(nick));
        return "MyPageMember";
    }

    //탈퇴 페이지 이동
    @RequestMapping("/signout")
    public String SignOut() {
        return "SignOut";
    }

    //탈퇴 처리
    @RequestMapping("/deletem")
    public String deleteMember(HttpSession session) {
        String nick = (String) session.getAttribute("nick_s");
        deleteMemberInfo.deleteMember(nick);
        log.info("{}님이 탈퇴하셨습니다.", nick);
        //탈퇴 후 세션 무효화
        session.invalidate();
        return "redirect:/";
    }
}
