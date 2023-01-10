package com.sangamone.repo;

import java.util.List;

import com.sangamone.entity.Places;

public interface GetPlaceDetails {

	List<Places> findByPlacesId(int place_id);
}
