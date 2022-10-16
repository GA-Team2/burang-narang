package org.ga2.buna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController implements MainController {

    @Override
    @RequestMapping("/")
    public String execute(Model model) {
        return "index";
    }
}
