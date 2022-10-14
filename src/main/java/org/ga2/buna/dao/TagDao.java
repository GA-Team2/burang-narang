package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.ga2.buna.dto.TagDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 새 플랜 추가 페이지의 추천 태그 기능을 위한 DAO 클래스
 * @author 김규빈
 *
 */
@Slf4j
public class TagDao {
	/**
	 * 데이터베이스 연동을 위해 JNDI를 이용한 DataSource 설정
	 * @return Connection 획득
	 */
	public Connection getConnection() {
		Context ctx = null;
		DataSource ds = null;

		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 태그들을 등록빈도순으로 정렬하여 조회
	 * @return 정렬된 태그 리스트
	 */
	public ArrayList<TagDto> listTag() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT T_NAME FROM TAGLIST ORDER BY T_HIT DESC";
		ArrayList<TagDto> list = new ArrayList<>();

		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TagDto td = new TagDto();
				td.setTagName(rs.getString(1));
				list.add(td);
			}

			log.info("조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("조회 실패");
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