package com.sangamone.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="countries")
public class Countries {

	
	//@Column(name = "country_id")
	@JsonIgnore
	private int country_id;
	@Column(name = "country_name")
	private String country_name;
	@Column(name = "country_code")
	private String country_code;
	public Countries() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Countries(int country_id, String country_name, String country_code) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.country_code = country_code;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	@Override
	public String toString() {
		return "Countries [country_id=" + country_id + ", country_name=" + country_name + ", country_code="
				+ country_code + "]";
	}
	
	
	
	
	
	
}
