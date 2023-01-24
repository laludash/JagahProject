package com.sangamone.serviceimpl;

public interface JagahDao {
 void  addCountries(String country_name,String country_code);
 void  addDistricts(String district_name,int state_id,int country_id);
 void  addStates(String state_name,String state_code,int country_id);
 void  addTaluks(String taluk_name,int district_id,int state_id,int country_id);
 void addPlaces(String place_name,int taluk_id,int district_id,int  state_id,int country_id);
}
