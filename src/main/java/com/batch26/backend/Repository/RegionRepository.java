package com.batch26.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.batch26.backend.Model.Region;

public interface RegionRepository extends JpaRepository<Region, Integer>{
    @Query(value = "SELECT * FROM tb_m_region WHERE name = ?1", nativeQuery = true)
    public Region findbyName(String name);
    
}
