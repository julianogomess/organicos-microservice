package com.micro.historicoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class HistoricoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoricoserviceApplication.class, args);
	}

}
