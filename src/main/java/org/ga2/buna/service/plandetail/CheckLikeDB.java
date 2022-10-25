package org.ga2.buna.service.plandetail;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface CheckLikeDB {
    int getDB(String nick, int rownum);
}
