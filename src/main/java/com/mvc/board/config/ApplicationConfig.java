package com.mvc.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.mvc.board.dao.sqls", "com.mvc.board.service.impl"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
