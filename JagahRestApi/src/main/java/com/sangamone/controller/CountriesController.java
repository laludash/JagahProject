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
import com.sangamone.entity.Countries;
import com.sangamone.entity.CountriesDetails;
import com.sangamone.entity.Places;
import com.sangamone.repo.CountriesDetailsService;
import com.sangamone.repo.CountriesRepo;
import com.sangamone.serviceimpl.Status;

@RestController
@RequestMapping("/api")
public class CountriesController {

	@Autowired
	private CountriesRepo Repo;
	
	@Autowired
	private CountriesDetailsService service;
	
	@Autowired 
	 private MessagesForRestApis result;
	
	@RequestMapping("/test")
	@ResponseBody
	public String State()
	{
		return "TestLiveUrl";
	}
	
	@CrossOrigin
	@PostMapping("/addCountry")
	public ResponseEntity<?> saveCountries(@RequestBody Countries countries)
	{
		
		try
		{
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			
				Repo.save(countries);
				//String message="Success";
				//String status2="Country saved successfully";
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
	
	@GetMapping("/getCountries")
	public List<Countries> getCountries(){
		return Repo.findAll();
		
	}
	
	@GetMapping("/getCountriesById")
	public Optional<Countries> getCountriesById(@RequestParam int country_id)
	{
		return Repo.findById(country_id);
	}
	
	@CrossOrigin
	@GetMapping("/getCountriesDetailsById")
	public ResponseEntity<?> getCountriesDetailsById(@RequestParam int country_id)
	{
		try
		{
			//Status ob = new Status();
			//List<Status> status1 = new ArrayList<>();
			List<CountriesDetails> ob1 = service.getCountriesById(country_id);
			if(!ob1.isEmpty())
			{
				return new ResponseEntity<List<CountriesDetails>>(ob1, HttpStatus.OK);
				
			}
			else
			{
				//String message="Failed";
				//String status2="Failed to fetch details";
				//ob.setMessage(message);
				//ob.setStatus(status2);
				//status1.add(ob);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
	    }
		catch (Exception e) {
			String exception = e.toString();				
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	
		
	}
	
}

