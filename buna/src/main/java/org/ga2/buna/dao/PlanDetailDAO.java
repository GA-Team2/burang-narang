package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.PlanDetail;
import org.ga2.buna.dto.PlanInfo;

public class PlanDetailDAO extends PlanDetail {
	private static PlanDetailDAO pd_DAO = null;
	public static PlanDetailDAO getInstance() {
		if(pd_DAO == null) pd_DAO = new PlanDetailDAO();
		return pd_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	public int insertPlan(PlanDetail plan, int rownum) throws Exception {
		int re = -1;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";
		
		try {
			conn = getConnection();

			sql="INSERT INTO plandetail VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rownum);
			pstmt.setInt(2, plan.getP_tripday());
			pstmt.setTimestamp(3, plan.getP_tripdate());
			pstmt.setInt(4, plan.getP_sequence());
			pstmt.setString(5, plan.getS_serialnum());
			pstmt.setString(6, plan.getP_spotname());
			re = pstmt.executeUpdate();
			
		}catch(SQLException ex){
			System.out.println("추가 실패");
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
}
