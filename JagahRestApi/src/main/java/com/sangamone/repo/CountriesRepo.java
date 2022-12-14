package com.sangamone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sangamone.entity.Countries;

public interface CountriesRepo extends JpaRepository<Countries, Integer> {

//	@Modifying
	//@Query(value = "insert into countries(country_code,country_name) values(:country_code,:country_name)",nativeQuery= true)
	//void save(String country_code, String country_name);

}
