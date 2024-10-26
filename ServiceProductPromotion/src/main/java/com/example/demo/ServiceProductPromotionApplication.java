package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
@EnableScheduling
public class ServiceProductPromotionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProductPromotionApplication.class, args);
	}

}
