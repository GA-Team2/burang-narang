package org.ga2.buna.dao.like;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

/**
 * 추천 수 관리를 위한 클래스
 * 
 * @author 장희정
 */
@Slf4j
@Repository
public class LikeDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/**
	 * info 테이블 p_like 컬럼 수 증가
	 * 
	 * @param rownum   : 플랜번호
	 * @param likeTrue : 좋아요 했는지 여부
	 * @return re==1이면 추천 완료
	 */
/*
	public int updateLike(int rownum, Boolean likeTrue) throws Exception {
		int re = 0;
		int i = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			conn = getConnection();

			// like 여부에 따라 1, -1 세팅하고 좋아요 수 컬럼에 반영
			if (likeTrue) {
				i = 1;
			} else {
				i = -1;
			}

			sql = "UPDATE PLANINFO"
			    + "   SET P_LIKE = P_LIKE + " + i
			    + " WHERE P_ROWNUM = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			re = pstmt.executeUpdate();
			// 업데이트 성공 시 re==1
			log.info("p_like컬럼 업데이트");
		} catch (SQLException ex) {
			ex.printStackTrace();
			log.info("p_like컬럼 업데이트 실패");
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

	/**
	 * 추천 클릭시 likeinfo 테이블에 닉네임+플랜 넘버를 추가
	 * 
	 * @param member : 추천한 멤버 정보 가져오기(세션에 저장된 닉네임)
	 * @param rownum : 플랜넘버
	 * @param age : 10대 = 1, 20대 = 2, ...
	 * @return re==1이면 좋아요 반영 됨
	 */

	public int insertLike(MemberDTO member, int rownum, int age) {
		int re=0;
		String sql = "INSERT INTO LIKEINFO VALUES (?,?,?,?)";

		re = jdbcTemplate.update(sql,
							     member.getMemberNickname(),
								 rownum,
								 age,
								 member.getMemberGender());

		return re;
	}

	/*

	public int insertLike(MemberDTO member, int rownum) throws Exception {

		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			conn = getConnection();

			sql = "INSERT INTO LIKEINFO VALUES(?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberNickname());
			pstmt.setInt(2, rownum);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int age = (year - member.getMemberBirthyear()) / 10;
			// 1이면 10대, 2면 20대, ...
			pstmt.setInt(3, age);
			pstmt.setInt(4, member.getMemberGender());

			re = pstmt.executeUpdate();
			// 업데이트 성공 시 re==1
			log.info("추천 성공");
		} catch (SQLException ex) {
			ex.printStackTrace();
			log.info("추천 실패");
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



	/**
	 * 닉네임, 플랜 번호를 조건으로 likeinfo 테이블 조회 -> 추천 여부 체크
	 * @param rownum:   플랜 번호
	 * @param nick: 닉네임
	 * @return re:조회결과 -> re==1 좋아요O, re==0 좋아요X
	 */

	public int checkLike(int rownum, String nick) {
		int re = 0;

		String sql = "SELECT count(*) FROM LIKEINFO"
				   + " WHERE P_ROWNUM = ?"
				   + "   AND M_NICKNAME = ?";

		re = jdbcTemplate.queryForObject(sql, Integer.class, rownum, nick);

		log.info("추천여부 체크 1이면 추천O 0이면 추천X => {}", re);
		return re;
	};



	/**
	 * 추천 취소 시 likeinfo 테이블에서 행 삭제하는 메서드
	 * 
	 * @param rownum:   플랜 번호
	 * @param nickname: 세션에 저장된 닉네임
	 * @return re==-1 취소 완료
	 */


	public int deleteLikeInfo(int rownum, String nickname) {
		int re = 0;

		String sql = "DELETE FROM LIKEINFO"
				   + " WHERE P_ROWNUM = ?"
				   + "   AND M_NICKNAME = ?";

		re = jdbcTemplate.update(sql, ps -> {
			ps.setInt(1, rownum);
			ps.setString(2, nickname);
		});

		return re;
	}


	/**
	 * 플랜번호를 조건으로 추천 건수 조회하는 메서드
	 * 
	 * @param rownum: 플랜 번호
	 * @return likeNum: p_like컬럼의 데이터를 int로 반환
	 */
	public int getLikeNum(int rownum) {
		int likeNum = 0;

		String sql = "SELECT P_LIKE FROM PLANINFO WHERE P_ROWNUM = ?";

		likeNum = jdbcTemplate.queryForObject(sql, Integer.class, rownum);
		log.info("likeNum");

		return likeNum;
	}

}