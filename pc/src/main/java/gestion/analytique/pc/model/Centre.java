package gestion.analytique.pc.model;

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
@Table(name = "centre")
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_centre;

    @ManyToOne
    @JoinColumn(name = "id_type_centre", nullable = false)
    private TypeCentre typeCentre;

    @ManyToOne
    @JoinColumn(name = "id_unit_oeuvre", nullable = false)
    private UnitOeuvre unitOeuvre;

    private String name;

    @Builder
    public Centre(TypeCentre typeCentre, String name) {
        this.typeCentre = typeCentre;
        this.name = name;
    }
}
