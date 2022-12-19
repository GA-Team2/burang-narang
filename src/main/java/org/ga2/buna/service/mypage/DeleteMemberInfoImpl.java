package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.springframework.stereotype.Service;

/**
 * 회원 탈퇴를 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteMemberInfoImpl implements DeleteMemberInfo {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public void deleteMember(String nick) {
        memberInfoRepository.deleteMember(nick);
    }
}
