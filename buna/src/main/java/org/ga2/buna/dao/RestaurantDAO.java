package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.Restaurant;
import org.ga2.buna.dto.SpotDetail;

public class RestaurantDAO extends Restaurant {
	private static RestaurantDAO re_DAO = null;
	public static RestaurantDAO getInstance() {
		if(re_DAO == null) re_DAO = new RestaurantDAO();
		return re_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	public Restaurant getRes(String serialNum) {
		Restaurant restaurant = new Restaurant();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from restaurant where s_serialnum=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				restaurant.setS_serialnum(rs.getString(1));
				restaurant.setR_type(rs.getString(2));
				restaurant.setR_name(rs.getString(3));
				restaurant.setR_pnumber(rs.getString(4));
				restaurant.setR_location(rs.getString(5));
				restaurant.setR_opentime(rs.getString(6));
				restaurant.setR_closetime(rs.getString(7));
				restaurant.setR_photo(rs.getString(8));
			}
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return restaurant;
	}
	
	public ArrayList<Restaurant> getResList(){
		ArrayList<Restaurant> resList = new ArrayList<Restaurant>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from restaurant";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Restaurant restaurant = new Restaurant();
				
				restaurant.setS_serialnum(rs.getString(1));
				restaurant.setR_type(rs.getString(2));
				restaurant.setR_name(rs.getString(3));
				restaurant.setR_pnumber(rs.getString(4));
				restaurant.setR_location(rs.getString(5));
				restaurant.setR_opentime(rs.getString(6));
				restaurant.setR_closetime(rs.getString(7));
				restaurant.setR_photo(rs.getString(8));
				
				resList.add(restaurant);
			}
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return resList;
	}
}

