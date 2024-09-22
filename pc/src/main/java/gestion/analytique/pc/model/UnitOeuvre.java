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
@Table(name = "unit_oeuvre") 
public class UnitOeuvre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unit_oeuvre;

    private String name;

    // Constructor 
    @Builder
    public UnitOeuvre(int unit_oeuvre, String name) {
        this.unit_oeuvre = unit_oeuvre;
        this.name = name;
    }
}
