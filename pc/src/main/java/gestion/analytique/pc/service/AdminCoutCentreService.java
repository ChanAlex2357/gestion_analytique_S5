package gestion.analytique.pc.service;

import gestion.analytique.pc.model.*;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.function.ToDoubleFunction;

@Service
@Data
public class AdminCoutCentreService {

    private CoutCentreService coutCentreService;
    private AdminCoutCentre adminCoutCentre;
    
    @Autowired
    public AdminCoutCentreService(CoutCentreService coutCentreService){
        this.coutCentreService = coutCentreService;
        this.adminCoutCentre = createAdminCoutCentres(null); 
    }
    public AdminCoutCentre createAdminCoutCentres(Exercice exercice) {
        adminCoutCentre = coutCentreService.getAllCoutCentres(exercice);
        adminCoutCentre.setSommeOperationnelle(getSommeOperationnelle());
        System.err.println("SSSSSSSSSSSSSSS");
        adminCoutCentre.setSommeStructurelle(getSommeStructurelle());

        List<CoutCentre> operationnelles = getCoutCentresOperationnelle();
        setClesOperationnelle(operationnelles);
        for (CoutCentre coutCentre : operationnelles) {
            setCoutTotalCentre(coutCentre);
        }
        adminCoutCentre.setSommeCoutTotal( getSommeCoutTotal(operationnelles));
        return adminCoutCentre;
    }

    private List<CoutCentre> getCoutCentresByType(String typeName) {
        return adminCoutCentre.getCoutCentres().entrySet().stream()
                .filter(entry -> entry.getKey().getName().equalsIgnoreCase(typeName))
                .flatMap(entry -> entry.getValue().stream())
                .toList();
    }

    public double getSommeOperationnelle() {
        // if (adminCoutCentre.getSommeOperationnelle() != 0.0) {
        //     return adminCoutCentre.getSommeOperationnelle();
        // }
        double sommeOperationnelle = getCoutCentresOperationnelle().stream()
                .mapToDouble(CoutCentre::getCoutDirectTotal)
                .sum();

        adminCoutCentre.setSommeOperationnelle(sommeOperationnelle);
        return sommeOperationnelle;
    }

    public double getSommeStructurelle() {
        // if (adminCoutCentre.getSommeStructurelle() != 0.0) {
        //     return adminCoutCentre.getSommeStructurelle();
        // }
        double sommeStructurelle = getCoutCentresStructurelle().stream()
                .mapToDouble(CoutCentre::getCoutDirectTotal)
                .sum();

        adminCoutCentre.setSommeStructurelle(sommeStructurelle);
        return sommeStructurelle;
    }

    public List<CoutCentre> getCoutCentresOperationnelle() {
        return getCoutCentresByType("Opérationnelle");
    }

    public List<CoutCentre> getCoutCentresStructurelle() {
        return getCoutCentresByType("Structurelle");
    }
    // Genere les cles pour les centres operationnelles
    public void setClesOperationnelle(List<CoutCentre> operationnelle) {
        double sommeOperationnelle = adminCoutCentre.getSommeOperationnelle();
        operationnelle.forEach(coutCentre -> coutCentre.setCles(coutCentre.getCoutDirectTotal() / sommeOperationnelle));
    }

    public void setCoutTotalCentre(CoutCentre coutCentre) {
        if (coutCentre.getCoutTotal() == null || coutCentre.getCoutTotal() == 0.0) {
            double coutTotal = coutCentre.getCoutDirectTotal() + getPartStructurelle(coutCentre);
            coutCentre.setCoutTotal(coutTotal);
        }
    }

    public double getPartStructurelle(CoutCentre coutCentre) {
        return coutCentre.getCles() * adminCoutCentre.getSommeStructurelle();
    }

    public double getSommeCoutTotal(List<CoutCentre> operationnelles) {
        return calculateSum(operationnelles, CoutCentre::getCoutTotal);
    }

    private double calculateSum(List<CoutCentre> centres, ToDoubleFunction<CoutCentre> extractor) {
        return centres.stream().mapToDouble(extractor).sum();
    }

}