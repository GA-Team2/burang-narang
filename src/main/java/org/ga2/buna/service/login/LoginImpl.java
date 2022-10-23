package org.ga2.buna.service.login;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.login.LoginDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LoginImpl implements Login {

    private final LoginDAO loginDAO;

    @Override
    public String Login(String nick, String pwd) {
        String memberNick = "";
        String memberPwd = "";
        String check = "";

        if (loginDAO.userCheck(nick).size() != 0){
            memberNick = loginDAO.userCheck(nick).get(0).getMemberNickname();
            memberPwd = loginDAO.userCheck(nick).get(0).getMemberPassword();
        } else {
            memberNick = null;
            memberPwd = null;
        }

        if (!nick.equals(memberNick)) {
            check = "NEN";
        } else if(!pwd.equals(memberPwd)) {
            check = "ICP";
        } else {
            check = "OK";
        }
        return check;
    }
}
