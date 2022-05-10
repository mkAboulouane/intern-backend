package com.fst.sir.dao;

import com.fst.sir.bean.Paiment;
import com.fst.sir.enums.TypePaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaimentDao extends JpaRepository<Paiment,Long> {

//    List<Paiment> findByClientUsername(String username);

    List<Paiment> findByTypePaiment(TypePaiment typePaiment);

//    List<Paiment> findByPrixGreaterThanAndLessThan(double min, double max);

    Paiment findByCommandeReference(String reference);
    int deleteByCommandeReference(String reference);

//    int deleteByClientUsername(String username);


}
