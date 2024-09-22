package gestion.analytique.pc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "type_centre")
public class TypeCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_centre;

    private String name;

    @Builder
    public TypeCentre(String name) {
        this.name = name;
    }
}
