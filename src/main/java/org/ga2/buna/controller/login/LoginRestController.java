package org.ga2.buna.controller.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.login.Login;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginRestController {
    private final Login login;

    @RequestMapping("/check")
    public HttpEntity<String> loginOk(@RequestBody MemberDTO memberDTO) {
        log.debug(memberDTO.getMemberNickname());
        String check = login.Login(memberDTO.getMemberNickname(), memberDTO.getMemberPassword());
        if (check.equals("OK")) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(check, HttpStatus.OK);
        }
    }
}
