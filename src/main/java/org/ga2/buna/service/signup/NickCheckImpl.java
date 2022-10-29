package org.ga2.buna.service.signup;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.signup.SignUpRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NickCheckImpl implements NickCheck {

    private SignUpRepository dao;

    @Override
    public String nickCheck(String nick) {
        if(dao.confirmID(nick).size() != 0) {
            return "exist";
        } else {
            return "available";
        }
    }
}
