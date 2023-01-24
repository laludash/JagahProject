package com.sangamone.uploadcsv;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.univocity.parsers.common.record.Record;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;


@RestController
public class CountryUploadController {

@Autowired 
Jagahrepo repo;
//@Autowired


	@RequestMapping(value = "/uploadCountries", method = RequestMethod.POST)
	public String addCountries(@RequestPart("file") MultipartFile file) throws IOException, CsvValidationException
	{
		// if column is missing, handle exception and show exact error 
		// if column is extra, handle exception and show exact error
		// if any row is having invalid data, handle exception and show exact error and row number.
		// After upload, show number of successful, number of failed records. Eg 49 successful, 1 fail.
		// After upload, record history of upload in csvUpload.log file with date,time,filename,REST Api called, number of success and failure.
		// After upload, create email trigger showing details of upload.
		// Use the following method names- addCountries,addStates,addDistricts,addTaluks,addPlaces.
		int count = 0;
    
		List<Jagahentity> places = new ArrayList<>();
		InputStream inputstream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
	   List<Record> parseAllRecord = parser.parseAllRecords(inputstream);
		
	   
	//  List<Record> successfulRecords = new ArrayList<>();
	 // List<Record> failedRecords= new ArrayList<>();
	//  String rowdata;
	 // try(InputStream  inputstreamone = file.getInputStream())
	//  {
	//	   List<Record> records = parser.parseAllRecords(inputstreamone);
				   // 
	//	   for(Record record : records)
	//	   {
			   
		//	  int rowdata = Integer.parseInt(record.getString("country_id"));
		//		System.out.println(rowdata);
			   
		 //  }
		//   
	 // }
	  // catch(NumberFormatException e)
	 //  {
		   
	
		//   System.out.println("country_id should be integer and non-zero"+e.getMessage());
	//   }
	   
	   
	   
	   
	   try
	   {
	   
		parseAllRecord.forEach(record -> {
			System.out.println("");
			Jagahentity  ob = new Jagahentity();
		//ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
			ob.setCountry_code(record.getString("country_code"));
			ob.setCountry_name(record.getString("country_name"));
			
		places.add(ob);
		});
		repo.saveAll(places);
	   }
	   catch(IllegalArgumentException e)
	   {
		   System.out.println("Incorrect header name");
		   System.out.println("Error in the CSV file header"+e.getMessage());
		   System.out.println("country_id should be integer and non-zero "+e.toString());
		   return "upload failed";
	   }
		System.out.println("Success");
		
		return "Successfully Upload";
	}

	
    
    
}
