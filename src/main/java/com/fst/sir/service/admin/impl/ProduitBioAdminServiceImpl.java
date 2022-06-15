package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Image;
import com.fst.sir.bean.ProduitBio;
import com.fst.sir.config.FileUtils;
import com.fst.sir.dao.ProduitBioDao;
import com.fst.sir.service.admin.facade.ImageAdminService;
import com.fst.sir.service.admin.facade.ProduitBioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProduitBioAdminServiceImpl implements ProduitBioAdminService {

    @Autowired
    private ProduitBioDao produitBioDao;
    @Autowired
    private ImageAdminService imageAdminService;

    @Override
    public List<ProduitBio> voirAussi(Long existId) {
        Random rand = new Random();
        List<Long> allId = produitBioDao.getAllId();
        List<ProduitBio> result = new ArrayList<>();
        allId.remove(existId);

        int nmbreElement = 4;

        for (int i = 0; i < nmbreElement; i++) {
            int randomIndex = rand.nextInt(allId.size());
            Long id = allId.get(randomIndex);
            result.add(findById(id));
            allId.remove(randomIndex);
        }
        return result;



   /*     List<Long> allId = produitBioDao.getAllId();
        List<ProduitBio> result = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(0);

        allId.stream().filter(e-> !Objects.equals(e, existId) && count.get() <= 3).forEach(e->{
            int i = (int) (Math.random() * allId.size());
            if(allId.contains(allId.get(i)) && i != existId) {
                result.add(findById(allId.get(i)));
                count.addAndGet(1);
            }
        });*/

 /*       List<ProduitBio> all = produitBioDao.findAll();
        List<ProduitBio> result = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(0);
      all.stream().filter(e-> !Objects.equals(e.getId(), existId) && count.get() <= 3).forEach(e->{
            result.add(findById(e.getId()));
            count.addAndGet(1);
        });*/
    }





    @Override
    public ProduitBio findById(Long id) {
        ProduitBio produit = produitBioDao.findById(id).get();
        produit.getImagePrincipal().setPicByte(FileUtils.decompressBytes(produit.getImagePrincipal().getPicByte()));
        return produit;
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
        getAll.stream().filter(Objects::nonNull).forEach(e ->
            result.add(new ProduitBio(e.getId(),e.getNom(),e.isPromotion(),e.isVisible(),e.isAvailable(),e.getAddedAt(),e.getDescription(),e.getPhotos(),e.getPrix(),e.getPrixAncien(),e.getUpdatedAt(),new Image(e.getImagePrincipal().getId(),e.getImagePrincipal().getName(),e.getImagePrincipal().getType(),FileUtils.decompressBytes(e.getImagePrincipal().getPicByte()))))
        );
        return result;
    }
    @Override
    @Transactional
    public int deleteById(Long id) {
         produitBioDao.deleteByImagePrincipalId(id);
        produitBioDao.deleteById(id);

        return 1;
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
