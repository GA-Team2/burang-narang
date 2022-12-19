package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.like.LikeRepository;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 추천 정보 업데이트를 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LikeImpl implements Like {

    private final LikeRepository likeRepository;
    private final MemberInfoRepository memberInfoRepository;

    @Override
    public Map<String, Object> likeInsert(String nick, int rownum) {

        log.debug("ajax에서 받아온 rownum값 => {}", rownum);
        log.debug("세션에 저장된 nick값 => ", nick);
        MemberDTO member = memberInfoRepository.getMember(nick);
        log.debug("멤버 성별 정보 가져오기 => {}", member.getMemberGender());

        //추천 여부 확인하는 메서드 호출
        int checkResult = likeRepository.checkLike(rownum, nick);
        log.debug("LikeImple checkLike() 조회 => {}", checkResult);

        //추천할 경우 컬럼에 추가될 세대(20대=2,30대=3,...)를 변수 age에 저장
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int age = (year - member.getMemberBirthyear()) / 10;

        //planinfo 테이블의 p_like 컬럼에 추가할 변수 n 지정
        int n = 0;
        //checkResult가 1이면 이미 추천했으므로 deleteLike 메서드 실행
        //0이면 추천하지 않은 상태이므로 insertLike 메서드 실행
        //추천수가 0 이상일때만 좋아요 취소 가능하도록 하기 위한 조건 추가
        if (checkResult == 1 && likeRepository.getLikeNum(rownum) > 0) {
            likeRepository.deleteLikeInfo(rownum, nick);
            n = -1;
        } else if (checkResult == 0) {
            likeRepository.insertLike(member, rownum, age);
            n = 1;
        }

        //planinfo의 p_like 컬럼 업데이트
        log.debug("likeImpl => {}", n);
        likeRepository.updateLike(rownum, n);

        //planinfo의 p_like 컬럼 값 얻어오기
        int likeNum = likeRepository.getLikeNum(rownum);
        log.debug("LikeImpl의 최종 조회 likeNum => {}", likeNum);

        Map<String, Object> map = new HashMap<>();
        map.put("likeNumber", likeNum);
        map.put("checkResult", checkResult);

        return map;
    }
}
