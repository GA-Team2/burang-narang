package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.PlanDetail;
import org.ga2.buna.dto.PlanInfo;

/**
 * 플랜 Info에 접근하는 클래스 => PlanDAO와 병합 필요!!
 * 
 * @author 한애채
 *
 */
public class PlanInfoDAO extends PlanInfo {
	private static PlanInfoDAO pi_DAO = null;

	public static PlanInfoDAO getInstance() {
		if (pi_DAO == null)
			pi_DAO = new PlanInfoDAO();
		return pi_DAO;
	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}

	/**
	 * 프랜 Info 정보를 insert하는 메서드
	 * 
	 * @param 플랜 디테일 객체, 게시물 번호
	 * @return 삽입 성공 시 (re 변수) 1 반환, 실패 시 -1 반환
	 *
	 */
	public int insertPlan(PlanInfo plan) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int number = -1;

		try {
			conn = getConnection();
			sql = "select max(p_rownum) from planinfo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				number = rs.getInt(1) + 1;
			} else {
				number = 1;
			}
			plan.setP_rownum(number);

			sql = "INSERT INTO planinfo VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, plan.getM_nickname());
			pstmt.setString(3, plan.getP_title());
			pstmt.setTimestamp(4, plan.getP_firstdate());
			pstmt.setTimestamp(5, plan.getP_lastdate());
			pstmt.setString(6, plan.getT_namelist());
			pstmt.setTimestamp(7, plan.getP_regdate());
			pstmt.setInt(8, 0);
			pstmt.setInt(9, plan.getP_public());
			re = pstmt.executeUpdate();
			System.out.println("추가 성공");
		} catch (SQLException ex) {
			System.out.println("추가 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (re == 1)
			return number;
		else
			return re;
	}

	/**
	 * 게시물 번호 변수를 통해 플랜 Info 정보를 반환하는 메서드
	 * 
	 * @param 게시물 번호
	 * @return 플랜 인포 객체
	 *
	 */
	public PlanInfo getPlanInfo(int rownum) throws Exception {
		PlanInfo planinfo = new PlanInfo();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from planinfo where p_rownum=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// ronum, nick 제외
				planinfo.setP_title(rs.getString(3));
				planinfo.setP_firstdate(rs.getTimestamp(4));
				planinfo.setP_lastdate(rs.getTimestamp(5));
				planinfo.setT_namelist(rs.getString(6));
				// 작성 일자, 좋아요, 공개 여부 제외
			}
			System.out.println("조회 성공");
		} catch (SQLException ex) {
			System.out.println("조회 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return planinfo;
	}

	/**
	 * 플랜 Info 객체 변수로 받아 플랜 Info를 수정하는 메서드
	 * 
	 * @param 플랜 인포 객체
	 * @return 갱신 성공 시 (re 변수) 1 반환, 실패 시 -1 반환
	 *
	 */
	public int updatePlanInfo(PlanInfo plan) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			conn = getConnection();

			sql = "UPDATE planinfo SET p_title=?" + ", p_firstdate=?" + ", p_lastdate=?" + ", t_namelist=?"
					+ ", p_public=?" + " WHERE p_rownum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getP_title());
			pstmt.setTimestamp(2, plan.getP_firstdate());
			pstmt.setTimestamp(3, plan.getP_lastdate());
			pstmt.setString(4, plan.getT_namelist());
			pstmt.setInt(5, plan.getP_rownum());
			pstmt.setInt(6, plan.getP_public());
			pstmt.executeUpdate();
			re = 1;
			System.out.println("수정 성공");
		} catch (SQLException ex) {
			System.out.println("수정 실패");
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return re;
	}
}
