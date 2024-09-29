package gestion.analytique.pc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "charge")
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_charge;

    private double total_montant;

    private LocalDate date_charge;

    @ManyToOne
    @JoinColumn(name = "id_rubrique", nullable = false)
    private Rubrique rubrique;

    @Builder
    public Charge(double total_montant, LocalDate date_charge, Rubrique rubrique) {
        this.total_montant = total_montant;
        this.date_charge = date_charge;
        this.rubrique = rubrique;
    }
}
