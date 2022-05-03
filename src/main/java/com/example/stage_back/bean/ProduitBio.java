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
    public class ProduitBio implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nom;
        private String type;
        @Lob
        private String labele;
        private Integer QuantiteDisponible;


    }
