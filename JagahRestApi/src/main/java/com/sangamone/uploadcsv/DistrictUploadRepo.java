package com.sangamone.uploadcsv;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictUploadRepo extends JpaRepository<DistrictEntity, Integer> {

	//@Modifying
	//@Transactional
	//@Query(value = "insert into districts(district_name,state_id,country_id)"+"values(?1,?2,?3)", nativeQuery = true)
	//public String addDistricts(String district_name,int state_id,int country_id);
	
}
