package org.ga2.buna.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 플랜정보를 다루는 클래스
 * @author 장희정
 */
@Slf4j
@Repository
public class PlanDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 마이페이지 내 플랜 목록 얻어오는 메서드 -최신순 정렬
	 * @param m_nickname : 닉네임에 해당하는 planinfo테이블의 플랜 목록 모두 조회
	 * @return PlanInfoDTO 객체를 담은 ArrayList를 리턴
	 */
	public List<PlanInfoDTO> getPlanInfo(String m_nickname) {


		String sql = "SELECT P_ROWNUM, M_NICKNAME, P_TITLE,"
				   + "       P_FIRSTDATE, P_LASTDATE, T_NAMELIST,"
				   + "       P_REGDATE, P_LIKE, P_PUBLIC "
				   + "  FROM PLANINFO "
				   + " WHERE M_NICKNAME = ? "
				   + "ORDER BY P_FIRSTDATE DESC";

		List<PlanInfoDTO> list = jdbcTemplate.query(sql, new RowMapper<PlanInfoDTO>() {
			@Override
			public PlanInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				//rs에는 select 결과 테이블이 담겨있다.
				//rowNum은 select 결과 테이블의 행의 수로 rowNum만큼 반복한다.
				PlanInfoDTO planInfoDTO = new PlanInfoDTO();

				planInfoDTO.setPlanRowNumber(rs.getInt("p_rownum"));
				planInfoDTO.setMemberNickName(rs.getString("m_nickname"));
				planInfoDTO.setPlanTitle(rs.getString("p_title"));
				planInfoDTO.setPlanFirstDate(rs.getTimestamp("p_firstdate"));
				planInfoDTO.setPlanLastDate(rs.getTimestamp("p_lastdate"));
				planInfoDTO.setTagNameList(rs.getString("t_namelist"));
				planInfoDTO.setPlanPublic(rs.getInt("p_public"));

				return planInfoDTO;
			}
		}, m_nickname);
		//nick은 ?에 들어갈 변수
		return list;
	}
/*

	*/
