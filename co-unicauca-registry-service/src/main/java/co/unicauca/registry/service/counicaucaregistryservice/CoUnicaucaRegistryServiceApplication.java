package co.unicauca.registry.service.counicaucaregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*Proyecto que trabaja como un eureka server*/
@EnableEurekaServer
@SpringBootApplication
public class CoUnicaucaRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoUnicaucaRegistryServiceApplication.class, args);
	}

}
