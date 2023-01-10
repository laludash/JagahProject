package com.sangamone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mastertable")
public class MasterTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int master_id;
	private int country_id;
	private int state_id;
	private int place_id;
	private int district_id;
	private int taluk_id;
	public MasterTable(int master_id, int country_id, int state_id, int place_id, int district_id, int taluk_id) {
		super();
		this.master_id = master_id;
		this.country_id = country_id;
		this.state_id = state_id;
		this.place_id = place_id;
		this.district_id = district_id;
		this.taluk_id = taluk_id;
	}
	public MasterTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaster_id() {
		return master_id;
	}
	public void setMaster_id(int master_id) {
		this.master_id = master_id;
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
	public int getPlace_id() {
		return place_id;
	}
	public void setPlace_id(int place_id) {
		this.place_id = place_id;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	public int getTaluk_id() {
		return taluk_id;
	}
	public void setTaluk_id(int taluk_id) {
		this.taluk_id = taluk_id;
	}
	@Override
	public String toString() {
		return "MasterTable [master_id=" + master_id + ", country_id=" + country_id + ", state_id=" + state_id
				+ ", place_id=" + place_id + ", district_id=" + district_id + ", taluk_id=" + taluk_id + "]";
	}
	
}
