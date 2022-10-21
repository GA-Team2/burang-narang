package org.ga2.buna.controller.login;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.login.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class LoginController {

    private Login login;

    @RequestMapping(value = "/login")
    public String login() {
        return "Login";
    }

    @RequestMapping(value = "/loginOk")
    public String loginOk(HttpSession session, HttpServletRequest request, Model model) {

        String nick = (String) request.getParameter("memberNickname");
        session.setAttribute("nick_s", nick);

        return "redirect:/";
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
