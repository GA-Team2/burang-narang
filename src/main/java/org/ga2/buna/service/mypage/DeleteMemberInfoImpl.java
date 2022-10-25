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
    public void deleteMember(String nick) {
        //세션 닉네임 값 받아오기
        memberDAO.deleteMember(nick);
    }

//    @Override
//    public int checkpw(Map<String, Object> map) {
//
//        int re = 0;
//        String input_pw = (String) map.get("memberPw");
//        log.debug("입력받은 비밀번호 => {}", input_pw);
//        String nick = (String) map.get("nick");
//        String db_pw = memberDAO.getPw(nick);
//
//        if (db_pw.equals(input_pw)) {
//            //탈퇴 처리로 넘기기
//            re = 1;
//        } else {
//            //비밀번호 불일치
//            re = 0;
//        }
//
//        return re;
//    }
}
