package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.makeplan.SpotData;
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
    private final SpotData spotData;

    @GetMapping(value = "/spot")
    public List<Spot> getSpotList(String kindOfSpot) {
        return spotData.findAll(kindOfSpot);
    }

    @GetMapping(value = "/search")
    public List<Spot> searchSpotList(String spotName) {
        return spotData.findBySpotName(spotName);
    }

}
