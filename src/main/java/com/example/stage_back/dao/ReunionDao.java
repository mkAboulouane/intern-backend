package com.example.stage_back.dao;

import com.example.stage_back.bean.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReunionDao extends JpaRepository<Reunion, Long> {

}

