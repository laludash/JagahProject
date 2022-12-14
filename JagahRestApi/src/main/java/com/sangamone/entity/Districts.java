package com.sangamone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="districts")
public class Districts {

	@JsonIgnore
	private int district_id;
	private String district_name;
	@JsonIgnore
	private String district_code;
	private int state_id;
	private int country_id;
	public Districts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Districts(int district_id, String district_name, int state_id, String district_code, int country_id) {
		super();
		this.district_id = district_id;
		this.district_name = district_name;
		this.state_id = state_id;
		this.district_code = district_code;
		this.country_id = country_id;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	public String getDistrict_name() {
		return district_name;
	}
	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getDistrict_code() {
		return district_code;
	}
	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	@Override
	public String toString() {
		return "Districts [district_id=" + district_id + ", district_name=" + district_name + ", state_id=" + state_id
				+ ", district_code=" + district_code + ", country_id=" + country_id + "]";
	}
	
}
