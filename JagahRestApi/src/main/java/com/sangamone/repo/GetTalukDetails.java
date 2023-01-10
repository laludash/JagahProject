package com.sangamone.repo;

import java.util.List;

import com.sangamone.entity.Taluks;

public interface GetTalukDetails {

	
	List<Taluks> findByTalukId(int taluk_id);
}
