package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.makeplan.PopularTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanController {
    private final PopularTag popularTag;

    @GetMapping
    public String popularTagList(Model model, HttpSession session) {
        model.addAttribute("list", popularTag.findAll());
        model.addAttribute("nick", session.getAttribute("nick_s"));

        return "MakePlan";
    }
}
