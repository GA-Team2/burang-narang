package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.dto.tag.TagDto;
import org.ga2.buna.service.makeplan.InitAllMapImpl;
import org.ga2.buna.service.makeplan.SearchingSpotInfo;
import org.ga2.buna.service.makeplan.SpotData;
import org.ga2.buna.service.spot.Spot;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/new")
@Slf4j
public class MakePlanRestController {
    private final InitAllMapImpl initAllMap;
    private final SpotData spotData;
    private final SearchingSpotInfo searchingSpotInfo;

    @GetMapping(value = "/1")
    public List<TagDto> ajaxTest() throws Exception {
        return initAllMap.get();
    }
    @GetMapping(value = "/spot")
    public List<Spot> getSpotList(String kindOfSpot) {
        return spotData.findAll(kindOfSpot);
    }

    @GetMapping(value = "/search")
    public List<Spot> searchSpotList(String spotName) {
        return spotData.findBySpotName(spotName);
    }

    @GetMapping("/marker")
    public SearchInfoDTO searchSpotInfo(String sname, String snum) {
        log.debug("sname={}, snum={}", sname, snum);
        return searchingSpotInfo.getInfo(sname, snum);
    }

    @RequestMapping(value = "/planinfo", method = { RequestMethod.POST })
    public void getFormData(@RequestBody PlanInfoDTO planInfoDTO) {
        System.out.println("paln title: " + planInfoDTO.getPlanTitle());
        System.out.println("nick: " + planInfoDTO.getMemberNickName());
        System.out.println("First Date: " + planInfoDTO.getPlanFirstDate());
        System.out.println("Last Date: " + planInfoDTO.getPlanLastDate());
        System.out.println("Tag : " + planInfoDTO.getTagNameList());
        System.out.println("public : " + planInfoDTO.getPlanPublic());
    }

    @RequestMapping(value = "/plandetail", method = { RequestMethod.POST })
    public void getFormData(@RequestBody List<PlanDetailDTO> planDetailDTOList) {
        System.out.println("planDetailDTO : " + planDetailDTOList.get(0));
    }
}
