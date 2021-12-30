package com.project.sparktea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD

import org.springframework.stereotype.Component;
@Component
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
>>>>>>> main
@Entity
@Table(name="spark_data", schema="public")
public class SparkData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private int userId;
	
	
	@Column(name="date")
	private int date;

	@Column(name="time")
	private int time;
	
	@Column(name="text")
	private String text;
	
	@Column(name="url")
	private String url;
	
	@Column(name="photo")
	private byte photo;
		
}
