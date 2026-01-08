package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sist.web")
public class SpringBootJspProject4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspProject4Application.class, args);
	}

}
