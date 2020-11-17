package com.ravi.springmvcboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringmvcbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcbootApplication.class, args);
	}

}
