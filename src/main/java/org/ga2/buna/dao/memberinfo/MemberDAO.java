package org.ga2.buna.dao.memberinfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 멤버 db관리를 위한 클래스
 * 
 * @author 장희정
 */
@Slf4j
@Repository
public class MemberDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 회원 정보 얻어오는 메서드
	 *
	 * @param nickname : 세션에 저장된 닉네임값
	 * @return 닉네임을 조건으로 조회한 회원 정보를 담는 MemberDTO 객체
	 */
	public MemberDTO getMember(String nickname) {

		String sql = "SELECT M_NICKNAME, M_PASSWORD, "
		   		   + "       M_BIRTHYEAR, M_GENDER, M_JOINDATE"
				   + "  FROM MEMBERINFO"
				   + " WHERE M_NICKNAME=?";

		MemberDTO member = new MemberDTO();

		jdbcTemplate.query(sql, (rs, rowNum) -> {
			member.setMemberNickname(rs.getString(1));
			member.setMemberPassword(rs.getString(2));
			member.setMemberBirthyear(rs.getInt(3));
			member.setMemberGender(rs.getInt(4));
			member.setMemberJoindate(rs.getTimestamp(5));
			return member;
		}, nickname);

		return member;
	}

	/**
	 * 회원 정보 업데이트 메서드
	 * 
	 * @param : 수정폼으로 받은 정보 저장한 member객체
	 * @param : 세션에 저장된 닉네임 값
	 * @return re==1 업데이트 성공
	 */


	public void updateMember(MemberDTO member, String nickname) {

		String sql = "UPDATE MEMBERINFO"
				   + "   SET M_PASSWORD=?, M_BIRTHYEAR=?, M_GENDER=?"
				   + " WHERE M_NICKNAME=?";

		int re = jdbcTemplate.update(sql, ps -> {
			ps.setString(1, member.getMemberPassword());
			ps.setInt(2, member.getMemberBirthyear());
			ps.setInt(3, member.getMemberGender());
			ps.setString(4, nickname);
		});

		log.info("정보 수정 건수 = {}", re);
	}

	/**
	 * 비밀번호 조회 메서드
	 * @param nickname 닉네임
	 * @return 닉네임을 조건으로 조회한 비밀번호
	 */
	public String getPw(String nickname) {

		String sql = "SELECT M_PASSWORD FROM MEMBERINFO WHERE M_NICKNAME = ?";

		String db_pw = jdbcTemplate.queryForObject(sql, String.class, nickname);
		log.info("db에 저장된 비밀번호 = {}", db_pw);

		return db_pw;
	}



	/**
	 * 회원 정보 삭제 메서드
	 * 
	 * @param nickname : 로그인 했을 때 저장 된 닉네임값
	 * @return re==1 회원정보 삭제 성공 / re==0 비밀번호 불일치
	 */
	public int deleteMember(String nickname) {

		String sql = "DELETE FROM MEMBERINFO WHERE M_NICKNAME = ?";

		int re = jdbcTemplate.update(sql, ps -> ps.setString(1, nickname));

		log.debug("삭제 된 회원정보 수 = {}", re);

		return re;
	}


}
