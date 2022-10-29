package org.ga2.buna.config;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.dDay.DdayDAO;
import org.ga2.buna.dao.dDay.DdayMapper;
import org.ga2.buna.dao.dateCheck.DateCheckDAO;
import org.ga2.buna.dao.dateCheck.DateCheckMapper;
import org.ga2.buna.dao.like.LikeRepository;
import org.ga2.buna.dao.like.LikeMapper;
import org.ga2.buna.dao.login.LoginDAO;
import org.ga2.buna.dao.login.LoginMapper;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dao.planboard.PopMapper;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dao.plandetail.PlanDetailMapper;
import org.ga2.buna.dao.signup.SignUpDAO;
import org.ga2.buna.dao.signup.SignUpMapper;
import org.ga2.buna.dao.memberinfo.MemberInfoRepository;
import org.ga2.buna.dao.memberinfo.MemberInfoMapper;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.ga2.buna.dao.planinfo.PlanInfoMapper;
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
    public PlanDetailDAO planDetailDAO() {
        return new PlanDetailDAO(planDetailMapper);
    }

    @Bean
    public PlanInfoDAO planInfoDAO() {
        return new PlanInfoDAO(planInfoMapper);
    }

    @Bean
    public MemberInfoRepository memberDAO() {
        return new MemberInfoRepository(memberInfoMapper);
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

    @Bean
    public LoginDAO loginDAO() { return new LoginDAO(loginMapper); }

    @Bean
    public SignUpDAO signUpDAO() { return new SignUpDAO(signUpMapper); }

    @Bean
    public LikeRepository likeDAO() { return new LikeRepository(likeMapper); }
}
