package gestion.analytique.pc.model;

// All the imports
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rubrique")
public class Rubrique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rubrique;

    private String name; 

    @ManyToOne
    @JoinColumn(name = "id_unit_oeuvre")
    private UnitOeuvre unitOeuvre; 

    @ManyToOne
    @JoinColumn(name = "id_nature")
    private Nature nature; 

    // Constructor with Builder
    @Builder
    public Rubrique(String name, UnitOeuvre unitOeuvre, Nature nature) {
        this.name = name;
        this.unitOeuvre = unitOeuvre;
        this.nature = nature;
    }
}
