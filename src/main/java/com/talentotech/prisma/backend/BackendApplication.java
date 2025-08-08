package com.talentotech.prisma.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println(System.getenv("DB_USER"));
		System.out.println(System.getenv("DB_PASSWORD"));
	}

}
