package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteMemberInfoImpl implements DeleteMemberInfo {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public void deleteMember(String nick) {
        //세션 닉네임 값 받아오기
        memberInfoRepository.deleteMember(nick);
    }
}
