package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.mypage.*;
import org.springframework.http.HttpStatus;
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

    private final DeleteMemberInfo deleteMemberInfo;
    private final EditMemberInfo editMemberInfo;
    private final SharePlan sharePlan;


    //비밀번호 일치 체크
    @GetMapping("/checkpw")
    public int checkpw(@RequestParam String memberPw, HttpSession session, Model model) {

        String nick = (String) session.getAttribute("nick_s");
        model.addAttribute("nick", nick);
        model.addAttribute("memberPw", memberPw);

        return deleteMemberInfo.checkpw(model);
    }

    //수정폼 전송
    @PostMapping(value = "/editmemberinfo")
    @ResponseStatus(HttpStatus.CREATED) //status 201
    public String editMemberInfo(@RequestBody MemberDTO memberDTO, HttpSession session) throws Exception {

        String nickname = (String) session.getAttribute("nick_s");
        editMemberInfo.updateMember(memberDTO, session);

        return "/mypage";
    }

    //플랜 공개 비공개 전환
    @PostMapping("/shareplan")
    @ResponseStatus(HttpStatus.CREATED) //status 201
    public String shareplan(HttpServletRequest request, Model model) {

        int rownum = Integer.parseInt(request.getParameter("rownum"));
        String shared = request.getParameter("shared");
        model.addAttribute("rownum", rownum);
        model.addAttribute("shared", shared);
        shareplan.execute(model);

        return "/";
    }


}
