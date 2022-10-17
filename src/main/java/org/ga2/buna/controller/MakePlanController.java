package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.PopularTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MakePlanController {
    private final PopularTag popularTag;

    @GetMapping("/new")
    public String popularTagList(Model model) {
        model.addAttribute("list", popularTag.findAll());

        return "MakePlan";
    }
}
