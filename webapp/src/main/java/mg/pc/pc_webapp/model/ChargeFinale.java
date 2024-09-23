package mg.pc.pc_webapp.model;

import lombok.Data;

@Data
public class ChargeFinale {

    private int id_charge_finale;
    private Rubrique rubrique;

    private double total_montant;

    public ChargeFinale(Rubrique rubrique, double total_montant) {
        this.rubrique = rubrique;
        this.total_montant = total_montant;
    }
}
