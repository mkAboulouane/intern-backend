package com.fst.sir.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProduitBio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private boolean promotion;
    private boolean visible;

    private int quantity;

    private boolean available;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date addedAt;

    @Lob
    private String description;
    private String photos;
    private double prix;
    private double prixAncien;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @OneToOne
    private Image imagePrincipal;

    public ProduitBio(Long id, String nom, boolean promotion, boolean visible, int quantity, boolean available, Date addedAt, String description, String photos, double prix, double prixAncien, Date updatedAt, Image imagePrincipal) {
        this.id = id;
        this.nom = nom;
        this.promotion = promotion;
        this.visible = visible;
        this.quantity = quantity;
        this.available = available;
        this.addedAt = addedAt;
        this.description = description;
        this.photos = photos;
        this.prix = prix;
        this.prixAncien = prixAncien;
        this.updatedAt = updatedAt;
        this.imagePrincipal = imagePrincipal;
    }

    public ProduitBio(Long id, String nom, boolean promotion, boolean visible, boolean available, Date addedAt, String description, String photos, double prix, double prixAncien, Date updatedAt, Image imagePrincipal) {
        this.id = id;
        this.nom = nom;
        this.promotion = promotion;
        this.visible = visible;
        this.available = available;
        this.addedAt = addedAt;
        this.description = description;
        this.photos = photos;
        this.prix = prix;
        this.prixAncien = prixAncien;
        this.updatedAt = updatedAt;
        this.imagePrincipal = imagePrincipal;
    }

    public ProduitBio(Long id, String nom, boolean promotion, boolean visible, boolean available, Date addedAt, String description, String photos, double prix, double prixAncien, Date updatedAt) {
        this.id = id;
        this.nom = nom;
        this.promotion = promotion;
        this.visible = visible;
        this.available = available;
        this.addedAt = addedAt;
        this.description = description;
        this.photos = photos;
        this.prix = prix;
        this.prixAncien = prixAncien;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProduitBio that = (ProduitBio) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
