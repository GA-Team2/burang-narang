package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EditMemberInfoImpl implements EditMemberInfo {

    private final MemberDAO memberDAO;

    @Override
    public void updateMember(MemberDTO memberDTO, String nick) {
        //기존에 저장된 정보의 비밀번호 불러오기 위해 getMember() 호출
        String db_pw = memberDAO.getMember(nick).getMemberPassword();

        //정보 수정 시 비밀번호 입력하지 않았을 때 기존의 비밀번호 그대로 저장
        if (memberDTO.getMemberPassword().equals("")) {
            memberDTO.setMemberPassword(db_pw);
        }

        memberDAO.updateMember(memberDTO, nick);
    }
}
