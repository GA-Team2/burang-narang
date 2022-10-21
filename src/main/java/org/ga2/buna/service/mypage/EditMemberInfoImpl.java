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

        System.out.println("@@@@@@@@@@@@@서비스 호출 ");
        //세션 닉네임 값 받아오기
        String nick = (String) model.getAttribute("nick");
        //수정폼에서 받은 정보
        Map<String, Object> param = model.asMap();
        HttpServletRequest request = (HttpServletRequest) param.get("request");

        String pw = request.getParameter("memberPassword");
        String birthyear = request.getParameter("memberBirthyear");
        String gender = request.getParameter("memberGender");
        System.out.println("gender = " + gender);
        System.out.println("birthyear = " + birthyear);

        String db_pw = memberDAO.getMember(nick).getMemberPassword();

        MemberDTO dto = new MemberDTO();

        //입력받은 값 세팅
        dto.setMemberBirthyear(Integer.parseInt(birthyear));
        dto.setMemberGender(Integer.parseInt(gender));
        //비밀번호 미입력한 경우에도 정보 수정 가능하게
        if (!pw.equals("")) {
            dto.setMemberPassword(pw);
        } else {
            dto.setMemberPassword(db_pw);
        }

        memberDAO.updateMember(dto, nick);
    }
}
