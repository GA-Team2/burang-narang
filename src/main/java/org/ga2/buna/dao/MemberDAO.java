package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	public List<MemberDTO> getMember(String nickname) {

		String sql = "SELECT M_NICKNAME, M_PASSWORD, "
		   		   + "       M_BIRTHYEAR, M_GENDER, M_JOINDATE"
				   + "  FROM MEMBERINFO"
				   + " WHERE M_NICKNAME=?";
		MemberDTO member = new MemberDTO();

		List<MemberDTO> list = jdbcTemplate.query(sql, new RowMapper<MemberDTO>() {
			@Override
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				member.setMemberNickname(rs.getString(1));
				member.setMemberBirthyear(rs.getInt(3));
				member.setMemberGender(rs.getInt(4));
				return member;
			}
		}, nickname);

		return list;
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

		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, member.getMemberPassword());
				ps.setInt(2, member.getMemberBirthyear());
				ps.setInt(3, member.getMemberGender());
				ps.setString(4, nickname);

				log.info("수정 완료");
			}
		});

		log.info("수정 실패");
	}

	/**
	 * 비밀번호 조회 메서드
	 * @param nickname 닉네임
	 * @return 닉네임을 조건으로 조회한 비밀번호
	 */
	public String getPw(String nickname) {

		String sql = "SELECT M_PASSWORD FROM MEMBERINFO WHERE M_NICKNAME = ?";

		String password = jdbcTemplate.queryForObject(sql, String.class, nickname);
		System.out.println("password = " + password);

		return password;
	}



	/**
	 * 회원 정보 삭제 메서드
	 * 
	 * @param nickname : 로그인 했을 때 저장 된 닉네임값
	 * @return re==1 회원정보 삭제 성공 / re==0 비밀번호 불일치
	 */
	public int deleteMember(String nickname) {
		int re = -1;

		String sql = "DELETE FROM MEMBERINFO WHERE M_NICKNAME = ?";

		re = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, nickname);
			}
		});

		return re;
	}


}
