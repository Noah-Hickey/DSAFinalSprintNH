package com.trees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com")  // Scan everything under com //
@EntityScan(basePackages = "com.model")
@EnableJpaRepositories(basePackages = "com.repository")
public class TreesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreesApplication.class, args);
	}
}