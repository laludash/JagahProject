package com.sangamone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="places")
public class Places {
	
	@JsonIgnore
	private int place_id;
	private String place_name;
	@JsonIgnore
	private String place_code;
	private int taluk_id;
	private int district_id;
	private int  state_id;
	private int country_id;
	
	
	public Places() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Places(int place_id, String place_name, String place_code, int taluk_id, int district_id, int state_id,
			int country_id) {
		super();
		this.place_id = place_id;
		this.place_name = place_name;
		this.place_code = place_code;
		this.taluk_id = taluk_id;
		this.district_id = district_id;
		this.state_id = state_id;
		this.country_id = country_id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPlace_id() {
		return place_id;
	}


	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}


	public String getPlace_name() {
		return place_name;
	}


	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}


	public String getPlace_code() {
		return place_code;
	}


	public void setPlace_code(String place_code) {
		this.place_code = place_code;
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


	@Override
	public String toString() {
		return "Places [place_id=" + place_id + ", place_name=" + place_name + ", place_code=" + place_code
				+ ", taluk_id=" + taluk_id + ", district_id=" + district_id + ", state_id=" + state_id + ", country_id="
				+ country_id + "]";
	}
	
	
	

}
