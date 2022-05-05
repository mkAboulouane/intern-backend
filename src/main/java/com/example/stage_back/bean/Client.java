package com.example.stage_back.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client implements Serializable {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String reference;
  private String email;
  private String nom;
  private String prenom;

  private String photo;
  @Column(columnDefinition = "boolean default true")
  private Boolean active=true;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date createdAt;

  @OneToMany(mappedBy = "client")
  private java.util.List<Commande> commandes;

  @OneToMany(mappedBy = "client")
  private java.util.List<Paiment> paiments;




}
