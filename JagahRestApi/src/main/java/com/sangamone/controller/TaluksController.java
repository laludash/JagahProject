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
import com.sangamone.entity.Taluks;
import com.sangamone.repo.TaluksRepo;
import com.sangamone.serviceimpl.Status;
@RestController
@RequestMapping("/api")
public class TaluksController {

	
	@Autowired
	private TaluksRepo Repo;
	@Autowired 
	 private MessagesForRestApis result;
	
	@CrossOrigin
	@PostMapping("/addTaluk")
	public ResponseEntity<?> addTaluk(@RequestBody Taluks taluk)
	{
		try
		{
		
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			
				Repo.save(taluk);
				//String message="Success";
				//String status2="Taluk saved successfully";
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
	
	// implement one more method taking country_id,state_id,district_id  as input,
		//if no input provided handle exception and print error massage.
	
	@GetMapping("/getTaluks")
	public List<Taluks> getTaluks()
	{
		return Repo.findAll();
	}
	
	

	@GetMapping("/getTaluksById")
	@ResponseBody
	public ResponseEntity<?> getTaluksById(@RequestParam int  country_id,int state_id,int district_id) 
	{
		
		 //List<Taluks> list = Repo.getTalukById(country_id,state_id,district_id);
		//return list;
		
		try
		{
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			 List<Taluks> list = Repo.getTaluksById(country_id,state_id,district_id);
			
		      return new ResponseEntity<List<Taluks>>(list, HttpStatus.OK);
			
			//return list;
		}
		catch (Exception e) {
			String exception = e.toString();				
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	//	return list;
		
	}

	
	
	
}
