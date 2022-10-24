package org.ga2.buna.service.plandetail;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface Like {

    Integer likeInsert(HttpSession session, int rownum);
}
