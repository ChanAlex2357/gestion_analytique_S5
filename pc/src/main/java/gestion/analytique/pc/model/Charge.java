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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "charge")
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_charge;

    @ManyToOne
    @JoinColumn(name = "id_rubrique")
    private Rubrique rubrique;

    private double total_montant;

    private LocalDate date_charge;

    @ManyToOne
    @JoinColumn(name = "id_charge_detail", nullable = false)
    private DetailCharge detail_charge;

    public void setMontant(String montantString) {
        try {
            double montant = Double.parseDouble(montantString);
            
            if (montant <= 0) {
                throw new IllegalArgumentException("Montant must be greater than zero.");
            }
            
            this.total_montant = montant;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid montant format. Please enter a valid number.", e);
        }
    }

    public void setDateCharge(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            this.date_charge = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD.", e);
        }
    }
    @Builder
    public Charge(Rubrique rubrique, double total_montant) {
        this.rubrique = rubrique;
        this.total_montant = total_montant;
    }
}
