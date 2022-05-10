package com.fst.sir.bean;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 10,discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Reunion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String encadrantProf;
    @Lob
    private String description;
    private String duree;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reunion reunion = (Reunion) o;
        return id != null && Objects.equals(id, reunion.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
