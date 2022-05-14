package com.fst.sir.bean;

import com.fst.sir.security.bean.User;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToOne
    private Formation formation;

    @OneToOne
    private ProduitBio produitBio;

    private int quantiteProduit;

}
