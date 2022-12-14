package com.sangamone.repo;

import java.util.List;


import com.sangamone.entity.CountriesDetails;

public interface CountriesDetailsService {

	//List<CourseDetails> getCoursesByCategoryId(int categoryId);
	
	List<CountriesDetails> getCountriesById(int country_id);
	
}
