package org.ga2.buna.dao.planboard;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.planboard.PopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 *
 * @author 강승구
 *
 */
@Slf4j
@Repository

public class PopDAO{

	private JdbcTemplate jdbcTemplate;


	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 인기플랜공유 페이지 내 게시판 목록 출력하는 메서드
	 * @param pageNumber 페이징처리
	 * @param likeClick 클릭시 추천순으로 정렬하는 쿼리
	 * @return 쿼리 결과값을 PopDTO에 넣고 ArrayList배열에 담아 리턴
	 */
//	public List<PopDTO> popBoard(String pageNumber, String likeClick, String searchTag) {
	public List<PopDTO> popBoard() {
		String sql = "SELECT P_ROWNUM as planRownum , P_TITLE as planTitle,\n" +
				"\t   T_NAMELIST as tagNamelist, P_REGDATE as planRegdate,\n" +
				"     P_LIKE as planLike FROM BOARDVIEW ORDER BY P_ROWNUM DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PopDTO.class));

	}

	public List<PopDTO> pagingBoard(){
		String sql2 = "SELECT COUNT(P_ROWNUM) FROM BOARDVIEW";

		return jdbcTemplate.queryForObject(sql,Integer.class);
	}

//		Statement stmt = null;
//		ResultSet rs = null;
//		ResultSet pageSet = null;
//		int dbCount = 0;
//		int absoultePage = 1;
//		String sql = "";
//		String sql2 = "";
//
//		//태그서치 쿼리
//		if(searchTag != null) {
//				sql = "SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,\r\n"  +
//						"  	   P_REGDATE, P_LIKE FROM BOARDVIEW\r\n" +
//						"      WHERE T_NAMELIST LIKE '%"+searchTag+"%'\r\n" +
//						"      ORDER BY P_ROWNUM DESC";
//		} else {
//			//게시판 ROWNUM 정렬 쿼리
//			if(likeClick == null) {
//				sql = "SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,\r\n"  +
//						"      P_REGDATE, P_LIKE FROM BOARDVIEW\r\n" +
//						"      ORDER BY P_ROWNUM DESC";
//			//게시판 추천순 정렬 쿼리
//			} else if(likeClick.equals("true")) {
//				sql = "SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,\r\n"  +
//						"      P_REGDATE, P_LIKE FROM BOARDVIEW\r\n" +
//						"      ORDER BY P_LIKE DESC";
//			}
//		}
//
//		if(searchTag != null) {
//			sql2 = "SELECT COUNT(P_ROWNUM) FROM BOARDVIEW\r\n" +
//					"WHERE T_NAMELIST LIKE '%"+searchTag+"%'";
//		} else {
//			sql2 = "SELECT COUNT(P_ROWNUM) FROM BOARDVIEW";
//		}
//
//		ArrayList<PopDTO> popList = new ArrayList<PopDTO>();
//
//		try {
//			con = getConnection();
//			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			pageSet = stmt.executeQuery(sql2);
//
//			if(pageSet.next()) {
//				dbCount = pageSet.getInt(1);
//				pageSet.close();
//			}
//
//			if(dbCount % PopDTO.pageSize == 0) {
//				PopDTO.pageCount = dbCount / PopDTO.pageSize;
//			} else {
//				PopDTO.pageCount = dbCount / PopDTO.pageSize + 1;
//			}
//
//			if(pageNumber != null) {
//				PopDTO.pageNum = Integer.parseInt(pageNumber);
//				absoultePage = (PopDTO.pageNum -1) * PopDTO.pageSize +1;
//			}
//
//			rs = stmt.executeQuery(sql);
//			if(rs.next()) {
//				rs.absolute(absoultePage);
//				int count = 0;
//
//				while (count<PopDTO.pageSize) {
//					PopDTO  pop = new PopDTO();
//
//					pop.setPlanRownum(rs.getInt(1));
//					pop.setPlanTitle(rs.getString(2));
//					pop.setTagNamelist(rs.getString(3));
//					pop.setPlanRegdate(rs.getTimestamp(4));
//					pop.setPlanLike(rs.getInt(5));
//
//					popList.add(pop);
//
//					if(rs.isLast()) {
//						break;
//					} else {
//						rs.next();
//					}
//						count++;
//					}
//			}
//
//			log.info("조회 성공");
//		} catch (Exception e) {
//			log.info("조회 실패");
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs!=null) rs.close();
//				if(stmt!=null) stmt.close();
//				if(con != null) con.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

	//추천순 정렬
	public List<PopDTO> boardLike() {
		String sql = "SELECT P_ROWNUM as planRownum , P_TITLE as planTitle,\n" +
					   "\t   T_NAMELIST as tagNamelist, P_REGDATE as planRegdate,\n" +
					   "     P_LIKE as planLike FROM BOARDVIEW ORDER BY P_Like DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PopDTO.class));
	}

	//검색 쿼리
	public List<PopDTO> searchTag(String searchTag) {
		String	sql = "SELECT  P_ROWNUM as planRownum, P_TITLE as planTitle, T_NAMELIST as tagNamelist,\r\n"  +
				      "  	   P_REGDATE as planRegdate, P_LIKE as planLike FROM BOARDVIEW\r\n" +
				      "      WHERE T_NAMELIST LIKE '%"+searchTag+"%' ORDER BY P_ROWNUM DESC";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PopDTO.class));
	}

	/**
	 * 인기플랜공유 페이지 내 상단부 TOP3 목록 출력하는 메서드
	 * @return 쿼리 결과값을 PopDTO에 넣고 ArrayList배열에 담아 리턴
	 */
	public List<PopDTO> popTop1() {

			//전체 인기순 top3
		String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
					 "\t\tp_like as planLike from alltopview limit 3";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
	}
	public List<PopDTO> popTop2() {

			//성별 남자 인기순 top3
		String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
					 "\t\tp_like as planLike from mtopview limit 3";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
	}
	public List<PopDTO> popTop3() {

			//성별 여자 인기순 top3
		String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
					 "\t\tp_like as planLike from wtopview limit 3";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
	}
	public List<PopDTO> popTop4() {

			//20대 인기순 top3
		String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
					 "\t\tp_like as planLike from topView20 limit 3";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
	}
	public List<PopDTO> popTop5() {

			//30대 인기순 top3
		String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
					 "\t\tp_like as planLike from topView30 limit 3";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
	}
	public List<PopDTO> popTop6() {

			//40대 인기순 top3
		String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
					 "\t\tp_like as planLike from topView40 limit 3";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
	}
	public List<PopDTO> popTop7() {

			//50대 인기순 top3
		String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
					 "\t\tp_like as planLike from topView50 limit 3";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
	}

	/**
	 * 페이지 중간부분 인기 태그 출력하는 메서드
	 * @return 쿼리 결과값을 PopDTO에 넣고 List배열에 담아 리턴
	 */
	public List<PopDTO> popTag() {

		String sql ="SELECT T.T_NAME as tagName, T.T_HIT as tagHit\n" +
					" FROM (SELECT * FROM TAGLIST ORDER BY T_HIT DESC) T limit 5;";

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<PopDTO>(PopDTO.class));

	}
}