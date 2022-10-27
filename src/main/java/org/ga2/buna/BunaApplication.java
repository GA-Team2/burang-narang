package org.ga2.buna;

import org.ga2.buna.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
@Import(MyBatisConfig.class)
public class BunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BunaApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/buna");
		dataSource.setUsername("buna");
		dataSource.setPassword("1234");

		return dataSource;
	}

}
