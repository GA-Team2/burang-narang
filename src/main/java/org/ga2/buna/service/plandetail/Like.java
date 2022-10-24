package org.ga2.buna.service.plandetail;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface Like {

    Map<String, Object> likeInsert(HttpSession session, int rownum);
}
