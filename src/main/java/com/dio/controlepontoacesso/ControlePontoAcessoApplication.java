package com.dio.controlepontoacesso;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlePontoAcessoApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/api");
		SpringApplication.run(ControlePontoAcessoApplication.class, args);
	}

	public OpenAPI customOpenAPI(
			@Value("${application.title_description}") String title_description,
			@Value("${application.version}") String version,
			@Value("${application.description}") String description
	) {
		return new OpenAPI()
				.info(new Info()
						.title(title_description)
						.version(version)
						.description(description)
						.termsOfService("http://swagger.io/terms")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
