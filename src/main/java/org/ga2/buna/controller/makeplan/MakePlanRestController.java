package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.makeplan.InitAllMapImpl;
import org.ga2.buna.service.makeplan.SpotDataList;
import org.ga2.buna.service.spot.Spot;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanRestController {
    private final InitAllMapImpl initAllMap;
    private final SpotDataList spotDataList;

    @GetMapping(value = "/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ajaxTest() throws Exception {
        return initAllMap.get();
    }
    @GetMapping(value = "/spot")
    public List<Spot> loadSpotDataList(String spot) throws Exception {
        return spotDataList.findAll(spot);
    }
}
