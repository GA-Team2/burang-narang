package org.ga2.buna.service.mypage;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface DeleteMemberInfo {
    void deleteMember(String nick);
    int checkpw(Map<String, Object> map);
}
