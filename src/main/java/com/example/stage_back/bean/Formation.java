package com.example.stage_back.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FORMATION")
@Data @NoArgsConstructor @AllArgsConstructor
public class Formation extends Reunion {
    private Double prix;
    private Integer nombrePlace;
}
