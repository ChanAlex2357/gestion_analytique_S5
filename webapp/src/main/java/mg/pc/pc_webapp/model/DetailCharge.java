package mg.pc.pc_webapp.model;

import lombok.Data;

@Data
public class DetailCharge {

    private int id_charge_detail;

    private Rubrique rubrique;

    private Centre centre;

    private double montant;

    public DetailCharge(Rubrique rubrique, Centre centre, double montant) {
        this.rubrique = rubrique;
        this.centre = centre;
        this.montant = montant;
    }
}
