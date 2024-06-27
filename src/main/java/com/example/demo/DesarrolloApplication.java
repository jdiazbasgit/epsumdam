package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class DesarrolloApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DesarrolloApplication.class, args);
	}



	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/empleadoes/**").allowedOrigins("*").allowedOriginPatterns("*");
	}

}
