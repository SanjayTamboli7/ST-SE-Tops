package com.example.hms2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.hms2")
@EntityScan(basePackages = "com.example.hms2")
public class Hms2Application {

	public static void main(String[] args) {
		SpringApplication.run(Hms2Application.class, args);
	}

}
