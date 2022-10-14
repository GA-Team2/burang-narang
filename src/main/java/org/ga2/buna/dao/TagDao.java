package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.ga2.buna.dto.TagDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 새 플랜 추가 페이지의 추천 태그 기능을 위한 DAO 클래스
 * @author 김규빈
 *
 */
@Slf4j
@Repository
public class TagDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 데이터베이스 연동을 위해 JNDI를 이용한 DataSource 설정
	 * @return Connection 획득
	 */
//	public Connection getConnection() {
//		Context ctx = null;
//		DataSource ds = null;
//
//		try {
//			ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
//			return ds.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	/**
	 * 태그들을 등록빈도순으로 정렬하여 조회
	 * @return 정렬된 태그 리스트
	 */
	public List<TagDto> listTag() {
		String query = "SELECT T_NAME FROM TAGLIST ORDER BY T_HIT DESC";
		List<TagDto> list = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			TagDto tagDto = new TagDto();
			tagDto.setTagName(resultSet.getString(1));
			return tagDto;
		});
		
		return list;
	}
}