package com.example.stage_back.dao;

import com.example.stage_back.bean.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem,Long> {


}
