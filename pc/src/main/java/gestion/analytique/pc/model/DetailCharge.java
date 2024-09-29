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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "detail_charge")
public class DetailCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_charge_detail;

    private Double montant;

    private String cles_repartition;

    private LocalDate date_charge;

    @ManyToOne
    @JoinColumn(name = "id_nature", nullable = false)
    private Nature nature;

    @ManyToOne
    @JoinColumn(name = "id_centre", nullable = false)
    private Centre centre;

    @ManyToOne
    @JoinColumn(name = "id_charge", nullable = false)
    private Charge charge;

    @Builder
    public DetailCharge(Double montant, String cles_repartition, Nature nature, Centre centre, Charge charge, LocalDate date_charge) {
        this.montant = montant;
        this.cles_repartition = cles_repartition;
        this.nature = nature;
        this.centre = centre;
        this.charge = charge;
        this.date_charge = date_charge;
    }

    public void setDateCharge(String dateString) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            this.date_charge = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd");
        }
    }

    public void setMontant(String montantString) throws IllegalArgumentException {
        try {
            Double montant = Double.parseDouble(montantString);
            if (montant > 0) {
                this.montant = montant;
            } else {
                throw new IllegalArgumentException("Montant must be greater than 0");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid montant format");
        }
    }
}
