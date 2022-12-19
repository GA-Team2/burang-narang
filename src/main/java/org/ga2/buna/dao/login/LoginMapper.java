package org.ga2.buna.dao.login;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.memberinfo.MemberDTO;

import java.util.List;

@Mapper
public interface LoginMapper {

    @Select("select m_nickname as member_nickname, m_password as member_password from memberinfo where m_nickname = #{nick}")
    List<MemberDTO> userCheck(String nick);
}
