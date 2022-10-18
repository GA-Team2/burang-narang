package org.ga2.buna.service.datecheck;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.ga2.buna.dao.DateCheckDBBean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanDateCheckImpl implements PlanDateCheck {
    private final DateCheckDBBean dateCheckDBBean;
    private final ObjectMapper mapper;

    @Override
    public String getDB() throws Exception {
        return mapper.writeValueAsString(dateCheckDBBean.getDate());
    }
}
