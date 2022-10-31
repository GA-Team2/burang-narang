package org.ga2.buna.controller.editplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.service.editplan.EditDetail;
import org.ga2.buna.service.editplan.EditInfo;
import org.ga2.buna.service.editplan.EditTag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/detail")
@Slf4j
public class EditPlanRestController {
    private final EditInfo editInfo;
    private final EditTag editTag;
    private final EditDetail editDetail;


    /*
     * DB에 저장할 플랜 인포 받아오는 메서드
     *
     * @param planInfoDTO 플랜 인포 객체
     * */
    @PostMapping("/planinfo")
    public void getFormData(@RequestBody PlanInfoDTO planInfoDTO) {
        log.debug("title={}, firstDate={}, lastDate={}, tagList={}"
                , planInfoDTO.getPlanTitle()
                , planInfoDTO.getPlanFirstDate()
                , planInfoDTO.getPlanLastDate()
                , planInfoDTO.getTagNameList());

        editTag.delete(planInfoDTO);
        editTag.update(planInfoDTO);
        editInfo.update(planInfoDTO);
    }

    /*
     * DB에 저장할 플랜 디테일 받아오는 메서드
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     * @return created === 200 게시물 번호 반환
     * */
    @PostMapping("/plandetail")
    public void getFormData(@RequestBody List<PlanDetailDTO> planDetailDTOList) {
        log.debug("tripday={}, tripdate={}, spotname={}, spotnumber={}"
                , planDetailDTOList.get(0).getPlanTripDay()
                , planDetailDTOList.get(0).getPlanTripDate()
                , planDetailDTOList.get(0).getPlanSpotName()
                , planDetailDTOList.get(0).getSpotSerialNumber());

        editDetail.updateAll(planDetailDTOList);
    }
}
