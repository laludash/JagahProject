package com.sangamone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="states")
public class States {

	//@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int state_id;
	private String state_name;
	private String state_code;
	private int country_id;
	
	@ManyToOne()
    @JoinColumn(name="country_id", insertable= false, updatable=false)
	private Countries country;
	
	public States() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public States(String state_name, String state_code, int country_id) {
		super();
		this.state_name = state_name;
		this.state_code = state_code;
		this.country_id = country_id;
	}


	public String getState_name() {
		return state_name;
	}


	public void setState_name(String state_name) {
		this.state_name = state_name;
	}


	public String getState_code() {
		return state_code;
	}


	public void setState_code(String state_code) {
		this.state_code = state_code;
	}


	public int getCountry_id() {
		return country_id;
	}


	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}


	
	
}
