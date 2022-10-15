package org.ga2.buna.dao;

import org.ga2.buna.dto.PlanInfoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 플랜 Info에 접근하는 클래스 => PlanDAO와 병합 필요!!
 * 
 * @author 한애채
 *
 */
public class PlanInfoDAO extends PlanInfoDTO {
	private static PlanInfoDAO pi_DAO = null;

	public static PlanInfoDAO getInstance() {
		if (pi_DAO == null)
			pi_DAO = new PlanInfoDAO();
		return pi_DAO;
	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/mysql"))).getConnection();
	}

	/**
	 * 프랜 Info 정보를 insert하는 메서드
	 * 
	 * @param 플랜 디테일 객체, 게시물 번호
	 * @return 삽입 성공 시 (re 변수) 1 반환, 실패 시 -1 반환
	 *
	 */
	public int insertPlan(PlanInfoDTO plan) throws Exception {
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
			plan.setPlanRowNum(number);

			sql = "INSERT INTO planinfo VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, plan.getMemberNickName());
			pstmt.setString(3, plan.getPlanTitle());
			pstmt.setTimestamp(4, plan.getPlanFirstDate());
			pstmt.setTimestamp(5, plan.getPlanLastDate());
			pstmt.setString(6, plan.getTagNameList());
			pstmt.setTimestamp(7, plan.getPlanRegDate());
			pstmt.setInt(8, 0);
			pstmt.setInt(9, plan.getPlanPublic());
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
	public PlanInfoDTO getPlanInfo(int rownum) throws Exception {
		PlanInfoDTO planinfo = new PlanInfoDTO();

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
				planinfo.setPlanTitle(rs.getString(3));
				planinfo.setPlanFirstDate(rs.getTimestamp(4));
				planinfo.setPlanLastDate(rs.getTimestamp(5));
				planinfo.setTagNameList(rs.getString(6));
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
	public int updatePlanInfo(PlanInfoDTO plan) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			conn = getConnection();

			sql = "UPDATE planinfo SET p_title=?"
									+ ", p_firstdate=?"
									+ ", p_lastdate=?"
									+ ", t_namelist=?"
									+ ", p_public=?"
									+ " WHERE p_rownum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, plan.getPlanTitle());
			pstmt.setTimestamp(2, plan.getPlanFirstDate());
			pstmt.setTimestamp(3, plan.getPlanLastDate());
			pstmt.setString(4, plan.getTagNameList());
			pstmt.setInt(5, plan.getPlanPublic());
			pstmt.setInt(6, plan.getPlanRowNum());
			pstmt.executeUpdate();
			re = 1;
			System.out.println("plan info 수정 성공");
		} catch (SQLException ex) {
			System.out.println("plan info 수정 실패");
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
