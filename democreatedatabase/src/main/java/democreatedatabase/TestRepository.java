package democreatedatabase;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@Transactional
public class TestRepository {

	@Autowired
	private CrudRepo repo; 
	
	@Test
	
	public void testCreatePlaces()
	{
	// EntityManagerFactory ob = null;
		Placedetails c_ob = new Placedetails();
		//c_ob.setCountry_name("India");
		//c_ob.setCountry_code("IN");
		//ob.createEntityManager();
		//ob.
		c_ob.setCountry_id(1);
		c_ob.setCountry_name("USA");
		c_ob.setCountry_code("US");
	
		repo.save(c_ob);
	
		
		
	}
	
}
