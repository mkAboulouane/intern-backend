package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Image;
import com.fst.sir.bean.ProduitBio;
import com.fst.sir.dao.ProduitBioDao;
import com.fst.sir.service.admin.facade.ImageAdminService;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import com.fst.sir.ws.rest.provided.facade.admin.ImageRestAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProduitBioAdminServiceImpl implements ProduitBioAdminService {

    @Autowired
    private ProduitBioDao produitBioDao;
    @Autowired
    private ImageAdminService imageAdminService;


    @Override
    public ProduitBio findById(Long id) {
        return produitBioDao.findById(id).get();
    }

    @Override
    public ProduitBio save(ProduitBio produitBio, String imageName) {
        Image image1 = imageAdminService.findByName(imageName);
        if(image1 == null) return null;
        else {
            produitBio.setImagePrincipal(image1);
            produitBio.setAddedAt(new Date());
            return produitBioDao.save(produitBio);
        }
    }

    @Override
    public ProduitBio save(ProduitBio produitBio) {
        ProduitBio produitBio1 = findByNom(produitBio.getNom());
        if (produitBio1 == null) {
//            if(produitBio.getImagePrincipal()!=null){
//                produitBio.setImagePrincipal(imageRestAdmin.save(produitBio.getImagePrincipal()));
//                produitBio.getImages().forEach(e->imageAdminService.save(e));
//            }

            produitBio.setAddedAt(new Date());
            return produitBioDao.save(produitBio);
        } else return null;
    }


    @Override
    public ProduitBio findByNom(String nom) {
        return produitBioDao.findByNom(nom);
    }

    @Override
    public List<ProduitBio> findAll() {
        return produitBioDao.findAll();
    }

    @Override
    public int deleteByNom(String nom) {
        return produitBioDao.deleteByNom(nom);
    }


    @Override
    public ProduitBio update(ProduitBio produitBio) {
        ProduitBio produitBio1 = findByNom(produitBio.getNom());
        if (produitBio1 != null) {
            produitBio.setUpdatedAt(new Date());
            produitBio.setAddedAt(produitBio1.getAddedAt());
            produitBio.setId(produitBio1.getId());
            return produitBioDao.save(produitBio);
        } else return null;
    }
}
