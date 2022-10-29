package org.ga2.buna.service.login;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.login.LoginRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginImpl implements Login {

    private final LoginRepository loginRepository;

    @Override
    public String Login(String nick, String pwd) {
        String memberNick = "";
        String memberPwd = "";
        String check = "";

        if (loginRepository.userCheck(nick).size() != 0){
            memberNick = loginRepository.userCheck(nick).get(0).getMemberNickname();
            memberPwd = loginRepository.userCheck(nick).get(0).getMemberPassword();
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
