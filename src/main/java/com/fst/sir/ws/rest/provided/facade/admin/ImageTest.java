package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.ProduitBio;
import org.springframework.web.multipart.MultipartFile;

public class ImageTest {

    private MultipartFile file;
    private ProduitBio produitBio;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public ProduitBio getProduitBio() {
        return produitBio;
    }

    public void setProduitBio(ProduitBio produitBio) {
        this.produitBio = produitBio;
    }
}
