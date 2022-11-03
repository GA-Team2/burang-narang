package org.ga2.buna.dto.plandetail;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 디테일 페이지 출력을 위한 DTO
 * @author 장희정
 */
@Getter
@Setter
@ToString
public class PlanJoinDTO {
    private int planTripday;
    private String planTripdate;
    private String memberNickname;
    private String planTitle;
    private String tagNamelist;
    private int planLike;
    private List<PlanScheduleDTO> planScheduleDTO;
}