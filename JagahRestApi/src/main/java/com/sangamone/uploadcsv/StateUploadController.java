package com.sangamone.uploadcsv;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
@RestController
public class StateUploadController {

	@Autowired 
	StateUploadRepo repo;
	
	 @RequestMapping(value = "/uploadStates", method = RequestMethod.POST)
		public String addState(@RequestPart("file") MultipartFile file) throws IOException, CsvValidationException
		{
			List<StateEntity> state = new ArrayList<>();
			InputStream inputstream = file.getInputStream();
			CsvParserSettings setting = new CsvParserSettings();
			setting.setHeaderExtractionEnabled(true);
			CsvParser parser = new CsvParser(setting);
		   List<Record> parseAllRecord = parser.parseAllRecords(inputstream);
		   try
		   {
		   
			parseAllRecord.forEach(record -> {
				System.out.println("Upload Successfully");
				StateEntity ob = new StateEntity();
			//ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
				//ob.setCountry_code(record.getString("country_code"));
				ob.setState_name(record.getString("state_name"));
				ob.setState_code(record.getString("state_code"));
				ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
				
			state.add(ob);
			});
			repo.saveAll(state);
		   }
		   catch(IllegalArgumentException e)
		   {
			   System.out.println("Error in the CSV file");
			   System.out.println("Incorrect header name-:"+e.getMessage());
			   System.out.println("state_id should be integer and non-zero "+e.toString());
			   return "upload failed"; 
		   }
			
			// 
			return "Successfully Upload";
		}
	 
		
	
}
