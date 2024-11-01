package com.coworking.spaces_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpacesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacesServiceApplication.class, args);
	}

}
