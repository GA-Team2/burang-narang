package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.makeplan.InitAllMapImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanRestController {
    private final InitAllMapImpl initAllMap;

//    @GetMapping(value = "/1", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String ajaxTest() throws Exception {
//        return initAllMap.get();
//    }
}
