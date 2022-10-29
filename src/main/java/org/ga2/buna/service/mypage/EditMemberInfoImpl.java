package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EditMemberInfoImpl implements EditMemberInfo {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public void updateMember(MemberDTO memberDTO, String nick) {
        log.info("ddd");
        memberInfoRepository.updateMember(memberDTO, nick);
    }
}
