package com.thebtnco.config;

import com.thebtnco.controller.BaseController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by bobby on 11/16/2017.
 */
@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("com.thebtnco.dao"),
        @ComponentScan("com.thebtnco.service")})
public class WebConfig {

    @Bean
    public BaseController baseController() {
        return new BaseController();
    }

}
