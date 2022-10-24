package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.mypage.*;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageRestController {

    private final DeleteMemberInfo deleteMemberInfo;
    private final EditMemberInfo editMemberInfo;
    private final SharePlan sharePlan;


    //비밀번호 일치 체크
    @PostMapping("/checkpw")
    public int checkpw(@RequestBody Map<String, Object> map, HttpSession session, Model model) {

        String memberPw = (String) map.get("memberPw");
        log.info("Controller의 memberPw => {}", memberPw);
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
    @GetMapping("/shareplan")
    @ResponseStatus(HttpStatus.CREATED) //status 201
    public int shareplan(HttpServletRequest request, Model model) {

        int rownum = Integer.parseInt(request.getParameter("rownum"));
        String shared = request.getParameter("shared");
        model.addAttribute("rownum", rownum);
        model.addAttribute("shared", shared);
        sharePlan.execute(model);

        return sharePlan.execute(model);
    }


}
