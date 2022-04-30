package com.example.stage_back.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONGRE")
@Data @NoArgsConstructor @AllArgsConstructor
public class Congres extends Reunion {
    private String lieu;
}
