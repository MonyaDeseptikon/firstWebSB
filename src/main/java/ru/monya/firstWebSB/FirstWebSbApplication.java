package ru.monya.firstWebSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication (exclude = { SecurityAutoConfiguration.class})
//@SpringBootApplication (exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class FirstWebSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWebSbApplication.class, args);
	}

}
