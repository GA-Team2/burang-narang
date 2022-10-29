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

}
