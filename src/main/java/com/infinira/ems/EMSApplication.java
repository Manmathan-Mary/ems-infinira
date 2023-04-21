package com.infinira.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;
import org.springframework.cache.annotation.EnableCaching;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.boot.Banner;
import java.io.PrintStream;


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

	@Bean
	public Banner myBanner() {
		return new MyBanner();
	}

	private static class MyBanner implements Banner {
		@Override
		public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
			System.out.println("**********************************************");
			System.out.println("*                 My Application              *");
			System.out.println("**********************************************");
		}
	}
}



