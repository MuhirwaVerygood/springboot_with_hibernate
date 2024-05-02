package org.example.springboot_hibernate_mysql_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(path = "/api/v1")
@SpringBootApplication
public class SpringbootHibernateMysqlCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootHibernateMysqlCrudApplication.class, args);
    }

}
