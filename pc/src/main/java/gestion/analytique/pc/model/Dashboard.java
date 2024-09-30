package gestion.analytique.pc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dashboard {
    private AdminCoutCentre adminCoutCentre;
    private AdminDetailCharge adminDetailCharge;
    private AdminCoutProduction adminCoutProduction;
}
