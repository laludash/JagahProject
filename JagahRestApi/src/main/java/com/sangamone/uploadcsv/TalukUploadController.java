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
public class TalukUploadController {

	@Autowired 
	TalukUploadRepo repo;
	
	 @RequestMapping(value = "/uploadTaluks", method = RequestMethod.POST)
		public String addTaluks(@RequestPart("file") MultipartFile file) throws IOException, CsvValidationException
		{
			// if column is missing, handle exception and show exact error 
			// if column is extra, handle exception and show exact error
			// if any row is having invalid data, handle exception and show exact error and row number.
			// After upload, show number of successful, number of failed records. Eg 49 successful, 1 fail.
			// After upload, record history of upload in csvUpload.log file with date,time,filename,REST Api called, number of success and failure.
			// After upload, create email trigger showing details of upload.
			// Use the following method names- addCountries,addStates,addDistricts,addTaluks,addPlaces.
			
	    
			List<TalukEntity> taluk = new ArrayList<>();
			InputStream inputstream = file.getInputStream();
			CsvParserSettings setting = new CsvParserSettings();
			setting.setHeaderExtractionEnabled(true);
			CsvParser parser = new CsvParser(setting);
		   List<Record> parseAllRecord = parser.parseAllRecords(inputstream);
		   try
		   {
		   
			parseAllRecord.forEach(record -> {
				System.out.println("Upload Successfully");
				TalukEntity ob = new TalukEntity();
			//ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
				//ob.setCountry_code(record.getString("country_code"));
				ob.setTaluk_name(record.getString("taluk_name"));
				ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
				ob.setState_id(Integer.parseInt(record.getString("state_id")));
				ob.setDistrict_id(Integer.parseInt(record.getString("districts_id")));
				
				
				taluk.add(ob);
			});
			repo.saveAll(taluk);
		   }
		   catch(IllegalArgumentException e)
		   {
			   System.out.println("Error in the CSV file");
			   System.out.println("Incorrect header name-:"+e.getMessage());
			   System.out.println("taluk_id should be integer and non-zero "+e.toString());
			   return "upload failed";
		   }
			
			
			return "Successfully Upload";
		}
	 
		
	
	
}
