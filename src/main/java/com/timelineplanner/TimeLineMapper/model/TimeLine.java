package com.timelineplanner.TimeLineMapper.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TimeLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date start_time;
	private Date end_time;
	private String description; // Agenda or tasks
	private String report;
	private Date timestamp;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public TimeLine() {
		super();
	}
	
	public TimeLine(int id, Date start_time, Date end_time, String description, String report, Date timestamp,
			User user) {
		super();
		this.id = id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.description = description;
		this.report = report;
		this.timestamp = timestamp;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getStart_time() {
		return start_time;
	}
	
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReport() {
		return report;
	}
	
	public void setReport(String report) {
		this.report = report;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}	

}
