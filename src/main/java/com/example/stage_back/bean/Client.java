package com.example.stage_back.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "client")
public class Client {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String reference;
  private String email;
  private String nom;
  private String prenom;

   @Column(columnDefinition = "boolean default true")
  private Boolean active=true;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date createdAt;

}
