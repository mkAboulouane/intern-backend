package com.fst.sir.bean;


import lombok.Data;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private BigDecimal total;
    private Date addedAt;
    private Date payeAt;
    private boolean paye;


    @OneToOne
    private Formation formation;

    @OneToOne
    private ProduitBio produitBio;

    @ManyToOne
    private com.fst.sir.security.bean.User user;


}
