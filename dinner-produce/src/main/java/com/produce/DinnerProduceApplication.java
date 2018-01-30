package com.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DinnerProduceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinnerProduceApplication.class, args);
	}
}
