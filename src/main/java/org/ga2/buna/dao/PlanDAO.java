package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.PlanInfoDTO;
import org.ga2.buna.dto.PlanJoinDTO;

/**
 * 플랜정보를 다루는 클래스
 * @author 장희정
 */
public class PlanDAO {
	private static PlanDAO instance=new PlanDAO();

	/**
	 * 전역 객체 생성
	 * @return PlanDAO 객체
	 */
	public static PlanDAO getInstance() {
		return instance;
	}

	/**
	 * db연결
	 * @return 커넥션 객체 생성
	 */
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	/**
	 * 마이페이지 내 플랜 목록 얻어오는 메서드 -최신순 정렬
	 * @param m_nickname : 닉네임에 해당하는 planinfo테이블의 플랜 목록 모두 조회
	 * @return PlanInfoDTO 객체를 담은 ArrayList를 리턴
	 */
	public ArrayList<PlanInfoDTO> getPlanInfo(String m_nickname) throws Exception {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";

		ArrayList<PlanInfoDTO> planInfoList = new ArrayList<>();

		try {
			conn = getConnection();

			sql = "SELECT P_ROWNUM, M_NICKNAME, P_TITLE,"
			    + "       P_FIRSTDATE, P_LASTDATE, T_NAMELIST,"
			    + "       P_REGDATE, P_LIKE, P_PUBLIC "
			    + "  FROM PLANINFO " 
			    + " WHERE M_NICKNAME=? "
			    + "ORDER BY P_FIRSTDATE DESC";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, 	m_nickname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PlanInfoDTO planinfo = new PlanInfoDTO();

				planinfo.setP_rownum(rs.getInt("P_ROWNUM"));
				//플랜 자세히 보기 페이지에 넘기기 위해 rownum값 받아오기
				planinfo.setP_title(rs.getString("P_TITLE"));
				planinfo.setP_firstdate(rs.getTimestamp("P_FIRSTDATE"));
				planinfo.setP_lastdate(rs.getTimestamp("P_LASTDATE"));
				planinfo.setT_namelist(rs.getString("T_NAMELIST"));
				planinfo.setP_regdate(rs.getTimestamp("P_REGDATE"));
				planinfo.setP_like(rs.getInt("P_LIKE"));
				planinfo.setP_public(rs.getInt("P_PUBLIC"));

				planInfoList.add(planinfo);
			}
			System.out.println("조회 성공");
		}catch(SQLException ex){
			System.out.println("조회 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return planInfoList;
	}

	/**
	 * 플랜번호에 해당하는 planinfo 테이블의 데이터 삭제하는 메서드
	 * @param p_rownum : 플랜 번호
	 * @return re==1 삭제 성공
	 */
	public int deleteInfo (int p_rownum) throws Exception {
		int re = 0;

		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";

		try {
			conn = getConnection();

			sql = "DELETE PLANINFO"
			    + " WHERE P_ROWNUM=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			re = pstmt.executeUpdate();

			System.out.println("삭제 성공");

		}catch(SQLException ex){
			System.out.println("삭제 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return re;
	}

	/**
	 * 플랜 공개/비공개 업데이트 메서드
	 * @param p_rownum : 플랜 번호
	 * @param p_share  : 공유 여부 체크, 0이면 비공개된 상태 1이면 공개된 상태
	 * @return re==1 플랜을 공개함, re==2 플랜을 비공개함
	 */
	public int publicUpdateInfo (int p_rownum, int p_public) throws Exception {
		int re=0;

		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";

		try {
			conn = getConnection();

			//공유여부(p_share)가 0이면 1로 변경
			if (p_public==0) {
				sql = "update planinfo"
				    + "   set p_public = 1" 
				    + " where p_rownum = ?"
				    + "   and p_public = 0";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, p_rownum);
				pstmt.executeUpdate();
				re=1;   //플랜 공개
				System.out.println("플랜 공개");
			} else {
				sql = "update planinfo"
					+ "   set p_public = 0" 
					+ " where p_rownum = ?"
					+ "   and p_public = 1";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, p_rownum);
				pstmt.executeUpdate();
				re=2; 	//플랜 비공개
				System.out.println("플랜 비공개");
			}


		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return re;
	}



	/**
	 * 디테일 페이지에 필요한 정보 얻어오는 메서드
	 * @param p_rownum:플랜 번호
	 * @return planJoinDTO객체를 담은 arraylist
	 */
	public ArrayList<PlanJoinDTO> getPlanDetail(int p_rownum) throws Exception {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSet lrs=null;
		String sql="";

		ArrayList<PlanJoinDTO> pJoinList = new ArrayList<>();

		try {
			conn = getConnection();

			sql = "SELECT D.P_ROWNUM," 
			    + "       D.P_TRIPDAY,\r\n"
			    + "       DECODE(LAG(D.P_TRIPDATE) OVER(ORDER BY D.P_TRIPDATE, D.P_TRIPDATE, D.P_SEQUENCE), D.P_TRIPDATE, NULL, D.P_TRIPDATE) P_TRIPDATE,"
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

				dto.setP_rownum(rs.getInt(1));
				dto.setP_tripday(rs.getInt(2));
				dto.setP_tripdate(rs.getString(3));
				dto.setP_spotname(rs.getString(4));
				dto.setM_nickname(rs.getString(5));
				dto.setP_title(rs.getString(6));
				dto.setT_namelist(rs.getString(7));
				dto.setP_like(rs.getInt(8));
				dto.setS_serialnum(rs.getString(9));
				dto.setP_sequence(rs.getInt(10));

				String serial = dto.getS_serialnum();
//				char serial = dto.getS_serialnum().charAt(0);

//				ArrayList<Character> arr = new ArrayList<Character>();
//				arr.add(serial);
//				
//				for (int i=0; i<arr.size(); i++) {
//					char serialA=arr.get(i).charValue();
//					
//					if (serialA) {
//						
//					}
//				}

				
				//주소, 전화번호, 장소 얻어오기 위해서 테이블마다 따로 조회
				//serialnum의 시작값이 "A", "R", "E", "T"일 때 각각 분기처리
				if (serial.startsWith("A")) {
					sql = "SELECT D.S_SERIALNUM, A.A_LOCATION, A.A_PNUMBER"
					    + "  FROM PLANDETAIL D JOIN ACCOMMODATION A"
					    + "    ON D.S_SERIALNUM = A.S_SERIALNUM"
					    + " WHERE D.S_SERIALNUM = ?";

					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, serial);
					lrs = pstmt.executeQuery();

					if (lrs.next()) {
						dto.setS_location(lrs.getString(2));
						dto.setS_pnumber(lrs.getString(3));
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
						dto.setS_location(lrs.getString(2));
						dto.setS_pnumber(lrs.getString(3));
					}
				} else if (serial.startsWith("E")) {
					sql = "SELECT D.S_SERIALNUM, E.E_LOCATION, E.E_PNUMBER, "
					    + "   E.E_VENUE, SUBSTR(E.E_NAME,INSTR(E.E_NAME,',',-1)+2)"
					    + "  FROM PLANDETAIL D JOIN EVENT E"
					    + "    ON D.S_SERIALNUM = E.S_SERIALNUM"
					    + " WHERE D.S_SERIALNUM = ?";

					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, serial);
					lrs = pstmt.executeQuery();

					if (lrs.next()) {
						dto.setS_location(lrs.getString(2));
						dto.setS_pnumber(lrs.getString(3));
						dto.setE_venue(lrs.getString(4));
						dto.setE_name(lrs.getString(5));
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
						dto.setS_location(lrs.getString(2));
						dto.setS_pnumber(lrs.getString(3));
					}
				}
				pJoinList.add(dto);
			}
			System.out.println("조회 성공");

		}catch(SQLException ex){
			System.out.println("조회 실패");
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return pJoinList;
	}



