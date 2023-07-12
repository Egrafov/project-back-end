package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication {
//    private final JdbcTemplate jdbcTemplate;

    public DemoApplication(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//
//    @Override
//    public void run(String... args) throws Exception {
//        SqlRowSet resultSet = jdbcTemplate.queryForRowSet("SELECT * FROM products");
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("id"));
//        }
//    }
}
