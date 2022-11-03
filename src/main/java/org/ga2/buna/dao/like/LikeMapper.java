package org.ga2.buna.dao.like;

import org.apache.ibatis.annotations.*;
import org.ga2.buna.dto.memberinfo.MemberDTO;

@Mapper
public interface LikeMapper {

    //nickname과 rownum을 조건으로 likeinfo 테이블 조회해서 추천 여부 확인
    @Select("SELECT count(*) FROM likeinfo WHERE P_ROWNUM = #{planRownum} AND M_NICKNAME = #{memberNickname}")
    int checkLike(@Param("planRownum") int planRownum, @Param("memberNickname") String memberNickname);

    //rownum에 해당하는 planinfo의 추천수 컬럼 업데이트
    @Update("UPDATE planinfo SET P_LIKE = P_LIKE + #{n} WHERE P_ROWNUM = #{planRownum}")
    void updateLike(@Param("planRownum") int planRownum, @Param("n") int n);

    //추천시 likeinfo 테이블에 데이터 추가
    @Insert("INSERT INTO likeinfo VALUES (#{member.memberNickname}, #{planRownum}, #{age}, #{member.memberGender})")
    int insertLike(@Param("member") MemberDTO member, @Param("planRownum") int planRownum, @Param("age") int age);

    //추천 취소시 likeinfo 테이블에서 데이터 삭제
    @Delete("DELETE FROM likeinfo WHERE P_ROWNUM = #{planRownum} AND M_NICKNAME = #{memberNickname}")
    int deleteLikeInfo(@Param("planRownum") int planRownum, @Param("memberNickname") String memberNickname);

    //planinfo 테이블의 추천수 컬럼의 데이터 가져오기
    @Select("SELECT P_LIKE FROM planinfo WHERE P_ROWNUM = #{planRownum}")
    int getLikeNum(int planRownum);
}
