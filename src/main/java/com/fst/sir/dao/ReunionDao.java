package com.fst.sir.dao;

import com.fst.sir.bean.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReunionDao extends JpaRepository<Reunion, Long> {

    @Query("SELECT item FROM Reunion item ORDER BY item.id DESC ")
    List<Reunion> findAll();

    @Query("SELECT item FROM Reunion item WHERE item.visible=true ORDER BY item.id DESC ")
    List<Reunion> findAllVisible();


}

