package org.ga2.buna.controller.index;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.index.DdayCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@Slf4j
public class HomeController {

    private final DdayCheck ddayCheck;

    @RequestMapping("/")
    public String home(HttpSession session, Model model) {
        String nick = (String) session.getAttribute("nick_s");
        model.addAttribute("str", ddayCheck.getDday(nick));
        return "Index";
    }
}
