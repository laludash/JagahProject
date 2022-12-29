package JagahProjectApi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlaceRepo extends CrudRepository<PlaceEntity, Integer> {

}
