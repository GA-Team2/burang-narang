package org.ga2.buna.config;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.dDay.DdayMapper;
import org.ga2.buna.dao.dDay.DdayRepository;
import org.ga2.buna.dao.dateCheck.DateCheckMapper;
import org.ga2.buna.dao.dateCheck.DateCheckRepository;
import org.ga2.buna.dao.like.LikeMapper;
import org.ga2.buna.dao.like.LikeRepository;
import org.ga2.buna.dao.login.LoginMapper;
import org.ga2.buna.dao.login.LoginRepository;
import org.ga2.buna.dao.memberinfo.MemberInfoMapper;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.ga2.buna.dao.planboard.PopMapper;
import org.ga2.buna.dao.planboard.PopRepository;
import org.ga2.buna.dao.plandetail.PlanDetailMapper;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dao.planinfo.PlanInfoMapper;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dao.signup.SignUpMapper;
import org.ga2.buna.dao.signup.SignUpRepository;
import org.ga2.buna.dao.tag.TagMapper;
import org.ga2.buna.dao.tag.TagRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class MyBatisConfig {

    private final TagMapper tagMapper;
    private final PlanDetailMapper planDetailMapper;
    private final PlanInfoMapper planInfoMapper;
    private final MemberInfoMapper memberInfoMapper;
    private final PopMapper popMapper;
    private final DateCheckMapper dateCheckMapper;
    private final DdayMapper ddayMapper;
    private final LoginMapper loginMapper;
    private final SignUpMapper signUpMapper;
    private final LikeMapper likeMapper;

    @Bean
    public TagRepository tagRepository() {
        return new TagRepository(tagMapper);
    }

    @Bean
    public PlanDetailRepository planDetailDAO() {
        return new PlanDetailRepository(planDetailMapper);
    }

    @Bean
    public PlanInfoRepository planInfoDAO() {
        return new PlanInfoRepository(planInfoMapper);
    }

    @Bean
    public MemberInfoRepository memberDAO() {
        return new MemberInfoRepository(memberInfoMapper);
    }

    @Bean
    public PopRepository popRepository() {
        return new PopRepository(popMapper);
    }

    @Bean
    public DateCheckRepository dateCheckRepository() {
        return new DateCheckRepository(dateCheckMapper);
    }

    @Bean
    public DdayRepository ddayRepository() {
        return new DdayRepository(ddayMapper);
    }

    @Bean
    public LoginRepository loginRepository() { return new LoginRepository(loginMapper); }

    @Bean
    public SignUpRepository signUpRepository() { return new SignUpRepository(signUpMapper); }

    @Bean
    public LikeRepository likeRepository() { return new LikeRepository(likeMapper); }

}