package com.sangamone.uploadcsv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StateUploadRepo extends CrudRepository<StateEntity,Integer> {

}
