package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.PlanDetail;

/**
 * 플랜 Detail에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
public class PlanDetailDAO extends PlanDetail {
	private static PlanDetailDAO pd_DAO = null;

	public static PlanDetailDAO getInstance() {
		if (pd_DAO == null)
			pd_DAO = new PlanDetailDAO();
		return pd_DAO;
	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/mysql"))).getConnection();
	}

	/**
	 * 플랜 Detail 객체와, 게시물 번호 변수를 받아 plandetail 정보를 insert하는 메서드
	 * 
	 * @param 플랜 디테일 객체, 게시물 번호
	 * @return 삽입 성공 시 (re 변수) 1 반환, 실패 시 -1 반환
	 *
	 */
	public int insertPlan(PlanDetail plan, int rownum) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			conn = getConnection();

			sql = "INSERT INTO plandetail VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, rownum);
			pstmt.setInt(2, plan.getP_tripday());
			pstmt.setTimestamp(3, plan.getP_tripdate());
			pstmt.setInt(4, plan.getP_sequence());
			pstmt.setString(5, plan.getS_serialnum());
			pstmt.setString(6, plan.getP_spotname());
			re = pstmt.executeUpdate();

			System.out.println("추가 완료");
		} catch (SQLException ex) {
			System.out.println("추가 실패");
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

	/**
	 * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 반환하는 메서드
	 * 
	 * @param 게시물 번호
	 * @return 플랜 디테일 객체
	 *
	 */
	public ArrayList<PlanDetail> getPlanDetail(int rownum) throws Exception {
		ArrayList<PlanDetail> pdList = new ArrayList<PlanDetail>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from plandetail where p_rownum=? order by p_tripday, p_sequence";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			rs = pstmt.executeQuery();
			// while or if
			while (rs.next()) {
				// rownum 컬럼 제외
				PlanDetail plan = new PlanDetail();
				plan.setP_rownum(rownum);
				plan.setP_tripday(rs.getInt(2));
				plan.setP_tripdate(rs.getTimestamp(3));
				plan.setP_sequence(rs.getInt(4));
				plan.setS_serialnum(rs.getString(5));
				plan.setP_spotname(rs.getString(6));
				pdList.add(plan);
			}
			System.out.println("조회 완료");
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

		return pdList;
	}

	/**
	 * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 삭제하는 메서드
	 * 
	 * @param 게시물 번호
	 * @return 삭제 성공 시 (re 변수) 1 반환, 실패 시 -1 반환
	 *
	 */
	public int deletePlan(int rownum) throws Exception {
		int re = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from plandetail" + " where p_rownum=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			pstmt.executeUpdate();
			re = 1;
			System.out.println("삭제 완료");
		} catch (SQLException ex) {
			System.out.println("삭제 실패");
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