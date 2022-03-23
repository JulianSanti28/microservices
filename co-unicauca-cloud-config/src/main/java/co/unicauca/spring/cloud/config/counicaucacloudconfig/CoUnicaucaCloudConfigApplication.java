package co.unicauca.spring.cloud.config.counicaucacloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//Configurar como servidor de config
@EnableConfigServer
@SpringBootApplication
public class CoUnicaucaCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoUnicaucaCloudConfigApplication.class, args);
	}

}