	/**
	 * 플랜 번호를 조건으로 전체 여행일 구하는 메서드
	 * @param p_rownum 플랜번호
	 * @return totaltripday -> MAX(P_TRIPDAY)를 조회하여 해당 플랜의 최대 여행일을 리턴
	 */
	public int getPlanDay(int p_rownum) throws Exception {
		int totaltripday=0;

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="";

		try {
			conn = getConnection();

			sql = "SELECT MAX(P_TRIPDAY)"
			    + "  FROM PLANDETAIL"
			    + " WHERE P_ROWNUM=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totaltripday=rs.getInt(1);
			}

		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println(totaltripday);
		return totaltripday;
	}

	/**
	 * 일자별 일정의 총 개수 구하는 메서드
	 * @param totaltripday: 전체 여행일(getPlanDay()의 리턴값)
	 * @param rownum: 플랜 번호
	 * @return [totaltripday]크기만큼의 배열에 일자별 일정수를 담아서 리턴
	 */
	public int[] getTripDaySequence(int totaltripday, int rownum) throws Exception {

		int[] seqNumber = new int[totaltripday];

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="";

		try {
			conn = getConnection();

			for (int i=1; i<=seqNumber.length; i++) {
				sql = "select count(*)"
				    + "  from plandetail"
				    + " where p_rownum=? and p_tripday=?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rownum);
				pstmt.setInt(2, i);
				rs = pstmt.executeQuery();

				//i=1일때 3, i=2일때 3, i=3일때 3 > 배열에 넣어주기
				if (rs.next()) {
					seqNumber[i-1] = rs.getInt(1);
				}
			}

		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return seqNumber;
	}



} //DAO 끝