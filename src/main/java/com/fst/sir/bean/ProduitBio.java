package com.fst.sir.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ProduitBio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private boolean promotion;
    private boolean visible;
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

    @OneToMany(mappedBy = "produitBio",fetch = FetchType.EAGER)
    private List<Image> images;

    public ProduitBio(Long id, String nom, boolean promotion, boolean visible, boolean available, Date addedAt,String description, String photos, double prix, double prixAncien, Date updatedAt) {
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
