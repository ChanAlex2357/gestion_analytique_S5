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

@Entity
@Table(name = "repartition_charge_centre")
@Getter
@Setter
@NoArgsConstructor
public class RepartiChargeCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_repartition_charge_centre;

    @ManyToOne
    @JoinColumn(name = "id_centre", nullable = false)
    private Centre centre;

    @ManyToOne
    @JoinColumn(name = "id_rubrique", nullable = false)
    private Rubrique rubrique;

    private Double pourcentage;

    @Builder
    public RepartiChargeCentre(Centre centre, Rubrique rubrique, Double pourcentage) {
        this.centre = centre;
        this.rubrique = rubrique;
        this.pourcentage = pourcentage;
    }
}