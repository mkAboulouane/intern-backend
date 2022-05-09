package fst.sir.stage_back.bean;


import fst.sir.stage_back.security.bean.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Entity
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "client")
public class Client {


    private String photo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(length = 500)
    private String emailPrincipale;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String resume;
    @Column(length = 500)
    private String natureImplication;
    @Column(columnDefinition = "boolean default false")
    private Boolean formationEnManagement = false;
    @Column(columnDefinition = "boolean default false")
    private boolean credentialsNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean enabled = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private boolean accountNonLocked = false;
    @Column(columnDefinition = "boolean default false")
    private boolean passwordChanged = false;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;



//    @OneToMany(mappedBy = "client")
//    @ToString.Exclude
//    private List<Commande> commandes;
//
//    @OneToMany(mappedBy = "client")
//    @ToString.Exclude
//    private List<Paiment> paiments;


    // kafka

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Client client = (Client) o;
//        return id != null && Objects.equals(id, client.id);
//    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
