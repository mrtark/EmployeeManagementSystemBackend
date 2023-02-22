package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import java.util.TimeZone;
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableMongoRepositories
//@EnableAsync
//@EnableCaching
@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class
})
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")
@EntityScan(basePackages = "com.example.employee.data.entity")
public class EmployeeApplication {
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
