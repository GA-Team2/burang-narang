package org.ga2.buna.controller.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.mypage.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 마이페이지 Rest 컨트롤러
 * @author 장희정
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageRestController {

    private final EditMemberInfo editMemberInfo;
    private final PasswordCheck passwordCheck;
    private final SharePlan sharePlan;
    private final DeletePlanInfo deletePlanInfo;


    //비밀번호 일치 체크
    @PostMapping("/check")
    @ResponseStatus(HttpStatus.CREATED) //status 201
    public int checkpw(@RequestBody Map<String, Object> map, HttpSession session) {

        String nick = (String) session.getAttribute("nick_s");
        map.put("nick", nick);

        return passwordCheck.checkpw(map);
    }

    //회원정보수정 시 폼값 전송받아서 업데이트
    @PostMapping("/edit")
    @ResponseStatus(HttpStatus.CREATED) //status 201
    public String editMemberInfo(@RequestBody MemberDTO memberDTO, HttpSession session) {

        String nick = (String) session.getAttribute("nick_s");
        editMemberInfo.updateMember(memberDTO, nick);
        log.info("{}님의 회원정보가 수정되었습니다.", nick);

        return "/mypage";
    }

    //플랜 공개 비공개 전환
    @GetMapping("/share")
    public int shareplan(HttpServletRequest request) {

        int rownum = Integer.parseInt(request.getParameter("rownum"));
        int publicCheck = Integer.parseInt(request.getParameter("shared"));
        int re = sharePlan.publicUpdate(rownum, publicCheck);

        return re;
    }

    //플랜 삭제
    @RequestMapping("/deletep")
    public String deletePlan(int rownum) {
        deletePlanInfo.deletePlan(rownum);
        return "delete";
    }
}
