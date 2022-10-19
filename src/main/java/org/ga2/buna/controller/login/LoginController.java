package org.ga2.buna.controller.login;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.login.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class LoginController {

    private Login login;

    @RequestMapping("/Login")
    public String login() {
        return "Login";
    }

    @RequestMapping("/loginOk")
    public String loginOk(HttpSession session, HttpServletRequest request, Model model) {

        String nick = (String) request.getParameter("memberNickname");
        String pwd = (String) request.getParameter("memberPassword");

        ArrayList<String> ary = login.Login(nick, pwd);

        String nickWarn = ary.get(0);
        String pwdWarn = ary.get(1);

        if (ary.get(0) == null && ary.get(1) == null){
            session.setAttribute("nick_s", nick);
            return "redirect:Index";
        } else {
            model.addAttribute("nickWarn", nickWarn);
            model.addAttribute("pwdWarn", pwdWarn);
            return "redirect:Login";
        }
    }

}
