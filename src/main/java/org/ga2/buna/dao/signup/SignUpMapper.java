package org.ga2.buna.dao.signup;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.memberinfo.MemberDTO;

import java.util.List;

/**
 * 회원가입 및 닉네임 중복검사 mapper 클래스
 * @author 한병태
 */
@Mapper
public interface SignUpMapper {

    /**
     * 회원정보 추가 쿼리메소드
     * @param memberDTO 회원정보 DTO
     */
    @Insert("insert into memberinfo values(#{memberNickname},#{memberPassword},#{memberBirthyear},#{memberGender},now())")
    void insertMember(MemberDTO memberDTO);

    /**
     * 닉네임 중복검사 쿼리메소드
     * @param nick 요청한 닉네임
     */
    @Select("select m_nickname as member_nickname from memberinfo where m_nickname = #{nick}")
    List<MemberDTO> list(String nick);
}
