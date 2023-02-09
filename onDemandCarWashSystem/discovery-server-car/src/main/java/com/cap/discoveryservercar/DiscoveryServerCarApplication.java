package com.cap.discoveryservercar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

@EnableEurekaServer
public class DiscoveryServerCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerCarApplication.class, args);
	}

}
