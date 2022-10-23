package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberInfoList implements MemberInfo {

    private final MemberDAO memberDAO;

    @Override
    public MemberDTO list(Model model, HttpSession session) {

        String nick = (String) session.getAttribute("nick_s");
        MemberDTO dto = memberDAO.getMember(nick);

        log.info(dto.toString());
        return dto;
    }
}
