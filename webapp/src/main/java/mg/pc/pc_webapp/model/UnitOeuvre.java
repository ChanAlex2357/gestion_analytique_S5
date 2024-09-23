package mg.pc.pc_webapp.model;

import lombok.Data;

@Data
public class UnitOeuvre {

    private int unit_oeuvre;

    private String name;

    public UnitOeuvre(int unit_oeuvre, String name) {
        this.unit_oeuvre = unit_oeuvre;
        this.name = name;
    }
}
