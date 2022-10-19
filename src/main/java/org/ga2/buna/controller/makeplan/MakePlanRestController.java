package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.dto.tag.TagDto;
import org.ga2.buna.service.makeplan.InitAllMapImpl;
import org.ga2.buna.service.makeplan.SpotList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanRestController {
    private final InitAllMapImpl initAllMap;
    private final SpotList spotMap;

    @GetMapping(value = "/1")
    public List<TagDto> ajaxTest() throws Exception {
        return initAllMap.get();
    }
    @GetMapping(value = "/spot")
    public List<?> getTraffic(String spot) throws Exception {
        return spotMap.getSpot(spot);
    }
}
