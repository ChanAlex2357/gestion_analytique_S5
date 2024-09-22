package gestion.analytique.pc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "coutcentre")
public class CoutCentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_centre;

    private double total_cout_fixe;
    private double total_cout_variable;
    private double total_cout_centre;

    // Constructor
    @Builder
    public CoutCentre(double total_cout_fixe, double total_cout_variable, double total_cout_centre) {
        this.total_cout_fixe = total_cout_fixe;
        this.total_cout_variable = total_cout_variable;
        this.total_cout_centre = total_cout_centre;
    }
}
