package com.gyq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;

/**
 * @author gaoyaqiu
 * @date 2019/5/30
 */
public class LearningApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootConfiguration.class);
        springApplication.setWebApplicationType(WebApplicationType.SERVLET);
        springApplication.run(args);
    }
}
