package gestion.analytique.pc.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDetailCharge {
    List<DetailCharge> detailCharges;
    
    public AdminDetailCharge(List<DetailCharge> detailCharges) {
        setDetailCharges(detailCharges);
    }
}
