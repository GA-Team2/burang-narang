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
 * Popularity 페이지에 select해주는 클래스
 *
 * @author 강승구
 */
@Slf4j
@Repository

public class PopDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 전체 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     * 
     * @return select된 객체 리스트
     */
    public List<PopDTO> topTotal() {

        String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
                "\t\tp_like as planLike from alltopview limit 3";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }

    
    /**
     * 남자가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> topMan() {

        String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
                "\t\tp_like as planLike from mtopview limit 3";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }


    /**
     * 여자가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> topWoman() {

        String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
                "\t\tp_like as planLike from wtopview limit 3";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }


    /**
     * ~20대가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top20() {

        String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
                "\t\tp_like as planLike from topView20 limit 3";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }


    /**
     * 30대가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top30() {

        String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
                "\t\tp_like as planLike from topView30 limit 3";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }


    /**
     * 40대가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top40() {

        String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
                "\t\tp_like as planLike from topView40 limit 3";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }


    /**
     * 50대~ 가 작성한 플랜 중 추천이 제일 많은 플랜 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> top50() {

        String sql = "select p_title as PlanTitle, t_namelist as tagNamelist,\n" +
                "\t\tp_like as planLike from topView50 limit 3";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }


    /**
     * 인기 해시태그 리스트 메서드
     *
     * @return select된 객체 리스트
     */
    public List<PopDTO> popTag() {

        String sql = "SELECT T.T_NAME as tagName, T.T_HIT as tagHit\n" +
                " FROM (SELECT * FROM TAGLIST ORDER BY T_HIT DESC) T limit 5;";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PopDTO>(PopDTO.class));
    }


    /**
     * 해시태그 서치 리스트 메서드
     *
     * @param searchTag 서치된 해시태그
     * @param startNum  페이지 번호
     * @return select된 객체 리스트
     */
    public List<PopDTO> searchTag(String searchTag, int startNum) {
        String sql = "SELECT  P_ROWNUM as planRownum, P_TITLE as planTitle, T_NAMELIST as tagNamelist,\r\n" +
                "  	   P_REGDATE as planRegdate, P_LIKE as planLike FROM BOARDVIEW\r\n" +
                "      WHERE T_NAMELIST LIKE '%" + searchTag + "%' ORDER BY P_ROWNUM DESC LIMIT " + startNum + "," + (startNum + 10) + "";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PopDTO.class));
    }


    /**
     * 인기플랜공유 페이지 내 게시판 리스트 출력하는 메서드
     *
     * @param startNum 페이지 번호
     * @return select된 객체 리스트
     */
    public List<PopDTO> popBoard(int startNum) {
        String sql = "SELECT P_ROWNUM as planRownum , P_TITLE as planTitle,\n" +
                "\t   T_NAMELIST as tagNamelist, P_REGDATE as planRegdate,\n" +
                "     P_LIKE as planLike FROM BOARDVIEW ORDER BY P_ROWNUM DESC LIMIT " + startNum + "," + (startNum + 10) + "";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PopDTO.class));
    }


    /**
     * 추천순으로 정렬하는 메서드
     *
     * @param startNum 페이지 번호
     * @return select된 객체 리스트
     */
    public List<PopDTO> likeBoard(int startNum) {
        String sql = "SELECT P_ROWNUM as planRownum , P_TITLE as planTitle,\n" +
                "\t   T_NAMELIST as tagNamelist, P_REGDATE as planRegdate,\n" +
                "     P_LIKE as planLike FROM BOARDVIEW ORDER BY P_Like DESC LIMIT " + startNum + "," + (startNum + 10) + "";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PopDTO.class));
    }


    /**
     * 총 게시물 개수 구하는 메서드
     *
     * @return 총 게시물 개수
     */
    public Integer countBoard() {
        String sql = "SELECT COUNT(P_ROWNUM) FROM BOARDVIEW";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    /**
     * 서치된 게시물 개수 구하는 메서드
     *
     * @return 게시물 개수
     */
    public Integer countSerchBoard(String searchTag) {
        String sql = "SELECT COUNT(P_ROWNUM) FROM BOARDVIEW\r\n" +
                "WHERE T_NAMELIST LIKE '%" + searchTag + "%'";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}