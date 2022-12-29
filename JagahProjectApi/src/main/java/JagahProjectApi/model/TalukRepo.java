package JagahProjectApi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TalukRepo extends CrudRepository<TalukEntity, Integer> {

}
