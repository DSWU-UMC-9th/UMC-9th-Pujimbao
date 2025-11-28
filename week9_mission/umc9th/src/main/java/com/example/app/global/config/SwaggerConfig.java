package com.example.app.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        // Swagger 문서 정보
        Info info = new Info()
                .title("Project API")
                .description("Project API Swagger Documentation")
                .version("0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"));

        // JWT 설정
        String jwtSchemeName = "JWT TOKEN";
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);

        SecurityScheme securityScheme = new SecurityScheme()
                .name(jwtSchemeName)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");   // swagger UI에서 헤더에 JWT 입력 허용

        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, securityScheme);

        // Server URL 설정 (필요에 맞게 수정)
        Server localServer = new Server()
                .url("/")
                .description("Local Server");

        return new OpenAPI()
                .info(info)
                .addServersItem(localServer)
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}
