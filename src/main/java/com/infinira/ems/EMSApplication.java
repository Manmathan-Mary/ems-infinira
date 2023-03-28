package com.infinira.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;
import org.springframework.cache.annotation.EnableCaching;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;


@EnableCaching
@SpringBootApplication
public class EMSApplication{
    private static final Logger logger = LogManager.getLogger(EMSApplication.class);
	public static void main(String[] args){
		logger.info("Entering EMS Springboot application");
		SpringApplication app = new SpringApplication(EMSApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
	}
}
