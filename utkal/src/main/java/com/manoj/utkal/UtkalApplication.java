package com.manoj.utkal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:query.properties")
public class UtkalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtkalApplication.class, args);
	}
}
