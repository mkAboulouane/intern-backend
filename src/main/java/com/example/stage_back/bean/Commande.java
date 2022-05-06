package com.example.stage_back.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client c;

    @OneToMany
    private java.util.List<Formation> formations;

    @OneToMany
    private java.util.List<ProduitBio> produitBios;

    @ManyToOne
    private Client client;

    @OneToOne(mappedBy = "commande" )
    private Paiment paiment;

    private double prixTotal;


}
