package org.ga2.buna.dao.signup;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;


/**
 * 회원가입 및 로그인 기능을 위한 클래스
 *
 * @author 한병태
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class SignUpDAO {

    private final SignUpMapper signUpMapper;

    /**
     * 회원 추가 메소드(매개변수로 필드 객체 선언)
     *
     * @param memberDTO 유저의 정보가 저장되어있는 SignUpBean객체
     */
    public void insertMember(MemberDTO memberDTO) {
        signUpMapper.insertMember(memberDTO);
    }

    /**
     * 중복체크를 위한 메소드(매개변수 nick)
     *
     * @param nick 유저가 입력한 닉네임
     */
    public List<MemberDTO> confirmID(String nick) {
        return signUpMapper.list(nick);
    }
}
