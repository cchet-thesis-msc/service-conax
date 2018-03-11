package com.gepardec.sypoc.conax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 03/04/18
 */
@SpringBootApplication
@PropertySource("${CONFIG_LOCATION_EXTERNAL}")
@ComponentScan(basePackageClasses = Application.class)
@EnableAutoConfiguration
public class Application {

    // must have a main method spring-boot can run
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Logger createLogger(final InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getDeclaredType());
    }
}
