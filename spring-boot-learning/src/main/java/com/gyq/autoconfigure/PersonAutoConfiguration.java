package com.gyq.autoconfigure;

import com.gyq.domain.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * person 自动装配.
 *
 * @author gaoyaqiu
 * @date 2019/5/30
 */
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "person", name = "enabled", havingValue = "true")
public class PersonAutoConfiguration {

    @ConfigurationProperties(prefix = "person")
    @Bean
    public Person person() {
        return new Person();
    }
}
