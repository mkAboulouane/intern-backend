package com.fst.sir.dao;

import com.fst.sir.bean.ProduitPanierItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProduitPanierItemDao extends JpaRepository<ProduitPanierItem, Long> {

    @Query("SELECT item FROM ProduitPanierItem item ORDER BY item.id DESC ")
    List<ProduitPanierItem> findAll();


}
