package com.sangamone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sangamone.entity.States;
import com.sangamone.entity.Taluks;

public interface TaluksRepo extends JpaRepository<Taluks, Integer> {

	@Query(value = "select * from taluks where country_id =?1 and state_id =?2 and district_id = ?3", nativeQuery = true)
	List<Taluks> getTaluksById(int country_id, int state_id, int district_id);

}
