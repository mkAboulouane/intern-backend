package com.fst.sir.dao;

import com.fst.sir.bean.Paiment;
import com.fst.sir.enums.TypePaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaimentDao extends JpaRepository<Paiment, Long> {
    @Query("SELECT item FROM Paiment item ORDER BY item.id DESC")
    List<Paiment> findAll();

    List<Paiment> findByTypePaiment(TypePaiment typePaiment);

    List<Paiment> findByPanierUserUsername(String username);

    Paiment findByReference(String reference);

    int deleteByReference(String reference);


}
