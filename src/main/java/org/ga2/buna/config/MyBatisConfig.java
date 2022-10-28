package org.ga2.buna.config;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.dDay.DdayDAO;
import org.ga2.buna.dao.dDay.DdayMapper;
import org.ga2.buna.dao.dateCheck.DateCheckDAO;
import org.ga2.buna.dao.dateCheck.DateCheckMapper;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dao.planboard.PopMapper;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dao.plandetail.PlanDetailMapper;
import org.ga2.buna.dao.tag.TagMapper;
import org.ga2.buna.dao.tag.TagDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MyBatisConfig {

    private final TagMapper tagMapper;
    private final PlanDetailMapper planDetailMapper;
    private final PopMapper popMapper;
    private final DateCheckMapper dateCheckMapper;
    private final DdayMapper ddayMapper;

    @Bean
    public TagDao tagDao() {
        return new TagDao(tagMapper);
    }

    @Bean
    public PlanDetailDAO planDetailDAO() {
        return new PlanDetailDAO(planDetailMapper);
    }

    @Bean
    public PopDAO popDAO() {
        return new PopDAO(popMapper);
    }

    @Bean
    public DateCheckDAO dateCheckDAO() {
        return new DateCheckDAO(dateCheckMapper);
    }

    @Bean
    public DdayDAO ddayDAO() {
        return new DdayDAO(ddayMapper);
    }
}
