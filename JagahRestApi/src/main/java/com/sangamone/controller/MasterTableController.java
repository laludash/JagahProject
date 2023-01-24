package com.sangamone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangamone.entity.MasterTable;
import com.sangamone.entity.Taluks;
import com.sangamone.repo.MasterTableRepo;
import com.sangamone.repo.TaluksRepo;
import com.sangamone.serviceimpl.Status;

@RestController
@RequestMapping("/api")
public class MasterTableController {
	@Autowired
	private MasterTableRepo Repo;
	
	@CrossOrigin
	@PostMapping("/addMasterTable")
	public ResponseEntity<?> addMasterTable(@RequestBody MasterTable mastertable)
	{
		try
		{
			Status ob = new Status();
			List<Status> status1 = new ArrayList<>();
			if(!mastertable.equals(null))
			{
				Repo.save(mastertable);
				String message="Success";
				String status2="Added successfully";
				ob.setMessage(message);
				ob.setStatus(status2);
				status1.add(ob);
				return new ResponseEntity<>(status1, HttpStatus.CREATED);
			}
			else
			{
				String message="Failed";
				String status2="Not saved";
				ob.setMessage(message);
				ob.setStatus(status2);
				status1.add(ob);
				return new ResponseEntity<>(status1, HttpStatus.BAD_REQUEST);
			}
			
		}
		catch(Exception e)
		{
			String exception = e.toString();
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
	
	}
}
