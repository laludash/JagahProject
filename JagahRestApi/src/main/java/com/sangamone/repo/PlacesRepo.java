package com.sangamone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sangamone.entity.Places;

public interface PlacesRepo extends CrudRepository<Places, Integer> {
	
	@Query(value = "select * from places where country_id =?1 and state_id =?2 and district_id=?3 and taluk_id=?4", nativeQuery = true)
	List<Places> getPlaceById(int country_id, int state_id, int district_id, int taluk_id);
	

}
