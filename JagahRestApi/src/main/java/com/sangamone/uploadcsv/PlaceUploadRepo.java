package com.sangamone.uploadcsv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
@Repository
public interface PlaceUploadRepo extends CrudRepository<PlaceEntity, Integer> {

	

	

}
