package com.sangamone.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sangamone.entity.Countries;
import com.sangamone.entity.Districts;
import com.sangamone.entity.Places;
import com.sangamone.entity.States;
import com.sangamone.entity.Taluks;
import com.sangamone.repo.CountriesRepo;
import com.sangamone.repo.DistrictsRepo;
import com.sangamone.repo.PlacesRepo;
import com.sangamone.repo.StatesRepo;
import com.sangamone.repo.TaluksRepo;
@Component(value = "JagahDao")
@Service
@Transactional 
public class JagahDaoImpl implements JagahDao {

	@Autowired 
	 CountriesRepo countriesrepo;
    @Autowired 
     DistrictsRepo districtsrepo;
    @Autowired 
     PlacesRepo placesrepo;
    @Autowired 
     StatesRepo statesrepo;
    @Autowired 
     TaluksRepo taluksrepo;
    
	
	
	@Override
	public void addCountries(String country_name, String country_code) {
	
		Countries c_ob = new Countries();
		c_ob.setCountry_name(country_name);
		c_ob.setCountry_code(country_code);
		countriesrepo.save(c_ob);	
	}

	@Override
	public void addDistricts(String district_name, int state_id, int country_id) {
		Districts d_ob = new Districts();
		d_ob.setDistrict_name(district_name);
		d_ob.setState_id(state_id);
		d_ob.setCountry_id(country_id);
		districtsrepo.save(d_ob);

	}

	@Override
	public void addStates(String state_name, String state_code, int country_id) {
		States s_ob = new States();
		s_ob.setState_name(state_name);
		s_ob.setState_code(state_code);
		s_ob.setCountry_id(country_id);
		statesrepo.save(s_ob);
		
	}

	@Override
	public void addTaluks(String taluk_name, int district_id, int state_id, int country_id) {
	  Taluks t_ob = new Taluks();
	  t_ob.setTaluk_name(taluk_name);
	  t_ob.setDistrict_id(district_id);
	  t_ob.setState_id(state_id);
	  t_ob.setCountry_id(country_id);
	  
	  taluksrepo.save(t_ob);
		

	}

	@Override
	public void addPlaces(String place_name, int taluk_id, int district_id, int state_id, int country_id) {
		Places p_ob = new Places();
		p_ob.setPlace_name(place_name);
		p_ob.setTaluk_id(taluk_id);
		p_ob.setDistrict_id(district_id);
		p_ob.setState_id(state_id);
		p_ob.setCountry_id(country_id);
		placesrepo.save(p_ob);

	}

}
