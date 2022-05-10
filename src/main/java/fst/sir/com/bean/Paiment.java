package fst.sir.com.bean;


import fst.sir.com.enums.TypePaiment;
import com.fasterxml.jackson.annotation.JsonFormat;
import fst.sir.com.security.bean.User;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Paiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prix;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date payedAt;

    @Enumerated(EnumType.STRING)
    private TypePaiment typePaiment;


    @OneToOne
    private Commande commande;

    @ManyToOne
    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Paiment paiment = (Paiment) o;
        return id != null && Objects.equals(id, paiment.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
