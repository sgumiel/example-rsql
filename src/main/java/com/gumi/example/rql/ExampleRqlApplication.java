package com.gumi.example.rql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ExampleRqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleRqlApplication.class, args);
	}

}
