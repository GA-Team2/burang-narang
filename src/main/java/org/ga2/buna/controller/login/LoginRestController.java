package org.ga2.buna.controller.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.login.Login;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginRestController {
    private final Login login;

    @RequestMapping("/loginCheck")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> loginOk(@RequestBody String nick) throws Exception{
        log.debug(nick);
        return login.Login(nick);
    }
}
