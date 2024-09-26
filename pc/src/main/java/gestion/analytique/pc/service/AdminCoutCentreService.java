package gestion.analytique.pc.service;

import gestion.analytique.pc.model.*;
import gestion.analytique.pc.repository.CentreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AdminCoutCentreService {
    @Autowired
    private final DetailChargeService detailChargeservice;
    @Autowired
    private final CentreService centreService;

    public List<CoutCentre> getCoutCentres(Exercice exercice) {
        List<DetailCharge> detailCharges = detailChargeservice.getAllByExercice(exercice);
        return coutCentres;
    }

    private CoutCentre createCoutCentre(Exercice exercice, Centre centre, Map<NatureCharge, Double> natureMontantMap) {
        CoutCentre coutCentre = new CoutCentre();
        coutCentre.setExercice(exercice);
        coutCentre.setCentre(centre);
        coutCentre.setNatureMontant(natureMontantMap);
        coutCentre.setCoutDirectTotal();
        return coutCentre;
    }
}