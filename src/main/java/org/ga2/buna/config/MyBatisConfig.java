package org.ga2.buna.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dao.plandetail.PlanDetailMapper;
import org.ga2.buna.dao.tag.PopularTagMapper;
import org.ga2.buna.dao.tag.TagDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MyBatisConfig {

    private final PopularTagMapper popularTagMapper;
    private final PlanDetailMapper planDetailMapper;

    @Bean
    public TagDao tagDao() {
        return new TagDao(popularTagMapper);
    }

    @Bean
    public PlanDetailDAO planDetailDAO() {
        return new PlanDetailDAO(planDetailMapper);
    }
}