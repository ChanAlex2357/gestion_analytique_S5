package gestion.analytique.pc.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "centre")
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_centre;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_type_centre", nullable = false)
    private TypeCentre typeCentre;

    @ManyToOne
    @JoinColumn(name = "id_unit_oeuvre", nullable = false)
    private UnitOeuvre unitOeuvre;

    @Builder
    public Centre(String name, TypeCentre typeCentre, UnitOeuvre unitOeuvre) {
        this.name = name;
        this.typeCentre = typeCentre;
        this.unitOeuvre = unitOeuvre;
    }
}
