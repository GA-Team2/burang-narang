package org.ga2.buna.config;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.tag.PopularTagMapper;
import org.ga2.buna.dao.tag.TagDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final PopularTagMapper popularTagMapper;

    @Bean
    public TagDao tagDao() {
        return new TagDao(popularTagMapper);
    }
}
