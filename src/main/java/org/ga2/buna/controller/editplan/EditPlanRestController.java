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

/**
 * 플랜 수정 및 인기 플랜 복사 페이지
 *
 * @author 한애채
 */
@RestController
@AllArgsConstructor
@RequestMapping("/detail")
@Slf4j
public class EditPlanRestController {
    private final EditInfo editInfo;
    private final EditTag editTag;
    private final EditDetail editDetail;

    /**
     * 플랜 인포 및 태그 업데이트
     *
     * @param planInfoDTO 플랜 인포 객체
     */
    @PostMapping("/planinfo")
    public void getFormData(@RequestBody PlanInfoDTO planInfoDTO) {
        editTag.delete(planInfoDTO);
        editTag.update(planInfoDTO);
        editInfo.update(planInfoDTO);
    }

    /**
     * 플랜 디테일 업데이트
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     */
    @PostMapping("/plandetail")
    public void getFormData(@RequestBody List<PlanDetailDTO> planDetailDTOList) {
        editDetail.updateAll(planDetailDTOList);
    }
}
