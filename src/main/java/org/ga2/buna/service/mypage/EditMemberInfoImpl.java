package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class EditMemberInfoImpl implements EditMemberInfo {

    private final MemberDAO memberDAO;

    @Override
    public void updateMember(MemberDTO memberDTO, HttpSession session) {

        //세션 닉네임 값 받아오기
        String nick = (String) session.getAttribute("nick_s");

        //기존에 저장된 정보의 비밀번호 불러오기 위해 getMember() 호출
        String db_pw = memberDAO.getMember(nick).getMemberPassword();

        //정보 수정 시 비밀번호 입력하지 않았을 때 기존의 비밀번호 그대로 저장
        if (memberDTO.getMemberPassword().equals("")) {
            memberDTO.setMemberPassword(db_pw);
        }

//        HttpServletRequest request = (HttpServletRequest) param.get("request");
//
//        String pw = request.getParameter("memberPassword");
//        String birthyear = request.getParameter("memberBirthyear");
//        String gender = request.getParameter("memberGender");
//        log.info("gender = " + gender);
//        log.info("birthyear = " + birthyear);
//
//        String db_pw = memberDAO.getMember(nick).getMemberPassword();
//
//        MemberDTO dto = new MemberDTO();
//
//        //입력받은 값 세팅
//        dto.setMemberBirthyear(Integer.parseInt(birthyear));
//        dto.setMemberGender(Integer.parseInt(gender));
//        //비밀번호 미입력한 경우에도 정보 수정 가능하게
//        if (!pw.equals("")) {
//            dto.setMemberPassword(pw);
//        } else {
//            dto.setMemberPassword(db_pw);
//        }

        memberDAO.updateMember(memberDTO, nick);
    }
}
