package com.sangamone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.sangamone.entity.Places;
import com.sangamone.entity.States;
import com.sangamone.repo.StatesRepo;
import com.sangamone.serviceimpl.Status;

@RestController
@RequestMapping("/api")
public class StatesController {

	@Autowired
	private StatesRepo Repo;
	
	@Autowired 
	 private MessagesForRestApis result;
	
	@CrossOrigin
	@PostMapping("/addState")
	public ResponseEntity<?> addStates(@RequestBody States state)
	{
		
		try
		{
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			if(!state.equals(null))
			{
				Repo.save(state);
				//String message="Success";
				//String status2="States are saved successfully";
				//System.out.println(result.getMessage(result.RESULT_ONE));
				//ob.setMessage(message);
				//ob.setStatus(status2);
				//status1.add(ob);
				return new ResponseEntity<>(result.getMessage(result.RESULT_ONE),HttpStatus.CREATED);
			}
			else
			{
				//String message="Failed";
				//String status2="Places not saved";
				//ob.setMessage(message);
				//ob.setStatus(status2);
				//status1.add(ob);
				//status1 remove from ResponseEntity
				//System.out.println(result.getMessage(result.RESULT_TWO));
				System.out.println("Not Saved");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			}
		}
		catch(Exception e)
		{
			String exception = e.toString();
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		
	}
	// implement one more method taking country_id  as input,
	//if no input provided handle exception and print error massage.
	@GetMapping("/getStates")
	public List<States> getStates()
	{
		return Repo.findAll();
	}
	
	
	@GetMapping("/getStatesById")
	@ResponseBody
	public List<States> getStatesByCountryId(@RequestParam int  country_id)
	{
		
		 List<States> list = Repo.getStatesByCountryId(country_id);
		return list;
	}
}
