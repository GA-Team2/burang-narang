package org.ga2.buna.dao.planboard;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.dto.tag.TagDto;

import java.util.List;

@Mapper
public interface PopMapper {
    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from alltopview limit 3")
    List<PlanInfoDTO> topTotal();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from mtopview limit 3")
    List<PlanInfoDTO> topMan();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from wtopview limit 3")
    List<PlanInfoDTO> topWoman();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView20 limit 3")
    List<PlanInfoDTO> top20();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView30 limit 3")
    List<PlanInfoDTO> top30();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView40 limit 3")
    List<PlanInfoDTO> top40();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topView50 limit 3")
    List<PlanInfoDTO> top50();

    @Select("SELECT T.T_NAME as tag_name, T.T_HIT as tag_hit FROM" +
            " (SELECT * FROM TAGLIST ORDER BY T_HIT DESC) T limit 5")
    List<TagDto> popTag();

    @Select("SELECT  P_ROWNUM as plan_rownumber, P_TITLE as plan_title, T_NAMELIST as tag_namelist," +
            "P_REGDATE as plan_registerdate, P_LIKE as plan_like FROM BOARDVIEW" +
            " WHERE T_NAMELIST like CONCAT('%',#{searchTag},'%') ORDER BY P_ROWNUM DESC LIMIT #{page},10")
    List<PlanInfoDTO> searchTag(String searchTag, int page);

    @Select("SELECT  P_ROWNUM as plan_rownumber, P_TITLE as plan_title, T_NAMELIST as tag_namelist," +
            "P_REGDATE as plan_registerdate, P_LIKE as plan_like FROM BOARDVIEW" +
            " WHERE T_NAMELIST like CONCAT('%',#{searchTag},'%') ORDER BY P_ROWNUM DESC")
    List<PlanInfoDTO> searchTagAjax(String searchTag);

    @Select("SELECT P_ROWNUM as plan_rownumber, P_TITLE as plan_title, T_NAMELIST as tag_namelist," +
            " P_REGDATE as plan_registerdate, P_LIKE as plan_like FROM BOARDVIEW" +
            " ORDER BY P_ROWNUM DESC LIMIT #{page}, 10")
    List<PlanInfoDTO> popBoard(int page);

    @Select("SELECT P_ROWNUM as plan_rownumber , P_TITLE as plan_title," +
            "T_NAMELIST as tag_namelist, P_REGDATE as plan_registerdate," +
            "P_LIKE as plan_like FROM BOARDVIEW ORDER BY P_Like DESC LIMIT #{page} , 10")
    List<PlanInfoDTO> likeBoard(int page);

    @Select("SELECT COUNT(P_ROWNUM) FROM BOARDVIEW")
    Integer countBoard();

    @Select("SELECT COUNT(P_ROWNUM) FROM BOARDVIEW WHERE T_NAMELIST like CONCAT('%',#{searchTag},'%')")
    Integer countSerchBoard(String searchTag);
}


