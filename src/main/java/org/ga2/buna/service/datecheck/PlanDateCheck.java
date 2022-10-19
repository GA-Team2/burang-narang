package org.ga2.buna.service.datecheck;

import org.ga2.buna.dto.DateCheckBean;

import java.util.List;

public interface PlanDateCheck {
    public List<DateCheckBean> getDB() throws Exception;
}
