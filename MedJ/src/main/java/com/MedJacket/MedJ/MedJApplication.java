package com.MedJacket.MedJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MedJApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedJApplication.class, args);
		
	}

}
