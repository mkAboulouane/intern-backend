package fst.sir.stage_back.dao;

import fst.sir.stage_back.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {

    @Query("SELECT item FROM Commande item ORDER BY item.dateCommande ASC")
    List<Commande> findAll();

    Commande findByReference(String reference);

    int deleteByReference(String reference);
//
//    List<Commande> findByClientUsername(String username);
//    List<Commande> findByClientId(Long id);
//
//
//    int deleteByClientUsername(String username);



}
