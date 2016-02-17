package com.devarchi.config;

import com.devarchi.CallRestWS;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by donghoon on 2016. 2. 17..
 */
@Configuration
@ComponentScan(basePackages = "com.devarchi.config")
@PropertySource(value = {"classpath:param.properties"})
public class AppConfig {

    @Value("${endPoint}")
    private String endPoint;
    @Value("${serviceKey}")
    private String serviceKey;

    /*
     * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations.
     * Remove this bean if you are not using @Value annotations for injecting properties.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "callRestWS")
    public CallRestWS callRestWS() {
        return new CallRestWS(endPoint, serviceKey);
    }

}
