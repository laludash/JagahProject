package JagahProjectApi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StateRepo extends CrudRepository<StateEntity,Integer> {

}
