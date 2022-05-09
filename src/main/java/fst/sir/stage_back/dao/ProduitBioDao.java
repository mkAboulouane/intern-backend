package fst.sir.stage_back.dao;

import fst.sir.stage_back.bean.ProduitBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitBioDao extends JpaRepository<ProduitBio, Long> {

    List<ProduitBio> findByNom(String nom);

}
