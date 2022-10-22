package org.ga2.buna.controller.signup;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@AllArgsConstructor
public class SignUpController {

    @RequestMapping
    public String signUp(){
        return "SignUp";
    }
}
