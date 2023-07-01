package com.poc_swagger3_security;

import com.poc_swagger3_security.config.SpringConfig;
import com.poc_swagger3_security.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class PocSwagger3Security implements WebMvcConfigurer {

    public static void main(String[] args) {
        ScopeUtils.calculateScopeSuffix();
        new SpringApplicationBuilder(SpringConfig.class).registerShutdownHook(true)
                .run(args);
    }

}
