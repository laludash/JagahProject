package democreatedatabase;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Placetwo {

	@Autowired
	private EntityManager entitymanager;
	
	@Transactional
	public void insertplacedetails(Placedetails placedetails)
	{
		entitymanager.persist(placedetails);
		
	}
	
}
