package com.example.stage_back.dao;

import com.example.stage_back.bean.ProduitBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitBioDao extends JpaRepository<ProduitBio, Long> {

}
