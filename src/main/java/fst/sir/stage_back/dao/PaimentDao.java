package fst.sir.stage_back.dao;

import fst.sir.stage_back.bean.Paiment;
import fst.sir.stage_back.enums.TypePaiment;
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
