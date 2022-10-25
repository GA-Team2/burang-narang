package org.ga2.buna.service.plandetail;

import org.springframework.ui.Model;

import java.util.Map;

public interface PlanDetail {
    Map<String, Object> execute(int rownum, String mypage, String pop);

}
