package br.com.valhala.buscacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BuscaCepApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscaCepApiApplication.class, args);
	}

}
