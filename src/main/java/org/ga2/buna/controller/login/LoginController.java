package org.ga2.buna.controller.login;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/loginOk")
    public String login(){
        return "LoginOk";
    }
}
