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
import org.springframework.jdbc.core.JdbcTemplate;
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
	 *//*
	public int updateMember(MemberDTO member, String nickname) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {

			if(member.getMemberPassword()!=null) {
				sql = "UPDATE MEMBERINFO"
					+ "   SET M_PASSWORD=?, M_BIRTHYEAR=?, M_GENDER=?"
					+ " WHERE M_NICKNAME=?";

				conn = getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, member.getMemberPassword());
				pstmt.setInt(2, member.getMemberBirthyear());
				pstmt.setInt(3, member.getMemberGender());
				pstmt.setString(4, nickname);

				re = pstmt.executeUpdate();

			} else {
				sql = "UPDATE MEMBERINFO"
						+ "   SET M_BIRTHYEAR=?, M_GENDER=?"
						+ " WHERE M_NICKNAME=?";

				conn = getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, member.getMemberBirthyear());
				pstmt.setInt(2, member.getMemberGender());
				pstmt.setString(3, nickname);

				re = pstmt.executeUpdate();

			}
			if (re == 1) {
				log.info("정보 변경 성공");
			}
		} catch (SQLException ex) {
			log.info("정보 변경 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return re;
	}

	*//**
	 * 회원 정보 삭제 메서드
	 * 
	 * @param nickname : 로그인 했을 때 저장 된 닉네임값
	 * @param password : 입력받은 password값
	 * @return re==1 회원정보 삭제 성공 / re==0 비밀번호 불일치
	 *//*
	public int deleteMember(String nickname, String password) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		String pwd = "";

		try {
			conn = getConnection();

			sql = "SELECT M_PASSWORD FROM MEMBERINFO WHERE M_NICKNAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pwd = rs.getString(1);

				if (pwd.equals(password)) {
					if (pstmt != null)
						pstmt.close();
					sql = "DELETE FROM MEMBERINFO WHERE M_NICKNAME=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, nickname);
					re = pstmt.executeUpdate();
					re = 1; // 회원 정보 db 삭제 성공
					log.info("정보 삭제 성공");
				} else {
					re = 0; // 비밀번호 불일치
					log.info("비밀번호 불일치");
				}
			}
		} catch (SQLException ex) {
			log.info("삭제 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	*/

}
