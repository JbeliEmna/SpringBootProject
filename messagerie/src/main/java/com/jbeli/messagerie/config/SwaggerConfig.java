package com.jbeli.messagerie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jbeli.messagerie"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfo("Messagerie microservice","Messagerie microservice for the user management part",
                "1.0","https://github.com/JbeliEmna/SpringBootProject/tree/master/messagerie"
                ,new Contact("Contact Us" , "https://project.com", "contact@project.com")
                ,"Terms of Use Licence","https://github.com/JbeliEmna/SpringBootProject",
                Collections.emptyList());
    }
}
