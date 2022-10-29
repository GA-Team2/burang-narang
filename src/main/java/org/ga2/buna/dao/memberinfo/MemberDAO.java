package org.ga2.buna.dao.memberinfo;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 멤버 db관리를 위한 클래스
 *
 * @author 장희정
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDAO {

//    private JdbcTemplate jdbcTemplate;
    private final MemberInfoMapper memberInfoMapper;

/*
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
*/

    /**
     * 회원 정보 얻어오는 메서드
     *
     * @param nickname : 세션에 저장된 닉네임값
     * @return 닉네임을 조건으로 조회한 회원 정보를 담는 MemberDTO 객체
     */
    public MemberDTO getMember(String nickname) {
        return memberInfoMapper.getMember(nickname);
    }

    /**
     * 회원 정보 업데이트 메서드
     *
     * @param : 수정폼으로 받은 정보 저장한 member객체
     * @param : 세션에 저장된 닉네임 값
     * @return re==1 업데이트 성공
     */


    public void updateMember(MemberDTO member, String nickname) {
        memberInfoMapper.updateMember(member, nickname);
    }

    /**
     * 비밀번호 조회 메서드
     *
     * @param nickname 닉네임
     * @return 닉네임을 조건으로 조회한 비밀번호
     */
    public String getPw(String nickname) {
        return memberInfoMapper.getPw(nickname);
    }


    /**
     * 회원 정보 삭제 메서드
     *
     * @param nickname : 로그인 했을 때 저장 된 닉네임값
     * @return re==1 회원정보 삭제 성공 / re==0 비밀번호 불일치
     */
    public int deleteMember(String nickname) {
        return memberInfoMapper.deleteMember(nickname);
    }
}
