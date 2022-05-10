package com.fst.sir.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fst.sir.enums.EtatCommande;
import com.fst.sir.security.bean.User;
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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    private EtatCommande etatCommande;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCommande;

    @ManyToOne
    private User user;

    @ManyToMany
    @ToString.Exclude
    private List<Formation> formations;

    @ManyToMany
    @ToString.Exclude
    private List<ProduitBio> produitBios;

    @OneToOne(mappedBy = "commande" )
    private Paiment paiment;

    private double prixTotal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Commande commande = (Commande) o;
        return id != null && Objects.equals(id, commande.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
