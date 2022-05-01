package com.example.stage_back.dao;

import com.example.stage_back.bean.Congres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongresDao extends JpaRepository<Congres,Long> {
}
