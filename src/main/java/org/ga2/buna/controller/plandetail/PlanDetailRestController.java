package org.ga2.buna.controller.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.service.makeplan.SearchingSpotInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detail")
@Slf4j
public class PlanDetailRestController {
    private final SearchingSpotInfo searchingSpotInfo;

    @GetMapping(value = "/all")
    public List<SearchInfoDTO> searchSpotInfo(int rownum) {
        log.debug("rownum={}", rownum);
        return searchingSpotInfo.getInfo(rownum);
    }
}
