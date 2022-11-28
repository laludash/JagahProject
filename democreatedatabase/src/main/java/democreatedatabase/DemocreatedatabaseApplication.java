package democreatedatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableAutoConfiguration
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DemocreatedatabaseApplication implements CommandLineRunner{

	@Autowired private Placetwo repo;
	public static void main(String[] args) {
		SpringApplication.run(DemocreatedatabaseApplication.class, args);
	}

	public void run(String... args) throws Exception {
 
		createPlace();
    }
	
	private void createPlace()
	{
		Placedetails ob = new Placedetails();
		ob.setCountry_name("United Kingdom");
		ob.setCountry_code("UK");
		
		repo.insertplacedetails(ob);
		
	}
}
