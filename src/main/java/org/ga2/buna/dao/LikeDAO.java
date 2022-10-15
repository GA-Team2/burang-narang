package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.MemberDTO;
import org.ga2.buna.dto.PlanInfoDTO;

/**
 * 추천 수 관리를 위한 클래스
 * 
 * @author 장희정
 */
@Slf4j
public class LikeDAO {
	private static LikeDAO instance = new LikeDAO();

	public static LikeDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}

	/**
	 * info 테이블 p_like 컬럼 수 증가
	 * 
	 * @param rownum   : 플랜번호
	 * @param likeTrue : 좋아요 했는지 여부
	 * @return re==1이면 추천 완료
	 */
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

	/**
	 * 추천 클릭시 likeinfo 테이블에 닉네임+플랜 넘버를 추가
	 * 
	 * @param member : 추천한 멤버 정보 가져오기(세션에 저장된 닉네임)
	 * @param rownum : 플랜넘버
	 * @return re==1이면 좋아요 반영 됨
	 */
	public int insertLike(MemberDTO member, int rownum) throws Exception {

		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			conn = getConnection();

			sql = "INSERT INTO LIKEINFO VALUES(?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_nickname());
			pstmt.setInt(2, rownum);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int age = (year - member.getM_birthyear()) / 10;
			// 1이면 10대, 2면 20대, ...
			pstmt.setInt(3, age);
			pstmt.setInt(4, member.getM_gender());

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

	/**
	 * 닉네임, 플랜 번호를 조건으로 likeinfo 테이블 조회 -> 추천 여부 체크
	 * 
	 * @param rownum:   플랜 번호
	 * @param nickname: 닉네임
	 * @return re==1 좋아요O / re==0 좋아요X
	 */
	public int checkLike(int rownum, String nickname) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = getConnection();

			sql = "SELECT *"
			    + "  FROM LIKEINFO"
			    + " WHERE P_ROWNUM = ? AND M_NICKNAME = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			pstmt.setString(2, nickname);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				re = 1; // 조회결과 있으면 re==1로 좋아요 한 상태
			} else {
				re = 0; // 조회결과 없으면 re==0으로 좋아요 하지 않은 상태
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return re;
	}

	/**
	 * 추천 취소 시 likeinfo 테이블에서 행 삭제하는 메서드
	 * 
	 * @param rownum:   플랜 번호
	 * @param nickname: 세션에 저장된 닉네임
	 * @return re==-1 취소 완료
	 */
	public int deleteLike(int rownum, String nickname) throws Exception {
		int re = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			// 1. 커넥션을 안해서 업데이트가 안 됐음
			// 2. pstmt를 닫아주어야 결과값을 뿌려준다.
			conn = getConnection();

			sql = "DELETE "
			    + "  FROM LIKEINFO"
			    + " WHERE P_ROWNUM = ?"
			    + "   AND M_NICKNAME = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			pstmt.setString(2, nickname);
			pstmt.executeUpdate();

			re = -1; // 삭제 성공 시 re=-1 세팅
			log.info("취소 성공");
		} catch (SQLException ex) {
			ex.printStackTrace();
			log.info("취소 실패");
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

	/**
	 * 플랜번호를 조건으로 추천 건수 조회하는 메서드
	 * 
	 * @param rownum: 플랜 번호
	 * @return likeNum: p_like컬럼의 데이터를 int로 반환
	 */
	public int getLikeNum(int rownum) throws Exception {
		int likeNum = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = getConnection();

			sql = "SELECT P_LIKE"
			    + "  FROM PLANINFO"
			    + " WHERE P_ROWNUM = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				PlanInfoDTO info = new PlanInfoDTO();

				info.setPlanLike(rs.getInt(1));

				likeNum = info.getPlanLike();
				// likeNum에 p_like컬럼의 데이터값 세팅
			}
			log.info("조회 성공");
		} catch (SQLException ex) {
			ex.printStackTrace();
			log.info("조회 실패");
		} finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return likeNum;
	}

}