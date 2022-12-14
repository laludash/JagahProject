package com.sangamone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sangamone.entity.Districts;

public interface DistrictsRepo extends JpaRepository<Districts, Integer> {

	@Query(value = "select * from districts where state_id = ?1 and country_id = ?2", nativeQuery = true)
	List<Districts> getDistrictsByCountryIdAndStatesId(int country_id, int state_id);

}
