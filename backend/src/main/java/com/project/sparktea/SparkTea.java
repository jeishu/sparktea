package com.project.sparktea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;




@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan({"com.amazonaws.services.s3.AmazonS3"})
@SpringBootApplication
public class SparkTea {

	public static void main(String[] args) {
		SpringApplication.run(SparkTea.class, args);
	}

}
