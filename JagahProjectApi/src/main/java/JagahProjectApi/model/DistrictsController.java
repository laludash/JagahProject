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
public class DistrictsController {
	@Autowired 
	DistrictRepo repo;
	
	//@PostMapping("/upload")
    @RequestMapping(value = "/uploadDistricts", method = RequestMethod.POST)
	public String addDistricts(@RequestParam("file") MultipartFile file) throws IOException, CsvValidationException
	{
		List<DistrictEntity> districts = new ArrayList<>();
		InputStream inputstream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
	   List<Record> parseAllRecord = parser.parseAllRecords(inputstream);
	   try
	   {
	   
		parseAllRecord.forEach(record -> {
			System.out.println("success");
		    DistrictEntity ob = new DistrictEntity();
		//ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
			//ob.setCountry_code(record.getString("country_code"));
		ob.setDistrict_name(record.getString("district_name"));
		ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
		ob.setState_id(Integer.parseInt(record.getString("state_id")));
			
		districts.add(ob);
		});
		repo.saveAll(districts);
	   }
	   catch(IllegalArgumentException e)
	   {
		   System.out.println("Incorrect header name");
		   System.out.println("Error in the CSV file header"+e.getMessage());
	   }
		System.out.println("three");
		
		return "upload";
	}

	
    
}
