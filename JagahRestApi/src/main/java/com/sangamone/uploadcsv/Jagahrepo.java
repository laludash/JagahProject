package com.sangamone.uploadcsv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Jagahrepo extends JpaRepository<Jagahentity, Integer> {

}