package org.ga2.buna.config;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.memberinfo.MemberDAO;
import org.ga2.buna.dao.memberinfo.MemberInfoMapper;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dao.plandetail.PlanDetailMapper;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.ga2.buna.dao.planinfo.PlanInfoMapper;
import org.ga2.buna.dao.tag.PopularTagMapper;
import org.ga2.buna.dao.tag.TagDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MyBatisConfig {

    private final PopularTagMapper popularTagMapper;
    private final PlanDetailMapper planDetailMapper;
    private final PlanInfoMapper planInfoMapper;
    private final MemberInfoMapper memberInfoMapper;

    @Bean
    public TagDao tagDao() {
        return new TagDao(popularTagMapper);
    }

    @Bean
    public PlanDetailDAO planDetailDAO() {
        return new PlanDetailDAO(planDetailMapper);
    }

    @Bean
    public PlanInfoDAO planInfoDAO() {
        return new PlanInfoDAO(planInfoMapper);
    }

    @Bean
    public MemberDAO memberDAO() {
        return new MemberDAO(memberInfoMapper);
    }

}
