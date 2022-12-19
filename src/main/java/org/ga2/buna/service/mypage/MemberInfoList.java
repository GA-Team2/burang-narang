package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;

/**
 * 회원 정보 조회를 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberInfoList implements MemberInfo {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public MemberDTO list(String nick) {
        return memberInfoRepository.getMember(nick);
    }
}
