package com.sangamone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangamone.entity.MasterTable;

public interface MasterTableRepo extends JpaRepository<MasterTable, Integer> {

}
