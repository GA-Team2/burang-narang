package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.AccommodationDTO;

/**
 * 숙소에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
public class AccommodationDAO extends AccommodationDTO {
	private static AccommodationDAO ac_DAO = null;

	public static AccommodationDAO getInstance() {
		if (ac_DAO == null)
			ac_DAO = new AccommodationDAO();
		return ac_DAO;
	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/mysql"))).getConnection();
	}

	/**
	 * 숙소 정보 리스트를 반환하는 메서드
	 * 
	 * @return 숙소 객체 리스트
	 */
	public ArrayList<AccommodationDTO> getAcList() {
		ArrayList<AccommodationDTO> acList = new ArrayList<AccommodationDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from Accommodation";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				AccommodationDTO accommodation = new AccommodationDTO();

				accommodation.setS_serialnum(rs.getString(1));
				accommodation.setA_type(rs.getString(2));
				accommodation.setA_name(rs.getString(3));
				accommodation.setA_pnumber(rs.getString(4));
				accommodation.setA_location(rs.getString(5));
				accommodation.setA_checkin(rs.getString(6));
				accommodation.setA_checkout(rs.getString(7));
				accommodation.setA_photo(rs.getString(8));

				acList.add(accommodation);
			}
			System.out.println("조회 성공");
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return acList;
	}

	/**
	 * 시리얼 넘버를 변수로 받아 숙소 정보를 반환하는 메서드
	 * 
	 * @param 장소 고유 번호
	 * @return 숙소 객체
	 *
	 */
	public AccommodationDTO getAccommodation(String serialNum) {
		AccommodationDTO accommodation = new AccommodationDTO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from accommodation where s_serialnum=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				accommodation.setS_serialnum(rs.getString(1));
				accommodation.setA_type(rs.getString(2));
				accommodation.setA_name(rs.getString(3));
				accommodation.setA_pnumber(rs.getString(4));
				accommodation.setA_location(rs.getString(5));
				accommodation.setA_checkin(rs.getString(6));
				accommodation.setA_checkout(rs.getString(7));
				accommodation.setA_photo(rs.getString(8));
			}
			System.out.println("조회 성공");
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return accommodation;
	}
}
