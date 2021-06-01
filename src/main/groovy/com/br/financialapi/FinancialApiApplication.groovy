package com.br.financialapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
@EnableWebMvc
class FinancialApiApplication implements WebMvcConfigurer {

	static void main(String[] args) {
		SpringApplication.run(FinancialApiApplication, args)
	}

	@Override
	void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
	}
}
