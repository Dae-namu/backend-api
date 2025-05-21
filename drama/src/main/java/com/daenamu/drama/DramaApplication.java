package com.daenamu.drama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DramaApplication.class, args);
	}

}
