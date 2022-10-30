package org.ga2.buna.dao.like;

import org.apache.ibatis.annotations.*;
import org.ga2.buna.dto.memberinfo.MemberDTO;

@Mapper
public interface LikeMapper {

    @Select("SELECT count(*) FROM likeinfo WHERE P_ROWNUM = #{planRownum} AND M_NICKNAME = #{memberNickname}")
    int checkLike(@Param("planRownum") int planRownum, @Param("memberNickname") String memberNickname);

    @Update("UPDATE planinfo SET P_LIKE = P_LIKE + #{n} WHERE P_ROWNUM = #{planRownum}")
    void updateLike(@Param("planRownum") int planRownum, @Param("n") int n);

    @Insert("INSERT INTO likeinfo VALUES (#{member.memberNickname}, #{planRownum}, #{age}, #{member.memberGender})")
    int insertLike(@Param("member") MemberDTO member, @Param("planRownum") int planRownum, @Param("age") int age);

    @Delete("DELETE FROM likeinfo WHERE P_ROWNUM = #{planRownum} AND M_NICKNAME = #{memberNickname}")
    int deleteLikeInfo(@Param("planRownum") int planRownum, @Param("memberNickname") String memberNickname);

    @Select("SELECT P_LIKE FROM planinfo WHERE P_ROWNUM = #{planRownum}")
    int getLikeNum(int planRownum);
}
