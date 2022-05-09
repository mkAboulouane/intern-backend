package fst.sir.stage_back.bean;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("FORMATION")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
 @AllArgsConstructor
public class Formation extends Reunion {
    private double prix;
    private int nombrePlace;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Formation formation = (Formation) o;
        return getId() != null && Objects.equals(getId(), formation.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
