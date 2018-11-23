package com.manoj.utkal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:query.properties")
public class UtkalApplication /*extends SpringBootServletInitializer*/ {

	/* @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(UtkalApplication.class);
	    }*/
	
	
	public static void main(String[] args) {
		SpringApplication.run(UtkalApplication.class, args);
	}
}
