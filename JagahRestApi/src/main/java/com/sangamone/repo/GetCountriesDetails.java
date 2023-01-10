package com.sangamone.repo;

import java.util.List;

import com.sangamone.entity.CountriesDetails;

public interface GetCountriesDetails {

	
	List<CountriesDetails> FindByCountryId(int country_id);
}
