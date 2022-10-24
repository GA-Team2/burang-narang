package org.ga2.buna.controller.signup;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.signup.NickCheck;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class SignUpRestController {
    private final NickCheck nickCheck;
    @RequestMapping("signup/check")
    @ResponseStatus(HttpStatus.CREATED)
    public String nickCheck(@RequestBody String nick) {
        String str = nickCheck.nickCheck(nick);
        return str;
    }
}
