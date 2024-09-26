package gestion.analytique.pc.service;

import gestion.analytique.pc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminCoutCentreService {

    @Autowired
    private CoutCentreService coutCentreService;

    @Transactional(readOnly = true)
    public AdminCoutCentre getAdminCoutCentres(Exercice exercice) {
        List<ViewCoutCentre> viewCentres = coutCentreService.getAllByExercice(exercice);
        HashMap<TypeCentre, List<CoutCentre>> coutCentres = coutCentreService.getCoutCentres(viewCentres, exercice);
        AdminCoutCentre adminCoutCentre = AdminCoutCentre.builder()
        .exercice(exercice)
        .coutCentres(coutCentres)
        .build();
        adminCoutCentre.setSommeOperationnelle(adminCoutCentre.getSommeOperationnelle());
        adminCoutCentre.setSommeStructurelle(adminCoutCentre.getSommeStructurelle());
        return adminCoutCentre;
    }    
}