/**
	 * 플랜번호에 해당하는 planinfo 테이블의 데이터 삭제하는 메서드
	 * 
	 * @param p_rownum : 플랜 번호
	 * @return re==1 삭제 성공
	 */


	public int deletePlan(int p_rownum) {
		String sql = "DELETE FROM PLANINFO WHERE P_ROWNUM = ? ";
		int re = 0;

		re = jdbcTemplate.update(sql, p_rownum);

		return re;
	}

	public int publicCheck(int rownum) {

		String sql = "SELECT P_PUBLIC FROM PLANINFO WHERE P_ROWNUM = ?";
		int pub = jdbcTemplate.queryForObject(sql, Integer.class, rownum);

		return pub;
	}



	/**
	 * 플랜 공개/비공개 업데이트 메서드
	 * 
	 * @param p_rownum : 플랜 번호
	 * @param p_public : 공유 여부 체크, 0이면 비공개된 상태 1이면 공개된 상태
	 * @return re==1 플랜을 공개함, re==2 플랜을 비공개함
	 */

	/**
	 * 플랜 공개/비공개 업데이트 메서드
	 * @param p_rownum : 플랜 번호
	 * @param p_public : 공개 여부 체크 / 0-비공개, 1-공개
	 * @param n : 비공개=-1 / 공개=1
	 * @return
	 */
	public int publicUpdateInfo(int p_rownum, int p_public, int n) {
		int re = 0;

		String sql = "UPDATE PLANINFO"
				   + "   SET P_PUBLIC = ? "
				   + " WHERE P_ROWNUM = ? "
				   + "   AND P_PUBLIC = ? ";

		re = jdbcTemplate.update(sql, n, p_rownum, p_public);

		return re;
	}


	/**
	 * 디테일 페이지에 필요한 정보 얻어오는 메서드
	 * 
	 * @param p_rownum:플랜 번호
	 * @return planJoinDTO객체를 담은 arraylist
	 */

	public List<PlanJoinDTO> getPlanDetail(int p_rownum) {
		List<PlanJoinDTO> list = new ArrayList<>();

		String sql = "SELECT * FROM PLANDETAILVIEW WHERE P_ROWNUM = ? ";

		jdbcTemplate.query(sql, new RowMapper<PlanJoinDTO>() {
			@Override
			public PlanJoinDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PlanJoinDTO dto = new PlanJoinDTO();

				dto.setPlanRownum(rs.getInt(1));
				dto.setPlanTripday(rs.getInt(2));
				dto.setPlanTripdate(rs.getString(3));
				dto.setPlanSpotname(rs.getString(4));
				dto.setMemberNickname(rs.getString(5));
				dto.setPlanTitle(rs.getString(6));
				dto.setTagNamelist(rs.getString(7));
				dto.setPlanLike(rs.getInt(8));
				dto.setSpotSerialnum(rs.getString(9));
				dto.setPlanSequence(rs.getInt(10));
				dto.setSpotLocation(rs.getString(11));
				dto.setSpotNumber(rs.getString(12));

				return dto;
			}
		}, p_rownum);

		return list;
	}

	public List<SearchInfoDTO> getSearchInfo(int planRownum) {
		String sql = "SELECT P_SPOTNAME, LOCATION, PNUMBER FROM PLANDETAILVIEW WHERE P_ROWNUM = ?";

		List<SearchInfoDTO> list = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			SearchInfoDTO searchInfo = new SearchInfoDTO();
			searchInfo.setPlanSpotname(resultSet.getString(1));
			searchInfo.setSpotLocation(resultSet.getString(2));
			searchInfo.setSpotPhoneNumber(resultSet.getString(3));
			return searchInfo;
		}, planRownum);

		return list;
	}

	/*

	public ArrayList<PlanJoinDTO> getPlanDetail(int p_rownum) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet lrs = null;
		String sql = "";

		ArrayList<PlanJoinDTO> pJoinList = new ArrayList<>();

		try {
//			conn = getConnection();

			sql = "SELECT D.P_ROWNUM,"
			    + "       D.P_TRIPDAY,\r\n"
			    + "       IF(LAG(D.P_TRIPDATE) OVER(ORDER BY D.P_TRIPDATE, D.P_TRIPDATE, D.P_SEQUENCE)=D.P_TRIPDATE, NULL, D.P_TRIPDATE) P_TRIPDATE,"
			    + "       D.P_SPOTNAME," 
			    + "       I.M_NICKNAME," 
			    + "       I.P_TITLE," 
			    + "       I.T_NAMELIST,"
			    + "       I.P_LIKE,"
			    + "       D.S_SERIALNUM," 
			    + "       D.P_SEQUENCE "
			    + "  FROM PLANDETAIL D JOIN PLANINFO I" 
			    + "    ON D.P_ROWNUM = I.P_ROWNUM"
			    + "   AND D.P_ROWNUM = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlanJoinDTO dto = new PlanJoinDTO();

				dto.setPlanRownum(rs.getInt(1));
				dto.setPlanTripday(rs.getInt(2));
				dto.setPlanTripdate(rs.getString(3));
				dto.setPlanSpotname(rs.getString(4));
				dto.setMemberNickname(rs.getString(5));
				dto.setPlanTitle(rs.getString(6));
				dto.setTagNamelist(rs.getString(7));
				dto.setPlanLike(rs.getInt(8));
				dto.setSpotSerialnum(rs.getString(9));
				dto.setPlanSequence(rs.getInt(10));

				String serial = dto.getSpotSerialnum();
//				char serial = dto.getS_serialnum().charAt(0);

//				ArrayList<Character> arr = new ArrayList<Character>();
//				arr.add(serial);
//				
//				for (int i=0; i<arr.size(); i++) {
//					char serialA=arr.get(i).charValue();
//					char[] start = {'A', 'R', 'E', 'T'};

//					if (serialA == start[i]) {
//					}
//				}

				// 주소, 전화번호, 장소 얻어오기 위해서 테이블마다 따로 조회
				// serialnum의 시작값이 "A", "R", "E", "T"일 때 각각 분기처리
				if (serial.startsWith("A")) {
					sql = "SELECT D.S_SERIALNUM, A.A_LOCATION, A.A_PNUMBER"
					    + "  FROM PLANDETAIL D JOIN ACCOMMODATION A"
					    + "    ON D.S_SERIALNUM = A.S_SERIALNUM"
					    + " WHERE D.S_SERIALNUM = ?";

					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, serial);
					lrs = pstmt.executeQuery();

					if (lrs.next()) {
						dto.setSpotLocation(lrs.getString(2));
						dto.setSpotNumber(lrs.getString(3));
					}
				} else if (serial.startsWith("R")) {
					sql = "SELECT D.S_SERIALNUM, R.R_LOCATION, R.R_PNUMBER" 
					    + "  FROM PLANDETAIL D JOIN RESTAURANT R"
					    + "    ON D.S_SERIALNUM = R.S_SERIALNUM" 
					    + " WHERE D.S_SERIALNUM = ?";

					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, serial);
					lrs = pstmt.executeQuery();

					if (lrs.next()) {
						dto.setSpotLocation(lrs.getString(2));
						dto.setSpotNumber(lrs.getString(3));
					}
				} else if (serial.startsWith("E")) {
					sql = "SELECT D.S_SERIALNUM, E.E_LOCATION, E.E_PNUMBER, "
					    + "       E.E_VENUE, SUBSTR(E.E_NAME,INSTR(E.E_NAME,',')+2)"
					    + "  FROM PLANDETAIL D JOIN EVENT E"
					    + "    ON D.S_SERIALNUM = E.S_SERIALNUM"
					    + " WHERE D.S_SERIALNUM = ?";

					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, serial);
					lrs = pstmt.executeQuery();

					if (lrs.next()) {
						dto.setSpotLocation(lrs.getString(2));
						dto.setSpotNumber(lrs.getString(3));
						dto.setEventVenue(lrs.getString(4));
						dto.setEventName(lrs.getString(5));
					}
				} else if (serial.startsWith("T")) {
					sql = "SELECT DISTINCT D.S_SERIALNUM, T.TF_LOCATION, T.TF_PNUMBER"
					    + "  FROM PLANDETAIL D JOIN TRAFFIC T"
					    + "    ON D.S_SERIALNUM = T.S_SERIALNUM"
					    + " WHERE D.S_SERIALNUM = ?";

					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, serial);
					lrs = pstmt.executeQuery();

					if (lrs.next()) {
						dto.setSpotLocation(lrs.getString(2));
						dto.setSpotNumber(lrs.getString(3));
					}
				}
				pJoinList.add(dto);
			}
			log.info("조회 성공");

		} catch (SQLException ex) {
			ex.printStackTrace();
			log.info("조회 실패");
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
		return pJoinList;
	}

	*/

	/**
	 * 플랜 번호를 조건으로 전체 여행일 구하는 메서드
	 * 
	 * @param p_rownum 플랜번호
	 * @return totaltripday -> MAX(P_TRIPDAY)를 조회하여 해당 플랜의 최대 여행일을 리턴
	 *//*

	public int getPlanDay(int p_rownum) throws Exception {
		int totaltripday = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
//			conn = getConnection();

			sql = "SELECT MAX(P_TRIPDAY)" 
			    + "  FROM PLANDETAIL"
			    + " WHERE P_ROWNUM=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totaltripday = rs.getInt(1);
			}

		} catch (SQLException ex) {
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
		System.out.println(totaltripday);
		return totaltripday;
	}

	*/
/**
	 * 일자별 일정의 총 개수 구하는 메서드
	 * 
	 * @param totaltripday: 전체 여행일(getPlanDay()의 리턴값)
	 * @param rownum:       플랜 번호
	 * @return [totaltripday]크기만큼의 배열에 일자별 일정수를 담아서 리턴
	 *//*

	public int[] getTripDaySequence(int totaltripday, int rownum) throws Exception {

		int[] seqNumber = new int[totaltripday];

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
//			conn = getConnection();

			for (int i = 1; i <= seqNumber.length; i++) {
				sql = "select count(*)"
				    + "  from plandetail"
				    + " where p_rownum=? and p_tripday=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rownum);
				pstmt.setInt(2, i);
				rs = pstmt.executeQuery();

				// i=1일때 3, i=2일때 3, i=3일때 3 > 배열에 넣어주기
				if (rs.next()) {
					seqNumber[i - 1] = rs.getInt(1);
				}
			}

		} catch (SQLException ex) {
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
		return seqNumber;
	}
*/

} // DAO 끝