package com.example.stage_back.dao;

import com.example.stage_back.bean.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaimentDao extends JpaRepository<Paiment,Long> {

}
