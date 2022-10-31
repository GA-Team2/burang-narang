package org.ga2.buna.controller.editplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.service.editplan.EditInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/detail")
@Slf4j
public class EditPlanRestController {
    private final EditInfo editInfo;

    /*
     * 장소 종류 받아와 spotList에 띄울 데이터 보내는 메서드
     *
     * @param kindOfSpot 장소 종류
     * @return 장소 데이터 리스트
     * */

    @GetMapping(value = "/spot")
    public List<SpotDTO> getSpotList(String kindOfSpot) {
        return spotData.findAll(kindOfSpot);
    }

    /*
     * DB에 저장할 플랜 인포 받아오는 메서드
     *
     * @param planInfoDTO 플랜 인포 객체
     * */
    @RequestMapping(value = "/planinfo", method = {RequestMethod.POST})
    public void getFormData(@RequestBody PlanInfoDTO planInfoDTO) {
        log.debug("title={}, firstDate={}, lastDate={}, tagList={}"
                , planInfoDTO.getPlanTitle()
                , planInfoDTO.getPlanFirstDate()
                , planInfoDTO.getPlanLastDate()
                , planInfoDTO.getTagNameList());

        editInfo.update(planInfoDTO);
    }

    /*
     * DB에 저장할 플랜 디테일 받아오는 메서드
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     * @return created === 200 게시물 번호 반환
     * */
    @RequestMapping(value = "/plandetail", method = {RequestMethod.POST})
    public Integer getFormData(@RequestBody List<PlanDetailDTO> planDetailDTOList) {
        log.debug("tripday={}, tripdate={}, spotname={}, spotnumber={}"
                , planDetailDTOList.get(0).getPlanTripDay()
                , planDetailDTOList.get(0).getPlanTripDate()
                , planDetailDTOList.get(0).getPlanSpotName()
                , planDetailDTOList.get(0).getSpotSerialNumber());

        return 1;
    }
}
