package com.sangamone.uploadcsv;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;




@CrossOrigin
@RestController
@RequestMapping("/api")
public class PlaceUploadController {

	
	@Autowired 
	PlaceUploadRepo repo;
	
	
	
	  @RequestMapping(value = "/uploadPlaces", method = RequestMethod.POST) 
	  @ResponseBody
	  public String addPlaces(@RequestPart("file") MultipartFile file) throws IOException, CsvValidationException {
	  //@RequestParam
	  List<PlaceEntity> places = new ArrayList<>(); 
	  InputStream inputstream = file.getInputStream();
	  CsvParserSettings setting = new CsvParserSettings();
	  setting.setHeaderExtractionEnabled(true); 
	  CsvParser parser = new CsvParser(setting); 
	  List<Record> parseAllRecord = parser.parseAllRecords(inputstream); 
	 
	  try {
	  
	  parseAllRecord.forEach(record -> {
	  System.out.println(""); 
	  PlaceEntity ob =new PlaceEntity(); 
	  ob.setPlace_name(record.getString("place_name"));
	  ob.setTaluk_id(Integer.parseInt(record.getString("taluk_id")));
	  ob.setDistrict_id(Integer.parseInt(record.getString("district_id")));
	  ob.setState_id(Integer.parseInt(record.getString("state_id")));
	  ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
	  
	  places.add(ob); 
	  }); 
	  repo.saveAll(places); 
	  }
	  catch(MultipartException e) 
	  {
	 // System.out.println("Incorrect header name");
	  System.out.println("Error in the CSV file header"+e.getMessage()); 
	  System.out.println("place_id should be integer and non-zero "+e.getMessage());
	  return "upload failed"; 
	  } 
	  System.out.println("Success");
	  
	  return "Successfully Upload"; 
	  }
}
