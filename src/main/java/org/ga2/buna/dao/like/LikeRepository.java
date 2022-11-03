package org.ga2.buna.dao.like;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Repository;

/**
 * 추천 관리를 위한 클래스
 *
 * @author 장희정
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class LikeRepository {
    private final LikeMapper likeMapper;

    /**
     * 닉네임, 플랜 번호를 조건으로 likeinfo 테이블 조회 -> 추천 여부 체크
     *
     * @param rownum: 플랜 번호
     * @param nick:   닉네임
     * @return 조회결과 -> 1이면 추천함, 0이면 추천 안함
     */
    public int checkLike(int rownum, String nick) {
        return likeMapper.checkLike(rownum, nick);
    }

    ;


    /**
     * planinfo 테이블의 추천수 컬럼 업데이트
     *
     * @param rownum : 플랜번호
     * @param n : 추천 했을 때 n=1, 추천 취소시 n=-1
     */
    public void updateLike(int rownum, int n) {
        likeMapper.updateLike(rownum, n);
    }


    /**
     * 추천 클릭시 likeinfo 테이블에 닉네임+플랜 넘버를 추가
     *
     * @param member : 추천한 회원 닉네임
     * @param rownum : 플랜넘버
     * @param age    : 10대 = 1, 20대 = 2, ...
     */
    public int insertLike(MemberDTO member, int rownum, int age) {
        return likeMapper.insertLike(member, rownum, age);
    }


    /**
     * 추천 취소 시 likeinfo 테이블에서 행 삭제하는 메서드
     *
     * @param rownum:   플랜 번호
     * @param nickname: 추천 취소한 회원 닉네임
     */
    public int deleteLikeInfo(int rownum, String nickname) {
        return likeMapper.deleteLikeInfo(rownum, nickname);
    }


    /**
     * 플랜번호를 조건으로 추천 건수 조회하는 메서드
     *
     * @param rownum: 플랜 번호
     * @return planinfo의 추천수 컬럼 데이터 값 반환
     */
    public int getLikeNum(int rownum) {
        return likeMapper.getLikeNum(rownum);
    }

}