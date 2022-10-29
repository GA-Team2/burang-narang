package org.ga2.buna.dao.signup;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.memberinfo.MemberDTO;

import java.util.List;

@Mapper
public interface SignUpMapper {

    @Insert("insert into MEMBERINFO values(#{memberNickname},#{memberPassword},#{memberBirthyear},#{memberGender},now())")
    void insertMember(MemberDTO memberDTO);

    @Select("select m_nickname as member_nickname from MEMBERINFO where m_nickname = #{nick}")
    List<MemberDTO> list(String nick);
}
