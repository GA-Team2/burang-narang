package org.ga2.buna.service.mypage;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface DeleteMemberInfo {
    void deleteMember(Model model, HttpSession session);
    Integer checkpw(Model model);
}
