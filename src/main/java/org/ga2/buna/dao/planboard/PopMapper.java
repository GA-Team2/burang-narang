package org.ga2.buna.dao.planboard;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.dto.tag.TagDto;

import java.util.List;

@Mapper
public interface PopMapper {
    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from alltopview limit 3")
    List<PlanInfoDTO> topTotal();
    //TOP3 전체

    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from mtopview limit 3")
    List<PlanInfoDTO> topMan();
    //TOP3 남자

    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from wtopview limit 3")
    List<PlanInfoDTO> topWoman();
    //TOP3 여자

    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topview20 limit 3")
    List<PlanInfoDTO> top20();
    //TOP3 20대

    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topview30 limit 3")
    List<PlanInfoDTO> top30();
    //TOP3 30대

    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topview40 limit 3")
    List<PlanInfoDTO> top40();
    //TOP3 40대

    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title," +
            " t_namelist as tag_namelist, p_like as plan_like from topview50 limit 3")
    List<PlanInfoDTO> top50();
    //TOP3 50대

    @Select("select t.t_name as tag_name, t.t_hit as tag_hit from" +
            " (select * from taglist order by t_hit desc) t limit 10")
    List<TagDto> popTag();
    //인기순 해시태그 리스트

    @Select("select  p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title, t_namelist as tag_namelist," +
            "p_regdate as plan_registerdate, p_like as plan_like from boardview" +
            " where t_namelist like concat('%',#{searchtag},'%') order by p_rownum desc limit #{page},10")
    List<PlanInfoDTO> searchTag(String searchTag, int page);
    //태그 검색했을때 리스트

    @Select("select  p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title, t_namelist as tag_namelist," +
            "p_regdate as plan_registerdate, p_like as plan_like from boardview" +
            " where t_namelist like concat('%',#{searchtag},'%') order by p_rownum desc")
    List<PlanInfoDTO> searchTagAjax(String searchTag);
    //태그 검색했을때 리스트(비동기)

    @Select("select  p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title, t_namelist as tag_namelist," +
            "p_regdate as plan_registerdate, p_like as plan_like from boardview" +
            " where m_nickname like concat('%',#{nick},'%') order by p_rownum desc")
    List<PlanInfoDTO> searchNickAjax(String nick);
    //태그 검색했을때 리스트(비동기)

    @Select("select p_rownum as plan_rownumber, m_nickname as member_nick_name, p_title as plan_title, t_namelist as tag_namelist," +
            " p_regdate as plan_registerdate, p_like as plan_like from boardview" +
            " order by p_rownum desc limit #{page}, 10")
    List<PlanInfoDTO> popBoard(int page);
    //게시판 리스트

    @Select("select p_rownum as plan_rownumber,m_nickname as member_nick_name, p_title as plan_title," +
            "t_namelist as tag_namelist, p_regdate as plan_registerdate," +
            "p_like as plan_like from boardview order by p_like desc limit #{page} , 10")
    List<PlanInfoDTO> likeBoard(int page);
    //추천순 정렬 게시판 리스트

    @Select("select count(p_rownum) from boardview")
    Integer countBoard();
    //총 게시물 개수 

    @Select("select count(p_rownum) from boardview where t_namelist like concat('%',#{searchtag},'%')")
    Integer countSerchBoard(String searchTag);
    //태그 검색했을때 해당 태그의 게시물 개수
}


