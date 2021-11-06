package com.example.Order_Microservice;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

    @EnableSwagger2
    @Configuration
    class Swaggerconfig {

        public static final Contact DEFAULT_CONTACT = new Contact(
                "microservices", "http://localhost:8002", "localhost@gmail.com");

        public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
                "Awesome Api Title", "Awesome Api Description", "1.0",
                "urn:tos", DEFAULT_CONTACT,
                "Apache 2.0", "http://apache.org/licenses/LICENSE-2.0", Arrays.asList());


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);

    }
}
