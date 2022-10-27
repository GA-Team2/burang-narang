package org.ga2.buna.dao.planboard;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.planboard.PopDTO;
import org.ga2.buna.dto.tag.TagDto;

import java.util.List;

@Mapper
public interface PopMapper {
    @Select("select p_rownum as plan_rownum, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from alltopview limit 3")
    List<PopDTO> topTotal();

    @Select("select p_rownum as plan_rownum, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from mtopview limit 3")
    List<PopDTO> topMan();

    @Select("select p_rownum as plan_rownum, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from wtopview limit 3")
    List<PopDTO> topWoman();

    @Select("select p_rownum as plan_rownum, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView20 limit 3")
    List<PopDTO> top20();

    @Select("select p_rownum as plan_rownum, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView30 limit 3")
    List<PopDTO> top30();

    @Select("select p_rownum as plan_rownum, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView40 limit 3")
    List<PopDTO> top40();

    @Select("select p_rownum as plan_rownum, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView50 limit 3")
    List<PopDTO> top50();

    @Select("SELECT T.T_NAME as tag_name, T.T_HIT as tag_hit FROM" +
            " (SELECT * FROM TAGLIST ORDER BY T_HIT DESC) T limit 5")
    List<TagDto> popTag();

    @Select("SELECT  P_ROWNUM as plan_rownum, P_TITLE as plan_title, T_NAMELIST as tag_namelist," +
            "P_REGDATE as plan_regdate, P_LIKE as plan_like FROM BOARDVIEW" +
            "WHERE T_NAMELIST LIKE '%${searchTag}%' ORDER BY P_ROWNUM DESC LIMIT ${page},10")
    List<PopDTO> searchTag(String searchTag, int page);

    @Select("SELECT  P_ROWNUM as planRownum, P_TITLE as planTitle, T_NAMELIST as tagNamelist," +
            "P_REGDATE as planRegdate, P_LIKE as planLike FROM BOARDVIEW" +
            "WHERE T_NAMELIST LIKE '%${searchTag}%' ORDER BY P_ROWNUM DESC")
    List<PopDTO> searchTagAjax(String searchTag);

    @Select("SELECT P_ROWNUM as plan_rownum, P_TITLE as plan_title, T_NAMELIST as tag_namelist," +
            " P_REGDATE as plan_regdate, P_LIKE as plan_like FROM BOARDVIEW" +
            " ORDER BY P_ROWNUM DESC LIMIT ${page}, 10")
    List<PopDTO> popBoard(int page);

    @Select("SELECT P_ROWNUM as plan_rownum , P_TITLE as plan_title," +
            "T_NAMELIST as tag_namelist, P_REGDATE as plan_regdate," +
            "P_LIKE as plan_like FROM BOARDVIEW ORDER BY P_Like DESC LIMIT ${page} , 10")
    List<PopDTO> likeBoard(int page);

    @Select("SELECT COUNT(P_ROWNUM) FROM BOARDVIEW")
    Integer countBoard();

    @Select("SELECT COUNT(P_ROWNUM) FROM BOARDVIEW WHERE T_NAMELIST LIKE '%${searchTag}%'")
    Integer countSerchBoard(String searchTag);
}


