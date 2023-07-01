package com.poc_swagger3_security.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@ComponentScan("com.poc_swagger3_security")
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class SpringConfig{


}
