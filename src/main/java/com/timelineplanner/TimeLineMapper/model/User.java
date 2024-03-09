package com.timelineplanner.TimeLineMapper.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	private String id;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<TimeLine> timelines;
	
	public List<TimeLine> getTimelines() {
		return timelines;
	}

	public void setTimelines(List<TimeLine> timelines) {
		this.timelines = timelines;
	}

	public User() {
		super();
	}

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
