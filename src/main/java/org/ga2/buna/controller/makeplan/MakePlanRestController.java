package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.dto.tag.TagDto;
import org.ga2.buna.service.makeplan.InitAllMapImpl;
import org.ga2.buna.service.makeplan.SearchingMapInfo;
import org.ga2.buna.service.makeplan.SpotDataList;
import org.ga2.buna.service.spot.Spot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/new")
@Slf4j
public class MakePlanRestController {
    private final InitAllMapImpl initAllMap;
    private final SpotDataList spotDataList;
    private final SearchingMapInfo searchingMapInfo;

    @GetMapping(value = "/1")
    public List<TagDto> ajaxTest() throws Exception {
        return initAllMap.get();
    }
    @GetMapping(value = "/spot")
    public List<Spot> getSpotList(String kindOfSpot) {
        return spotDataList.findAll(kindOfSpot);
    }

    @GetMapping(value = "/search")
    public List<Spot> searchSpotList(String spotName) {
        return spotDataList.findBySpotName(spotName);
    }

    @GetMapping("/marker")
    public SearchInfoDTO searchMapInfo(String sname, String snum) {
        log.debug("{}", sname, snum);
        return searchingMapInfo.searchInfo(sname, snum);
    }
}
