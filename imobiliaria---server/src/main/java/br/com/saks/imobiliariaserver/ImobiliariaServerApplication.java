package br.com.saks.imobiliariaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ImobiliariaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImobiliariaServerApplication.class, args);
	}

}
