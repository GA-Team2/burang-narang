package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteMemberInfoImpl implements DeleteMemberInfo {

    private final MemberDAO memberDAO;

    @Override
    public void deleteMember(Model model, HttpSession session) {

        //세션 닉네임 값 받아오기
        String nick = (String) model.getAttribute("nick");
        memberDAO.deleteMember(nick);
        session.invalidate();

    }

    @Override
    public Integer checkpw(Model model) {

        int re = 0;
        String input_pw = String.valueOf(model.getAttribute("memberPw"));
        log.info("입력받은 비밀번호 => {}", input_pw);
        //세션 닉네임 값 받아오기
        String nick = (String) model.getAttribute("nick");
        //db에 저장된 비밀번호 받아오기
        String db_pw = memberDAO.getPw(nick);

        if (db_pw.equals(input_pw)) {
            re = 1; //탈퇴처리로 넘기기
        } else {
            re = 0; //비밀번호 불일치
        }

        return re;
    }
}
