package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
public class ServiceAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAccountApplication.class, args);
	}

}
