package com.ivoronline;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com")
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1522/orcl", "TEST", "LETMEIN");
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
