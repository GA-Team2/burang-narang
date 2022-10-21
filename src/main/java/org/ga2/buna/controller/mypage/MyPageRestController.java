package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.mypage.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MyPageRestController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;
    private final DeleteMemberInfo deleteMemberInfo;
    private final DeletePlanInfo deletePlanInfo;
    private final EditMemberInfo editMemberInfo;


    //비밀번호 일치 체크
    @PostMapping("/checkpw")
//    public Map<String, Integer> checkpw(@RequestParam String memberPw, HttpSession session, Model model) throws UnsupportedEncodingException {
    public int checkpw(@RequestParam String memberPw, HttpSession session, Model model) throws UnsupportedEncodingException {

        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        model.addAttribute("memberPw", memberPw);

        return deleteMemberInfo.checkpw(model);
    }

/*
    //수정폼 전송
    @PostMapping("/editmemberinfo")
    public String editMemberInfo(HttpServletRequest request, HttpSession session, Model model) throws Exception {

        model.addAttribute("request", request);
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);
        editMemberInfo.updateMember(model);

        return "redirect:/mypage";
    }
*/

}
