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
@Table(name = "charge_finale")
public class ChargeFinale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_charge_finale;

    @ManyToOne
    @JoinColumn(name = "id_rubrique")
    private Rubrique rubrique;

    private double total_montant;

    @Builder
    public ChargeFinale(Rubrique rubrique, double total_montant) {
        this.rubrique = rubrique;
        this.total_montant = total_montant;
    }
}
