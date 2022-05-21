package com.fst.sir.bean;


import com.fst.sir.bean.Panier;
import com.fst.sir.bean.ProduitBio;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor @AllArgsConstructor
public class ProduitPanierItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double prix;

    @OneToOne
    private ProduitBio produitBio;

    private int quantite;

    @ManyToOne
    private Panier panier;

}