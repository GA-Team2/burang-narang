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


    //비밀번호 일치 체크
    @PostMapping("/checkpw")
    @ResponseStatus(HttpStatus.CREATED) //status 201
    public int checkpw(@RequestBody Map<String, Object> map, HttpSession session) {

        String memberPw = (String) map.get("memberPw");
        log.debug("Controller의 memberPw => {}", memberPw);
        String nick = (String) session.getAttribute("nick_s");
        map.put("nick", nick);

        return deleteMemberInfo.checkpw(map);
    }

    //회원정보수정 시 폼값 전송받아서 업데이트
    @PostMapping(value = "/editmemberinfo")
    @ResponseStatus(HttpStatus.CREATED) //status 201
    public String editMemberInfo(@RequestBody MemberDTO memberDTO, HttpSession session) throws Exception {

        String nick = (String) session.getAttribute("nick_s");
        editMemberInfo.updateMember(memberDTO, nick);

        return "/mypage";
    }

}
