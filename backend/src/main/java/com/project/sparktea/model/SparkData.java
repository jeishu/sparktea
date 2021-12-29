package com.project.sparktea.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte getPhoto() {
		return photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, photo, text, time, url, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SparkData other = (SparkData) obj;
		return date == other.date && photo == other.photo && Objects.equals(text, other.text) && time == other.time
				&& Objects.equals(url, other.url) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "SparkData [userId=" + userId + ", date=" + date + ", time=" + time + ", text=" + text + ", url=" + url
				+ ", photo=" + photo + "]";
	}

	public SparkData(int userId, int date, int time, String text, String url, byte photo) {
		super();
		this.userId = userId;
		this.date = date;
		this.time = time;
		this.text = text;
		this.url = url;
		this.photo = photo;
	}

	public SparkData() {
		super();
	}
	
	
	
	

}
