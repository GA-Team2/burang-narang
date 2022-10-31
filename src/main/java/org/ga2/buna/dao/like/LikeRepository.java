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
     * @return re:조회결과 -> re==1 좋아요O, re==0 좋아요X
     */

    public int checkLike(int rownum, String nick) {
        return likeMapper.checkLike(rownum, nick);
    }

    ;


    /**
     * info 테이블 p_like 컬럼 수 증가
     *
     * @param rownum   : 플랜번호
     * @param likeTrue : 좋아요 했는지 여부
     * @return re==1이면 추천 완료
     */

    public void updateLike(int rownum, int n) {
        likeMapper.updateLike(rownum, n);
    }


    /**
     * 추천 클릭시 likeinfo 테이블에 닉네임+플랜 넘버를 추가
     *
     * @param member : 추천한 멤버 정보 가져오기(세션에 저장된 닉네임)
     * @param rownum : 플랜넘버
     * @param age    : 10대 = 1, 20대 = 2, ...
     * @return re==1이면 좋아요 반영 됨
     */

    public int insertLike(MemberDTO member, int rownum, int age) {
        return likeMapper.insertLike(member, rownum, age);
    }


    /**
     * 추천 취소 시 likeinfo 테이블에서 행 삭제하는 메서드
     *
     * @param rownum:   플랜 번호
     * @param nickname: 세션에 저장된 닉네임
     * @return re==-1 취소 완료
     */


    public int deleteLikeInfo(int rownum, String nickname) {
        return likeMapper.deleteLikeInfo(rownum, nickname);
    }


    /**
     * 플랜번호를 조건으로 추천 건수 조회하는 메서드
     *
     * @param rownum: 플랜 번호
     * @return likeNum: p_like컬럼의 데이터를 int로 반환
     */
    public int getLikeNum(int rownum) {
        return likeMapper.getLikeNum(rownum);
    }

}