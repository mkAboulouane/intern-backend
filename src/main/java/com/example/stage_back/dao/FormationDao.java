package com.example.stage_back.dao;

import com.example.stage_back.bean.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormationDao extends JpaRepository<Formation,Long> {

}
