package com.sangamone.repo;

import java.util.List;

import com.sangamone.entity.Districts;

public interface GetDistrictDetails {

	
	List<Districts> findbyDistrict_id(int district_id);
}
