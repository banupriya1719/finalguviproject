package com.productinfo.product.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customopenapi(){

        return new OpenAPI()
                .info(new Info()
                        .title("PRODUCT WEBFLUX APIs")
                        .version("1.0")
                        .description("REACTIVE PROGRAMMING APIs")
                        .license(new License().name("licence...1.0")));
    }
}
