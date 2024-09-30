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
@Table(name = "unitoeuvre") 
public class UnitOeuvre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_unit_oeuvre;

    private String name;

    // Constructor 
    @Builder
    public UnitOeuvre(Integer unitOeuvre, String name) {
        this.id_unit_oeuvre = unitOeuvre;
        this.name = name;
    }
}
