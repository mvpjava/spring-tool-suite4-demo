package com.mvpjava.tutorial;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner	 {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired Application application;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(args).forEach((arg) -> logger.debug("Arguement: {}", arg));	
		application.initApp();
	}



}
