package com.el.ally.wimp.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

public class Awards {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false, length=500)
	private String title;
	
	@Column(nullable=false, length=200)
	private String organization;
	
	private int year;
	
	public Actor actor;
	
	public Awards(String title, String organization, int year) {
		this.title = title;
		this.organization = organization;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
	
}
