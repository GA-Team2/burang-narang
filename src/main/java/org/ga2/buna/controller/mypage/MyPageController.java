package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.mypage.*;
import org.springframework.http.HttpStatus;
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
import java.util.HashMap;
import java.util.Map;

/**
 * 마이페이지 관련 컨트롤러
 *
 * @author 장희정
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;
    private final DeleteMemberInfo deleteMemberInfo;
    private final DeletePlanInfo deletePlanInfo;
    private final SharePlan sharePlan;


    //마이페이지 나의 플랜 목록 출력 및 회원정보수정 출력
    @GetMapping()
    public String myPage(HttpSession session, Model model, Map<String, Object> map) throws Exception {

        String nick = (String) session.getAttribute("nick_s");

        model.addAttribute("firstDate", map.get("firstDate"));
        model.addAttribute("lastDate", map.get("lastDate"));
        model.addAttribute("member", memberInfo.list(nick));
        model.addAttribute("infolist", myPagePlan.list(map, nick));
        return "MyPage";
    }

    //탈퇴 페이지 이동
    @RequestMapping("/signOut")
    public String SignOut() {
        return "SignOut";
    }

    //탈퇴 처리
    @RequestMapping("/deletem")
    public String deleteMember(HttpSession session) throws Exception {
        String nick = (String) session.getAttribute("nick_s");
        deleteMemberInfo.deleteMember(nick);
        session.invalidate();
        return "redirect:/";
    }

    //플랜 삭제
    @RequestMapping("/deletep")
    public String deletePlan(int rownum) throws UnsupportedEncodingException {
        deletePlanInfo.deletePlan(rownum);
        return "redirect:/mypage";
    }

    //플랜 공개 비공개 전환
    @RequestMapping("/share")
    public String shareplan(HttpServletRequest request, Model model) {

        int rownum = Integer.parseInt(request.getParameter("rownum"));
        int publicCheck = Integer.parseInt(request.getParameter("shared"));
        sharePlan.publicUpdate(rownum, publicCheck);

        return "redirect:/mypage";
    }

}
