package fst.sir.stage_back.bean;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("CONGRE")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Congres extends Reunion {
    private String lieu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Congres congres = (Congres) o;
        return getId() != null && Objects.equals(getId(), congres.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
