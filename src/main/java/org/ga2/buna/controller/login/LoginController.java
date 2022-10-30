package org.ga2.buna.controller.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 로그인 성공 case Controller
 */
@Controller
@AllArgsConstructor
@RequestMapping("/login")
@Slf4j
public class LoginController {

    /**
     * 로그인 성공 시 닉네임 세션에 저장 및 메인페이지로 이동
     *
     * @param session 닉네임 세션에 저장
     * @param request form으로부터 받아온 회원 닉네임
     * @return 메인페이지로 리턴
     */
    @RequestMapping("/ok")
    public String loginOk(HttpSession session, HttpServletRequest request) {

        String nick = request.getParameter("memberNickname");
        session.setAttribute("nick_s", nick);
        log.info("{} 님이 로그인했습니다.", nick);
        return "redirect:/";
    }
}
