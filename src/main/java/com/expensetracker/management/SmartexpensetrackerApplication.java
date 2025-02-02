package com.expensetracker.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.expensetracker" })
@EnableJpaRepositories(basePackages = { "com.expensetracker" })
@EntityScan(basePackages = { "com.expensetracker" })
public class SmartexpensetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartexpensetrackerApplication.class, args);
	}

}
