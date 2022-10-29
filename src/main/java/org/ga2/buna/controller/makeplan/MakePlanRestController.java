package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.service.makeplan.SpotData;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.service.makeplan.*;
import org.ga2.buna.service.spot.Spot;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/new")
@Slf4j
public class MakePlanRestController {
    private final SpotData spotData;
    private final SavePlanInfo savePlanInfo;
    private final SavePlanDetail savePlanDetail;
    private final SaveTagList saveTagList;

    private final PlanInfoRepository planInfoRepository;

    /*
    * 장소 종류 받아와 spotList에 띄울 데이터 보내는 메서드
    *
    * @param kindOfSpot 장소 종류
    * @return 장소 데이터 리스트
    * */

    @GetMapping(value = "/spot")
    public List<Spot> getSpotList(String kindOfSpot) {
        return spotData.findAll(kindOfSpot);
    }

    /*
     * 장소 이름 검색 시 spotList에 띄울 데이터 보내는 메서드
     *
     * @param spotName 장소 이름
     * @return 장소 데이터 리스트
     * */
    @GetMapping(value = "/search")
    public List<Spot> searchSpotList(String spotName) {
        return spotData.findBySpotName(spotName);
    }

    /*
     * DB에 저장할 플랜 인포 받아오는 메서드
     *
     * @param planInfoDTO 플랜 인포 객체
     * */
    @RequestMapping(value = "/planinfo", method = { RequestMethod.POST })
    public void getFormData(@RequestBody PlanInfoDTO planInfoDTO) {
        log.info("title={}, firstDate={}, lastDate={}, tagList={}"
                , planInfoDTO.getPlanTitle()
                , planInfoDTO.getPlanFirstDate()
                , planInfoDTO.getPlanLastDate()
                , planInfoDTO.getTagNameList());

        savePlanInfo.save(planInfoDTO, planInfoRepository.maxByRowNumber() + 1);
        saveTagList.saveAll(planInfoDTO.getTagNameList());
    }

    /*
     * DB에 저장할 플랜 디테일 받아오는 메서드
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     * @return created === 200 게시물 번호 반환
     * */
    @RequestMapping(value = "/plandetail", method = { RequestMethod.POST })
    public int getFormData(@RequestBody List<PlanDetailDTO> planDetailDTOList) {
        log.info("tripday={}, tripdate={}, spotname={}, spotnumber={}"
                    , planDetailDTOList.get(0).getPlanTripDay()
                    , planDetailDTOList.get(0).getPlanTripDate()
                    , planDetailDTOList.get(0).getPlanSpotName()
                    , planDetailDTOList.get(0).getSpotSerialNumber());

        savePlanDetail.saveAll(planDetailDTOList);

        return planInfoRepository.maxByRowNumber();
    }
}
