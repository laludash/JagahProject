package com.sangamone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sangamone.MessagesForRestApis;
import com.sangamone.entity.Places;
import com.sangamone.entity.Taluks;
import com.sangamone.repo.PlacesRepo;
import com.sangamone.serviceimpl.JagahDao;
import com.sangamone.serviceimpl.Status;

//@Controller
@RestController
//@RequestMapping("/api")
public class PlacesController {

	
	@Autowired
	 PlacesRepo repo;
	@Autowired 
	JagahDao jagahdao; 
	@Autowired 
	  MessagesForRestApis result;
	
	
	@CrossOrigin
	@PostMapping("/addPlace")
	public ResponseEntity<?> addPlaces(@RequestParam String place_name,int taluk_id,int district_id,int  state_id,int country_id)
	{
		//String methodName="places are added successfully";
		//@RequestBody Places place
		try
		{
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			
				//Repo.save(place);
			jagahdao.addPlaces(place_name, taluk_id, district_id, state_id, country_id);
			
				//String message="Success";
				//String status2="Places are saved successfully";
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
	
	// implement one more method taking country_id,state_id,district_id,taluk_id  as input,
			//if no input provided handle exception and print error massage.
	@GetMapping("/getPlaces")
	public List<Places> getPlaces()
	{
		//return (List<Places>) Repo.findAll();
		List<Places> list = (List<Places>) repo.findAll();
		return list;
	}
	// find all places 
	//@GetMapping("/getPlacesById")
	//public Optional<Places> getPlacesById(@RequestParam int place_id)
	//{
		//return Repo.findById(place_id); 
	//}
	
	// find all places by id 
	@GetMapping("/getPlacesById")
	@ResponseBody
	public ResponseEntity<?> getPlaceById(@RequestParam int country_id,int state_id,int district_id,int taluk_id) 
	{
		
		 //List<Taluks> list = Repo.getTalukById(country_id,state_id,district_id);
		//return list;
		
		try
		{
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			 List<Places> list = repo.getPlaceById(country_id,state_id,district_id,taluk_id);
			
				 return new ResponseEntity<List<Places>>(list, HttpStatus.OK);
			
		}
		catch (Exception e) {
			String exception = e.toString();				
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	//	return list;
		
	}

	
	
}
