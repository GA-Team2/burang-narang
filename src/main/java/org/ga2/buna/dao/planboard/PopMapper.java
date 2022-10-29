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
            " t_namelist as tag_namelist, p_like as plan_like from topview20 limit 3")
    List<PlanInfoDTO> top20();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topview30 limit 3")
    List<PlanInfoDTO> top30();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topview40 limit 3")
    List<PlanInfoDTO> top40();

    @Select("select p_rownum as plan_rownumber, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topview50 limit 3")
    List<PlanInfoDTO> top50();

    @Select("select t.t_name as tag_name, t.t_hit as tag_hit from" +
            " (select * from taglist order by t_hit desc) t limit 5")
    List<TagDto> popTag();

    @Select("select  p_rownum as plan_rownumber, p_title as plan_title, t_namelist as tag_namelist," +
            "p_regdate as plan_registerdate, p_like as plan_like from boardview" +
            " where t_namelist like concat('%',#{searchtag},'%') order by p_rownum desc limit #{page},10")
    List<PlanInfoDTO> searchTag(String searchTag, int page);

    @Select("select  p_rownum as plan_rownumber, p_title as plan_title, t_namelist as tag_namelist," +
            "p_regdate as plan_registerdate, p_like as plan_like from boardview" +
            " where t_namelist like concat('%',#{searchtag},'%') order by p_rownum desc")
    List<PlanInfoDTO> searchTagAjax(String searchTag);

    @Select("select p_rownum as plan_rownumber, p_title as plan_title, t_namelist as tag_namelist," +
            " p_regdate as plan_registerdate, p_like as plan_like from boardview" +
            " order by p_rownum desc limit #{page}, 10")
    List<PlanInfoDTO> popBoard(int page);

    @Select("select p_rownum as plan_rownumber , p_title as plan_title," +
            "t_namelist as tag_namelist, p_regdate as plan_registerdate," +
            "p_like as plan_like from boardview order by p_like desc limit #{page} , 10")
    List<PlanInfoDTO> likeBoard(int page);

    @Select("select count(p_rownum) from boardview")
    Integer countBoard();

    @Select("select count(p_rownum) from boardview where t_namelist like concat('%',#{searchtag},'%')")
    Integer countSerchBoard(String searchTag);
}


