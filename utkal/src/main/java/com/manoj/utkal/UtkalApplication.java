package com.manoj.utkal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@PropertySource("classpath:query.properties")
@Slf4j
public class UtkalApplication extends SpringBootServletInitializer {

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(UtkalApplication.class);
	    }
	
	
	public static void main(String[] args) {
		log.debug("Starting application at debug level");
		log.info("Starting application at info level");
		SpringApplication.run(UtkalApplication.class, args);
		log.debug("Started application at debug level");
		log.info("Started application at info level");
	}
}
