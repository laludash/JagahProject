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
@Table(name="places")
public class Places {
	
	//@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int place_id;
	private String place_name;
	//@JsonIgnore
	
	private int taluk_id;
	@ManyToOne()
	@JoinColumn(name="taluk_id", insertable=false, updatable = false)
	private Taluks taluk;
	private int district_id;
	@ManyToOne()
	@JoinColumn(name ="district_id", insertable= false, updatable = false)
	private Districts district;
	private int  state_id;
	@ManyToOne()
	@JoinColumn(name = "state_id",insertable = false, updatable = false)
	private States state;
	
	private int country_id;
	@ManyToOne()
	@JoinColumn(name = "country_id",insertable=false,updatable = false)
	private Countries countries;
	
	
	public Places() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Places(String place_name, int taluk_id, int district_id, int state_id, int country_id) {
		super();
		this.place_name = place_name;
		this.taluk_id = taluk_id;
		this.district_id = district_id;
		this.state_id = state_id;
		this.country_id = country_id;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public int getTaluk_id() {
		return taluk_id;
	}

	public void setTaluk_id(int taluk_id) {
		this.taluk_id = taluk_id;
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




	public int getPlace_id() {
		return place_id;
	}




	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}


}
