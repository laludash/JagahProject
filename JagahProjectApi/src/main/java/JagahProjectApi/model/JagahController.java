package JagahProjectApi.model;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import JagahProjectApi.model.Jagahentity;
import com.univocity.parsers.common.record.Record;

import java.io.IOException;
import java.io.InputStream;


@RestController
public class JagahController {
@Autowired 
Jagahrepo repo;
	
	@PostMapping("/upload")
	public String insertplacedetails(@RequestParam("file") MultipartFile file) throws IOException
	{
		List<Jagahentity> places = new ArrayList<>();
		InputStream inputstream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
		List<Record> parseAllRecord = parser.parseAllRecords(inputstream);
		parseAllRecord.forEach(record -> {
			Jagahentity  ob = new Jagahentity();
			ob.setCountry_id(Integer.parseInt(record.getString("country_id")));
			ob.setCountry_code(record.getString("country_code"));
			ob.setCountry_name(record.getString("country_name"));
			places.add(ob);
			
		});
		repo.saveAll(places);
		return "CSV data Upload Successfully";
	}
}
