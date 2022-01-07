package com.project.sparktea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class SparkTea {

	public static void main(String[] args) {
		SpringApplication.run(SparkTea.class, args);
	}

}
