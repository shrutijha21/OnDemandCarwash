package com.cap.apigatewaycar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayCarApplication.class, args);
	}

}
