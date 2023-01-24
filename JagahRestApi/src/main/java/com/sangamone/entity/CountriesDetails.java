package com.sangamone.entity;

public class CountriesDetails {

	private int country_id;
	private String country_name;
	private String country_code;
	
	private int district_id;
	private String district_name;
	private String district_code;
	
	
	
	
	public CountriesDetails(int country_id, String country_name, String country_code, int district_id,
			String district_name, String district_code) {
		super();
		this.country_id = country_id;
		this.country_name = country_name;
		this.country_code = country_code;
		this.district_id = district_id;
		this.district_name = district_name;
		this.district_code = district_code;
	}
	public CountriesDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getDistrict_code() {
		return district_code;
	}
	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}
	
	
}
	