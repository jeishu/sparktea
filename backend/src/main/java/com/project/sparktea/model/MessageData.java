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


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="message_data", schema="public")
public class MessageData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="conversationId")
	private int userId;
	
	@Column(name="sender")
	private String sender;
	
	@Column(name="text")
	private String text;

	
}
