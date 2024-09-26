package gestion.analytique.pc.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "v_cout_centre")
@Getter
@Setter
@NoArgsConstructor
public class ViewCoutCentre {
    @ManyToOne
    @JoinColumn(name = "id_centre", nullable = false)
    private Centre centre;

    @ManyToOne
    @JoinColumn(name = "id_nature", nullable = false)
    private Nature natureCharge;

    @Column(name = "montant")
    private Double montant;

    @Builder
    public ViewCoutCentre(Centre centre, Nature natureCharge, Double montant) {
        this.centre = centre;
        this.natureCharge = natureCharge;
        this.montant = montant;
    }
}