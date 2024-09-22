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
@Table(name = "detail_charge")
public class DetailCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_charge_detail;

    @ManyToOne
    @JoinColumn(name = "id_rubrique")
    private Rubrique rubrique;

    @ManyToOne
    @JoinColumn(name = "id_centre")
    private Centre centre;

    @ManyToOne
    @JoinColumn(name = "id_nature")
    private Nature nature;

    private double montant;

    @Builder
    public DetailCharge(Rubrique rubrique, Centre centre, Nature nature, double montant) {
        this.rubrique = rubrique;
        this.centre = centre;
        this.nature = nature;
        this.montant = montant;
    }
}
