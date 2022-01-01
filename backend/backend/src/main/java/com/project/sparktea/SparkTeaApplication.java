package com.project.sparktea;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SparkTeaApplication {

	final static Logger loggy = Logger.getLogger(SparkTeaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SparkTeaApplication.class, args);
	}

}
