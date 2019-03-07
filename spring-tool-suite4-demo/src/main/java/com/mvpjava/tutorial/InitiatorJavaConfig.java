package com.mvpjava.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class InitiatorJavaConfig {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean
	@Profile("prod")
	public IApplicationInitiator dbInit() {
		return () -> logger.info("Initializing database");
	}

	@Bean
	@Profile({ "default", "dev" })
	public IApplicationInitiator fileInit() {
		return () -> logger.info("Setting up File attribtes");
	}
	
	@Bean 
	public Application application (IApplicationInitiator initiator) {
		return new Application(initiator);
	}

}

