package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.PopularTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TagController implements MainController {
    private final PopularTag popularTag;

    @Override
    @RequestMapping("/new")
    public String execute(Model model) {
        model.addAttribute("list", popularTag.findAll());

        return "MakePlan";
    }
}
