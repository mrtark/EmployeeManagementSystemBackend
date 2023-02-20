package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class
})
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")
public class EmployeeApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
