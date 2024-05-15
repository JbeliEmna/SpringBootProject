package com.jbeli.securite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
@EnableDiscoveryClient
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
