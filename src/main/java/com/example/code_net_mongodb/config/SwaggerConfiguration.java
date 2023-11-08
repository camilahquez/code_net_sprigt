package com.example.code_net_mongodb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info().title("Test API documentation")
                .description("Documentation for Test weather API")
                .version("v1")
                .contact(getContactDetails())
                .license(getLicenseDetails()));
    }

    private Contact getContactDetails() {
        return new Contact().name("Contact Person").email("contact@email.con").url("https://website.com");
    }

    private License getLicenseDetails() {
        return new License().name("License name").url("https://license-url.com");
    }
}