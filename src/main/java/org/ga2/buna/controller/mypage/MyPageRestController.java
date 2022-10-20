package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.mypage.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;

@RestController
@RequiredArgsConstructor
public class MyPageRestController {

    private final MyPagePlan myPagePlan;
    private final MemberInfo memberInfo;
    private final DeleteMemberInfo deleteMemberInfo;
    private final DeletePlanInfo deletePlanInfo;
    private final EditMemberInfo editMemberInfo;

/*

    //탈퇴 처리
    @PostMapping(value = "/deleteMember")
    public String deleteMember(HttpServletRequest request, HttpSession session, Model model) throws Exception {

        model.addAttribute("request", request);
        String nickSession = (String) session.getAttribute("nickname");
        String nick = nickSession != null ? URLDecoder.decode(nickSession, "UTF-8") : null;
        model.addAttribute("nick", nick);

        deleteMemberInfo.deleteMember(model);
        session.invalidate();

        return "redirect:/";
    }
*/

}
