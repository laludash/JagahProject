package com.sangamone.uploadcsv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taluks")
public class TalukEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int taluk_id;
	private String taluk_name;
	private int country_id;
	private int state_id;
	private int district_id;
	
	
	public int getTaluk_id() {
		return taluk_id;
	}
	public void setTaluk_id(int taluk_id) {
		this.taluk_id = taluk_id;
	}
	public String getTaluk_name() {
		return taluk_name;
	}
	public void setTaluk_name(String taluk_name) {
		this.taluk_name = taluk_name;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	
	
}
