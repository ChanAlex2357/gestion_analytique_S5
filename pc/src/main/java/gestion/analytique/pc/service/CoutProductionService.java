package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.CoutCentre;
import gestion.analytique.pc.model.Production;
import gestion.analytique.pc.repository.CoutCentreRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoutCentreService {

    private final CoutCentreRepository repository;

    @Autowired
    public CoutCentreService(CoutCentreRepository repository) {
        this.repository = repository;
    }

    public ArrayList<CoutCentre> getCoutCentresByProduction(Production production) {
        
        List<CoutCentre> coutCentres = repository.findCoutCentresByProduction(production);
        return new ArrayList<>(coutCentres);
    }
}
