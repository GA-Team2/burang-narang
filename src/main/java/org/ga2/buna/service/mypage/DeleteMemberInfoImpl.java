package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.MemberDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteMemberInfoImpl implements DeleteMemberInfo {

    private final MemberDAO memberDAO;

    @Override
    public void deleteMember(Model model) {

        //세션 닉네임 값 받아오기
        String nick = (String) model.getAttribute("nick");
        //db에 저장된 비밀번호 받아오기
        String dbPw = memberDAO.getPw(nick);

        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        String pw = request.getParameter("memberPassword");

        if (dbPw.equals(pw)) {
            int re = memberDAO.deleteMember(nick);
        } else {
            log.info("비밀번호 불일치");
        }


    }
}
