package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.ga2.buna.dto.TagDto;

public class TagDao {
	public Connection getConnection() {
		Context ctx = null;
		DataSource ds = null;

		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<TagDto> listTag() {
		String query = "SELECT T_NAME FROM TAGLIST ORDER BY T_HIT DESC";
		ArrayList<TagDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TagDto td = new TagDto();
				td.setTagName(rs.getString(1));
				list.add(td);
			}

			System.out.println("조회성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회실패");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}