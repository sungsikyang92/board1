package com.mvc.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.mvc.board.dao.sqls", "com.mvc.board.service.impl", "com.mvc.board.dao", "com.mvc.board.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
