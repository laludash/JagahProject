package democreatedatabase;

import javax.persistence.EntityManager;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepo extends CrudRepository<Placedetails, String> {

	
}
