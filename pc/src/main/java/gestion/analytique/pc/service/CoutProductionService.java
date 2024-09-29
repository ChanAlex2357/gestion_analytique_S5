package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class CoutProductionService {
    private AdminCoutCentreService adminCoutCentreService;
    private ProductionService productionService;
    private CentreProductionService centreProductionService;

}
