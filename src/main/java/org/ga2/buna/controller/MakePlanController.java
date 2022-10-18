package org.ga2.buna.controller;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.InitAllMapImpl;
import org.ga2.buna.service.PopularTag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanController {
    private final PopularTag popularTag;
    private final InitAllMapImpl initAllMap;

    @GetMapping
    public String popularTagList(Model model) {
        model.addAttribute("list", popularTag.findAll());

        return "MakePlan";
    }

    @GetMapping(value = "/1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String ajaxTest() throws Exception {
        return initAllMap.get();
    }
}
