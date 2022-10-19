package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class MemberInfoList implements MemberInfo {

    private final MemberDAO memberDAO;

    @Override
    public MemberDTO list(Model model) {
        String nick = (String) model.getAttribute("nick");
//        String nick = String.valueOf(model.getAttribute("nick"));
        MemberDTO dto = memberDAO.getMember(nick);

        return dto;
    }
}
