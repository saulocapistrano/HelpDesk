package com.sjnc.HelpDesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sjnc.HelpDesk.services.DBService;

@Configuration
@Profile("teste")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
	
}
