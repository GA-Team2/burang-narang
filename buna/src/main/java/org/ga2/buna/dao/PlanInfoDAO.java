package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.PlanDetail;
import org.ga2.buna.dto.PlanInfo;

public class PlanInfoDAO extends PlanInfo {
	private static PlanInfoDAO pi_DAO = null;
	public static PlanInfoDAO getInstance() {
		if(pi_DAO == null) pi_DAO = new PlanInfoDAO();
		return pi_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	public int insertPlan(PlanInfo plan) throws Exception {
		int re = -1;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		int number=-1;
		
		try {
			conn = getConnection();
			sql = "select max(p_rownum) from planinfo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				number = rs.getInt(1)+1;
			} else {
				number = 1;
			}
			plan.setP_rownum(number);

			//sql="INSERT INTO boardt VALUES(?,?,?,?,?,?,?,?)";
			sql="INSERT INTO planinfo VALUES(?,?,?,?,?,?,?,?,?)";
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
		}catch(SQLException ex){
			System.out.println("추가 실패");
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
		
		if(re == 1) return number;
		else return re;
	}
	
	public PlanInfo getPlanInfo(int rownum) throws Exception {
		PlanInfo planinfo = new PlanInfo();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from planinfo where p_rownum=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// ronum, nick 제외
				planinfo.setP_title(rs.getString(3));
				planinfo.setP_firstdate(rs.getTimestamp(4));
				planinfo.setP_lastdate(rs.getTimestamp(5));
				planinfo.setT_namelist(rs.getString(6));
				// 작성 일자, 좋아요, 공개 여부 제외
			}
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
		
		return planinfo;
	}
}
