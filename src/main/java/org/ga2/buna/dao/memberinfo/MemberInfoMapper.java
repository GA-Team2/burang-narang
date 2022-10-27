package org.ga2.buna.dao.memberinfo;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ga2.buna.dto.memberinfo.MemberDTO;

@Mapper
public interface MemberInfoMapper {

    @Select("SELECT M_NICKNAME as member_nickname, M_PASSWORD as member_password, "
          + "       M_BIRTHYEAR as member_birthyear, M_GENDER as member_gender "
          + " FROM MEMBERINFO WHERE M_NICKNAME = #{memberNickname}")
    MemberDTO getMember(String memberNickname);


    @Select("SELECT M_PASSWORD FROM MEMBERINFO WHERE M_NICKNAME = #{memberNickName}")
    String getPw(String memberNickName);


    @Delete("DELETE FROM MEMBERINFO WHERE M_NICKNAME = #{memberNickname}")
    int deleteMember(String nickname);
}
