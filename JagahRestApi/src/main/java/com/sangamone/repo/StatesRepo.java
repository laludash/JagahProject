package com.sangamone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sangamone.entity.States;

public interface StatesRepo extends CrudRepository<States, Integer> {

	@Query(value = "select * from states where country_id = ?1",nativeQuery= true)
	List<States> getStatesByCountryId(int country_id);  
	
}
