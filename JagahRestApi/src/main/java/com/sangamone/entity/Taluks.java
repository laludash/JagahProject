package com.sangamone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
//import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="taluks")
public class Taluks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "taluk_id", unique = true, nullable = false)
	//@JsonIgnore
	private int taluk_id;
	private String taluk_name;

	@ManyToOne()
	@JoinColumn(name="district_id",insertable = false,updatable = false)
	private Districts district;
	
	
	@ManyToOne()
	@JoinColumn(name="state_id",insertable = false,updatable = false)
	private States state;
	private int country_id;
	private int state_id;
	private int district_id;
	@ManyToOne()
	@JoinColumn(name = "country_id",insertable=false,updatable = false)
	private Countries countries;
	public Taluks() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Taluks(String taluk_name, int district_id, int state_id, int country_id) {
		super();
		this.taluk_name = taluk_name;
		this.district_id = district_id;
		this.state_id = state_id;
		this.country_id = country_id;
	}


	public String getTaluk_name() {
		return taluk_name;
	}


	public void setTaluk_name(String taluk_name) {
		this.taluk_name = taluk_name;
	}


	public int getDistrict_id() {
		return district_id;
	}


	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}


	public int getState_id() {
		return state_id;
	}


	public void setState_id(int state_id) {
		this.state_id = state_id;
	}


	public int getCountry_id() {
		return country_id;
	}


	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}


	public int getTaluk_id() {
		return taluk_id;
	}


	public void setTaluk_id(int taluk_id) {
		this.taluk_id = taluk_id;
	}


	

	
	
}
