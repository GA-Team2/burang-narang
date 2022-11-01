package org.ga2.buna.dao.planinfo;

import org.apache.ibatis.annotations.*;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;

import java.util.List;

@Mapper
public interface PlanInfoMapper {

    /*
     * 마이페이지 내 플랜 목록 얻어오는 메서드 -최신순 정렬
     *
     * @param memberNickName : 닉네임에 해당하는 planinfo테이블의 플랜 목록 모두 조회
     * @return PlanInfoDTO 객체를 담은 ArrayList를 리턴
     */
    @Select("SELECT P_ROWNUM as plan_rownumber, M_NICKNAME as member_nickname, P_TITLE as plan_title, " +
            "P_FIRSTDATE as plan_firstdate, P_LASTDATE as plan_lastdate, T_NAMELIST as tag_namelist, " +
            "P_LIKE as plan_like, P_PUBLIC as plan_public " +
            "FROM planinfo " +
            "WHERE M_NICKNAME = #{memberNickName} " +
            "ORDER BY P_FIRSTDATE DESC")
    List<PlanInfoDTO> getPlanInfo(String memberNickName);

    /*
     * 해당 게시물 번호를 가지는 플랜 인포 데이터 삭제하는 메서드
     */
    @Delete("DELETE FROM planinfo WHERE P_ROWNUM = #{planRowNum}")
    void deletePlan(int planRowNum);

    /*
     * 플랜 공개/비공개 업데이트 메서드
     *
     * @param planRownum : 플랜 번호
     * @param planPublic : 공개 여부 체크 / 0-비공개, 1-공개
     * @param n          : 비공개=-1 / 공개=1
     * @return
     */
    @Update("UPDATE planinfo SET P_PUBLIC = #{n} WHERE P_ROWNUM = #{planRownum} AND P_PUBLIC = #{planPublic} ")
    void publicUpdateInfo(@Param("planRownum") int planRownum, @Param("planPublic") int planPublic, @Param("n") int n);

    /*
     * 플랜 Info 저장하는 메서드
     */
    @Insert("INSERT INTO planinfo " +
            "VALUES(#{rowNumber}, " +
            "#{planInfoDTO.memberNickName}, " +
            "#{planInfoDTO.planTitle}, " +
            "#{planInfoDTO.planFirstDate}, " +
            "#{planInfoDTO.planLastDate}, " +
            "#{planInfoDTO.tagNameList}, " +
            "now(), 0, " +
            "#{planInfoDTO.planPublic})")
    void insert(@Param("planInfoDTO") PlanInfoDTO planInfoDTO, @Param("rowNumber") int rowNumber);

    /*
     * 게시물 번호의 최댓값 반환하는 메서드
     */
    @Select("SELECT ifnull(MAX(P_ROWNUM), 0) FROM planinfo")
    Integer maxByRowNumber();

    /*
     * 해당하는 게시물 번호를 가지는 플랜 Info 객체 반환하는 메서드
     */
    @Select("SELECT P_TITLE as plan_title, " +
            "P_FIRSTDATE as plan_first_date, " +
            "P_LASTDATE as plan_last_date, " +
            "T_NAMELIST as tag_name_list " +
            "FROM planinfo WHERE P_ROWNUM = #{rowNumber}")
    PlanInfoDTO selectByRowNumber(int rowNumber);

    /*
     * 해당하는 플랜 Info를 수정하는 메서드
     */
    @Update("UPDATE planinfo SET P_TITLE = #{planTitle}, " +
            "P_FIRSTDATE = #{planFirstDate}, " +
            "P_LASTDATE = #{planLastDate}, " +
            "T_NAMELIST = #{tagNameList}, " +
            "P_PUBLIC = #{planPublic} " +
            "WHERE P_ROWNUM = #{planRowNumber}")
    void update(PlanInfoDTO planInfoDTO);
}
