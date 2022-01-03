package com.project.sparktea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class SparkData {
	

	private int userId;
	

	private int date;


	private int time;
	
	
	private String text;
	

	private String url;
	
	
	private byte photo;
		
}
