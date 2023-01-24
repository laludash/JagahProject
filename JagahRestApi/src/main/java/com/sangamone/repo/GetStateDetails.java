package com.sangamone.repo;

import java.util.List;

import com.sangamone.entity.CountriesDetails;
import com.sangamone.entity.States;

public interface GetStateDetails {

	
	List<States> FindByCountryId(int state_id);
}
