package fst.sir.com.dao;

import fst.sir.com.bean.ProduitBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitBioDao extends JpaRepository<ProduitBio, Long> {

    List<ProduitBio> findByNom(String nom);

}
