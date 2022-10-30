package org.ga2.buna.controller.index;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.index.DdayCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 메인페이지 Controller
 */
@Controller
@AllArgsConstructor
@Slf4j
public class HomeController {

    //D-day 출력 서비스 계층 필드
    private final DdayCheck ddayCheck;

    /**
     * 메인페이지에 보낼 D-day 출력 및 세션값 model로 출력
     *
     * @param session 오프닝 애니메이션 제어용 nick value
     * @param model   세션의 닉네임 출력용
     * @return 메인페이지로 이동
     */
    @RequestMapping("/")
    public String home(HttpSession session, Model model) {
        String nick = (String) session.getAttribute("nick_s");
        if (nick != null) {
            model.addAttribute("str", ddayCheck.getDday(nick));
            model.addAttribute("nick", nick);
        }
        return "Index";
    }

    /**
     * 로그인 페이지로 이동
     *
     * @return 로그인 페이지로 이동
     */
    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    /**
     * 로그아웃
     *
     * @param session 세션 제거
     * @return 메인페이지로 이동
     */
    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        String nick = (String) session.getAttribute("nick_s");
        log.info(nick + "님이 로그아웃했습니다");
        session.invalidate();
        return "redirect:/";
    }

    /**
     * 회원가입 페이지로 이동
     *
     * @return 회원가입 페이지로 이동
     */
    @RequestMapping("/signup")
    public String signUp() {
        return "SignUp";
    }
}
