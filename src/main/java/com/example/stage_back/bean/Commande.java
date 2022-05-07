package com.example.stage_back.bean;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

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
