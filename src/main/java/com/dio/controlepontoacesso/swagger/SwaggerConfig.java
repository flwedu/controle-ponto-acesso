package com.dio.controlepontoacesso.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Value("${application.title_description}") String title_description;
    @Value("${application.version}") String version;
    @Value("${application.description}") String description;

    @Bean
    public Docket customApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()

                .apis(RequestHandlerSelectors.basePackage("br.dio.controlepontoacesso"))
                .build().apiInfo(infoApi());
    }

    private ApiInfo infoApi(){
        return new ApiInfoBuilder()
                .title(title_description)
                .description(description)
                .version(version)
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }


}
