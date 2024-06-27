package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DesarrolloApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(DesarrolloApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer1() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/empleados").allowedOrigins("*");
			}
		};
	}
}
