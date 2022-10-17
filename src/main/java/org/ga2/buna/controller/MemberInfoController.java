package org.ga2.buna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 멤버 정보 관리를 위한 컨트롤러
 * @author 장희정
 */
@Controller
public class MemberInfoController {

    //수정폼 전송
    @RequestMapping("editMemberInfo")
    public String editMemberInfo() {

        return "MyPage";
    }

    //탈퇴 페이지 이동
    @RequestMapping("signOut")
    public String SignOut() {

        return "SignOut";
    }

    //탈퇴 처리
    @RequestMapping("deleteMember")
    public String delete() {

        return "MyPage";
    }
}
