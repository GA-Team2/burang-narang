package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.makeplan.InitAllMapImpl;
import org.ga2.buna.service.makeplan.SpotMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanRestController {
    private final InitAllMapImpl initAllMap;
    private final SpotMap spotMap;

    @GetMapping(value = "/1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String ajaxTest() throws Exception {
        return initAllMap.get();
    }
    @GetMapping(value = "/spotcontainer", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTraffic(String spot) throws Exception {
        if (spot.equals("traffic")) return spotMap.getTraffic();
        else if (spot.equals("restaurant")) return spotMap.getRestaurant();
        return "no";
    }
}
