package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Image;
import com.fst.sir.bean.ProduitBio;
import com.fst.sir.config.FileUtils;
import com.fst.sir.dao.ImageDao;
import com.fst.sir.dao.ProduitBioDao;
import com.fst.sir.service.admin.facade.ImageAdminService;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import com.fst.sir.ws.rest.provided.facade.admin.ImageRestAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public int save(ProduitBio produitBio, long id) {
        Image image = imageAdminService.findById(id);
        ProduitBio foundByName = findByNom(produitBio.getNom());
         if(foundByName != null) {
             imageAdminService.delete(id);
             return -1;
         }
        else if(image == null) return -2;
        else {
            produitBio.setImagePrincipal(image);
            produitBio.setAddedAt(new Date());
            produitBioDao.save(produitBio);
            return 1;
        }
    }



    @Override
    public ProduitBio save(ProduitBio produitBio) {
        ProduitBio foundedByNom = findByNom(produitBio.getNom());
        Image image = imageAdminService.findByName(produitBio.getImagePrincipal().getName());
        if (foundedByNom != null || image != null ) {
            return null;
        }else {
            long id = imageAdminService.save(produitBio.getImagePrincipal());
            Image foundedById = imageAdminService.findById(id);
            produitBio.setAddedAt(new Date());
            produitBio.setImagePrincipal(foundedById);
            return produitBioDao.save(produitBio);
        }
    }


    @Override
    public ProduitBio findByNom(String nom) {
        return produitBioDao.findByNom(nom);
    }

    @Override
    public List<ProduitBio> findAll() {
        List<ProduitBio> getAll = produitBioDao.findAll();
        List<ProduitBio> result = new ArrayList<>();
        getAll.forEach(e -> {
            result.add(new ProduitBio(e.getId(),e.getNom(),e.isPromotion(),e.isVisible(),e.getQuantity(),e.isAvailable(),e.getAddedAt(),e.getDescription(),e.getPhotos(),e.getPrix(),e.getPrixAncien(),e.getUpdatedAt(),new Image(e.getImagePrincipal().getId(),e.getImagePrincipal().getName(),e.getImagePrincipal().getType(),FileUtils.decompressBytes(e.getImagePrincipal().getPicByte()))));
        });
        return result;
    }
//    }    @Override
//    public List<ProduitBio> findAll() {
//        List<ProduitBio> getAll = produitBioDao.findAll();
//        List<ProduitBio> clone = getAll;
//        List<ProduitBio> result = new ArrayList<>();
//        clone.forEach(e->{
//            e.getImagePrincipal().setPicByte(FileUtils.decompressBytes(e.getImagePrincipal().getPicByte()));
//            result.add(e);
//        });
//        return result;
//    }

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
