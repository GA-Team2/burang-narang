package org.ga2.buna.controller.plandetail;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.service.plandetail.SearchingMapInfoAll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detail")
public class PlanDetailRestController {
    private final SearchingMapInfoAll searchingMapInfoAll;

    @GetMapping(value = "/all")
    public List<SearchInfoDTO> searchMapInfo(int rownum) {
        return searchingMapInfoAll.findInfoAll(rownum);
    }
}
