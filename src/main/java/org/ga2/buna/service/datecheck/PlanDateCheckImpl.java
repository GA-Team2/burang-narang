package org.ga2.buna.service.datecheck;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.ga2.buna.dao.DateCheckDBBean;
import org.ga2.buna.dto.DateCheckBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanDateCheckImpl implements PlanDateCheck {
    private final DateCheckDBBean dateCheckDBBean;

    @Override
    public List<DateCheckBean> getDB() throws Exception {
        return dateCheckDBBean.getDate();
    }
}
