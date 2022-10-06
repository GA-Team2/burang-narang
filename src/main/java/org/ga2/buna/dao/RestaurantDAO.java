package org.ga2.buna.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.RestaurantDTO;


/**
 * 맛집 정보에 접근하는 클래스
 * @author 한에채
 *
 */
public class RestaurantDAO extends RestaurantDTO {
	private static RestaurantDAO re_DAO = null;
	public static RestaurantDAO getInstance() {
		if(re_DAO == null) re_DAO = new RestaurantDAO();
		return re_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	
	/**
	 * 시리얼 넘버 변수를 통해 해당 맛집의 정보를 반환하는 클래스
	 *
	 */
	public RestaurantDTO getRestaurant(String serialNum) {
		RestaurantDTO restaurant = new RestaurantDTO();
		
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
	
	/**
	 * 맛집 DB 정보 반환하는 메서드
	 *
	 */
	public ArrayList<RestaurantDTO> getReList(){
		ArrayList<RestaurantDTO> reList = new ArrayList<RestaurantDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from restaurant";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RestaurantDTO restaurant = new RestaurantDTO();
				
				restaurant.setS_serialnum(rs.getString(1));
				restaurant.setR_type(rs.getString(2));
				restaurant.setR_name(rs.getString(3));
				restaurant.setR_pnumber(rs.getString(4));
				restaurant.setR_location(rs.getString(5));
				restaurant.setR_opentime(rs.getString(6));
				restaurant.setR_closetime(rs.getString(7));
				restaurant.setR_photo(rs.getString(8));
				
				reList.add(restaurant);
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
		
		return reList;
	}
}