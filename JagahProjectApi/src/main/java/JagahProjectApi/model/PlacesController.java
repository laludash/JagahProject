package JagahProjectApi.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@RestController
public class PlacesController {

	
	@Autowired 
	PlaceRepo repo;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String addPlaces(@RequestParam("file") MultipartFile file) throws IOException, CsvValidationException
	{
		// if column is missing, handle exception and show exact error 
		// if column is extra, handle exception and show exact error
		// if any row is having invalid data, handle exception and show exact error and row number.
		// After upload, show number of successful, number of failed records. Eg 49 successful, 1 fail.
		// After upload, record history of upload in csvUpload.log file with date,time,filename,REST Api called, number of success and failure.
		// After upload, create email trigger showing details of upload.
		// Use the following method names- addCountries,addStates,addDistricts,addTaluks,addPlaces.
		int count = 0;
    
		List<PlaceEntity> places = new ArrayList<>();
		InputStream inputstream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
	   List<Record> parseAllRecord = parser.parseAllRecords(inputstream);
		
	   
	  List<Record> successfulRecords = new ArrayList<>();
	  List<Record> failedRecords= new ArrayList<>();
	   try(InputStream  inputstreamone = file.getInputStream())
	  {
		   List<Record> records = parser.parseAllRecords(inputstreamone);
		   for(Record record : records)
		   {
			   try
			   {
			  
			   System.out.println("Success -:"+successfulRecords.add(record));
			   System.out.println("Count"+count++);
			   }
			   catch(Exception e)
			   {
				   System.out.println("Fail -:"+failedRecords.add(record));
			   }
		   }
		 
		   
	  }
	   catch(Exception e)
	   {
		   System.out.println("Bad Request");
	   }
	   
	   
	   
	   
	   try
	   {
	   
		parseAllRecord.forEach(record -> {
			System.out.println("");
			PlaceEntity ob = new PlaceEntity();
		//ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
			//ob.setCountry_code(record.getString("country_code"));
			ob.setPlace_name(record.getString("place_name"));
			ob.setState_id(Integer.parseInt(record.getString("state_id")));
			ob.setTaluk_id(Integer.parseInt(record.getString("taluk_id")));
			ob.setDistrict_id(Integer.parseInt(record.getString("district_id")));
			ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
			
		places.add(ob);
		});
		repo.saveAll(places);
	   }
	   catch(IllegalArgumentException e)
	   {
		   System.out.println("Incorrect header name");
		   System.out.println("Error in the CSV file header"+e.getMessage());
		   return "upload failed";
	   }
		System.out.println("Success");
		
		return "Successfully Upload";
	}

	
}
