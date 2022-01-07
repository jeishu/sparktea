package com.project.sparktea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;




@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@ComponentScan({"com.amazonaws.services.s3.AmazonS3"})
@SpringBootApplication
//@EnableWebSecurity
public class SparkTea {

	public static void main(String[] args) {
		SpringApplication.run(SparkTea.class, args);
	}

}
