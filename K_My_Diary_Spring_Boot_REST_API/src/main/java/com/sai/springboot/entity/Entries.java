package com.sai.springboot.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entries")
public class Entries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date entrydate;
	private String description;
	private int userid;
	
	public Entries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entries(int id, Date entrydate, String description, int userid) {
		super();
		this.id = id;
		this.entrydate = entrydate;
		this.description = description;
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Entries [id=" + id + ", entrydate=" + entrydate + ", description=" + description + ", userid=" + userid
				+ "]";
	}
	
	
	
}
