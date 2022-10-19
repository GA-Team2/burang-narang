package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class EditMemberInfoImpl implements EditMemberInfo {

    private final MemberDAO memberDAO;

    @Override
    public void updateMember(Model model) {

        //세션 닉네임 값 받아오기
        String nick = (String) model.getAttribute("nick");
        //수정폼에서 받은 정보
        Map<String, Object> param = model.asMap();
        HttpServletRequest request = (HttpServletRequest) param.get("request");

        String pw = request.getParameter("memberPassword");
        String birthyear = request.getParameter("memberBirthyear");
        String gender = request.getParameter("memberGender");

        String db_pw = memberDAO.getMember(nick).getMemberPassword();

        MemberDTO dto = new MemberDTO();

        if (!pw.equals("")) {
            dto.setMemberPassword(pw);
        } else {
            dto.setMemberPassword(db_pw);
        }

        dto.setMemberBirthyear(Integer.parseInt(birthyear));
        dto.setMemberGender(Integer.parseInt(gender));

        memberDAO.updateMember(dto, nick);

    }
}
