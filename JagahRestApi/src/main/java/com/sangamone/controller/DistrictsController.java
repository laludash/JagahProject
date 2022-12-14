package com.sangamone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangamone.MessagesForRestApis;
import com.sangamone.entity.Districts;
import com.sangamone.entity.Places;
import com.sangamone.entity.States;
import com.sangamone.repo.DistrictsRepo;
import com.sangamone.serviceimpl.Status;
@RestController
@RequestMapping("/api")
public class DistrictsController {

	@Autowired
	private DistrictsRepo Repo;
	
	@Autowired 
	 private MessagesForRestApis result;
	
	@CrossOrigin
	@PostMapping("/addDistrict")
	public ResponseEntity<?> addDistricts(@RequestBody Districts districts)
	{
		
		try
		{
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			
				Repo.save(districts);
				//String message="Success";
				//String status2="Districts are saved successfully";
				//ob.setMessage(message);
				//ob.setStatus(status2);
				//status1.add(ob);
				return new ResponseEntity<>(result.getMessage(result.RESULT_ONE), HttpStatus.CREATED);
			
			
		}
		catch(Exception e)
		{
			String exception = e.toString();
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	// implement one more method taking country_id and state_id as input,
	//if no input provided handle exception and print error massage.
	
	@GetMapping("/getDistricts")
	public List<Districts> getDistricts()
	{
		return Repo.findAll();
	}
	

	@GetMapping("/getDistrictsById")
	@ResponseBody
	public List<Districts> getDistrictsByCountryIdAndStatesId(@RequestParam int  country_id,int state_id)
	{
		
		 List<Districts> list = Repo.getDistrictsByCountryIdAndStatesId(country_id,state_id);
		return list;
	}
	
}
