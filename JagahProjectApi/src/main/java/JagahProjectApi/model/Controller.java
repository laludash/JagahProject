package JagahProjectApi.model;


import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@RestController
//@RequestMapping("/api")
public class Controller {

	@Autowired 
	Jagahrepo repo;
	
	@CrossOrigin
	 @RequestMapping(value = "/uploadcsv", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") String file) throws IOException 
	{
		ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(file),
                CsvPreference.STANDARD_PREFERENCE);
		
		String[] header=beanReader.getHeader(true);
		
		Jagahentity entity = null;
		List<Jagahentity> places = new ArrayList<>();
	    FileReader ob1 = new FileReader(file);
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
		  List<Record> parseAllRecord = parser.parseAllRecords(ob1);
		while((entity = beanReader.read(Jagahentity.class, header)) != null)
         {
	                String country_code = entity.getCountry_code();
	                String country_name = entity.getCountry_name();
	                System.out.println("c_code"+country_code);
	                 if(header.equals(country_code))
	                 {
	                	 System.out.println("correct"+country_code);
	                 }
	                 if(!header.equals(country_code))
	                 {
	                	 System.out.println("incorrect");
	                 }
	                 if(header.equals(country_name))
	                 {
	                	 System.out.println("correct");
	                 }
	                
	               // System.out.println("c_name"+country_name);
	                 
	                 
           }
		parseAllRecord.forEach(record -> {
			System.out.println("one");
			Jagahentity  ob = new Jagahentity();
		//ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
			ob.setCountry_code(record.getString("country_code"));
			ob.setCountry_name(record.getString("country_name"));
			
		places.add(ob);
		});
		repo.saveAll(places);
		return "Read Success";

		
	}
	
	
}
