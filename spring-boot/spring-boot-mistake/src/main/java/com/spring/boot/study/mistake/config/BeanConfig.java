package com.spring.boot.study.mistake.config;

import com.spring.boot.study.mistake.service.UserService;
import com.spring.boot.study.mistake.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    public UserService userService() {
        return new UserServiceImpl();
    }

}
