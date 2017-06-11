package com.speed.mixer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@SpringBootApplication
@EnableEurekaClient
public class SpringbootM7BookClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootM7BookClientApplication.class, args);
	}
}
