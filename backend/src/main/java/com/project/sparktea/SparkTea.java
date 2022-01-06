package com.project.sparktea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.amazonaws.services.s3.AmazonS3"})
@SpringBootApplication
public class SparkTea {

	public static void main(String[] args) {
		SpringApplication.run(SparkTea.class, args);
	}

}
