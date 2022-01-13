package com.project.sparktea;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SparkTea {
	
	static Logger logger = LoggerFactory.getLogger(SparkTea.class);

	public static void main(String[] args) {
		logger.info("Home method accessed");
		
		SpringApplication.run(SparkTea.class, args);
		
		
	}

}
