package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.springframework.stereotype.Service;

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
}
