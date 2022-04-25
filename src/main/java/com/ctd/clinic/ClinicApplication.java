package com.ctd.clinic;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicApplication.class, args);
		PropertyConfigurator.configure("log4j.properties");
	}
}
