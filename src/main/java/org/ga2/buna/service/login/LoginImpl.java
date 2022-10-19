package org.ga2.buna.service.login;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.login.LoginDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class LoginImpl implements Login {

    private final LoginDAO loginDAO;

    @Override
    public ArrayList<String> Login(String nick, String pwd) {
        String memberNick = "";
        String memberPwd = "";

        if (loginDAO.userCheck(nick).size() != 0){
            memberNick = loginDAO.userCheck(nick).get(0).getMemberNickname();
            memberPwd = loginDAO.userCheck(nick).get(0).getMemberPassword();
        } else {
            memberNick = null;
            memberPwd = null;
        }
        String strNick = "";
        String strPwd = "";
        ArrayList<String> strAry = new ArrayList<>();
        if (nick == null){
            strNick = "아이디를 입력해주세요";
        }

        if (pwd == null){
            strPwd = "패스워드를 입력해주세요";
        }

        if (nick.equals(memberNick)){
            if (!pwd.equals(memberPwd)){
                strPwd = "비밀번호가 맞지않습니다.";
            }
        } else {
            strNick = "존재하지않는 닉네임입니다.";
        }

        strAry.add(strNick);
        strAry.add(strPwd);

        return strAry;
    }
}
