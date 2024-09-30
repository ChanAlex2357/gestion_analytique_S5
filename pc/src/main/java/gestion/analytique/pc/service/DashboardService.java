package gestion.analytique.pc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.analytique.pc.model.AdminCoutCentre;
import gestion.analytique.pc.model.AdminCoutProduction;
import gestion.analytique.pc.model.AdminDetailCharge;
import gestion.analytique.pc.model.Dashboard;
import gestion.analytique.pc.repository.DetailChargeRepository;
import lombok.Data;

@Service
@Data
public class DashboardService {
    private DetailChargeService detailChargeService;
    private CoutProductionService coutProductionService;
    private AdminCoutCentreService coutCentreService;
    @Autowired
    public DashboardService( DetailChargeRepository detailChargeRepository , CoutCentreService coutCentreService , ProductionService productionService , CentreProductionService centreProductionService ){
        setDetailChargeService(new DetailChargeService(detailChargeRepository));
        setCoutCentreService(new AdminCoutCentreService(coutCentreService));
        setCoutProductionService(new CoutProductionService(coutCentreService,productionService,centreProductionService));
    }

    public Dashboard getDashboard(){
        AdminCoutCentre adminCoutCentre = getCoutCentreService().getAdminCoutCentre();
        AdminDetailCharge adminDetailCharge = getDetailChargeService().getAdminDetailCharge(); 
        AdminCoutProduction adminCoutProduction = getCoutProductionService().getAdmCoutProductions( adminCoutCentre.getAllCoutCentres());
        return new Dashboard(
            adminCoutCentre,
            adminDetailCharge,
            adminCoutProduction
        );
    }

}
