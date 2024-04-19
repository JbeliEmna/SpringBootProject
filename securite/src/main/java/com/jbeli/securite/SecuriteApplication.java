package com.jbeli.securite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@OpenAPIDefinition(
//		security = @SecurityRequirement(name = "bearerAuth")
//)
//@SecurityScheme(
//		name = "bearerAuth",
//		description = "Some desc",
//		scheme = "bearer",
//		type = SecuritySchemeType.HTTP,
//		in = SecuritySchemeIn.HEADER
//)
public class SecuriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuriteApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
	) {
		return  args -> {
			System.out.println("Container started");
		};
	}



}
