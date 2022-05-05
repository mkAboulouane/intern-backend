package com.example.stage_back.dao;

import com.example.stage_back.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {
    Client findByEmail(String email);
    Client findByReference(String reference);
     int deleteByReference(String reference);
     int deleteByEmail(String email);



}