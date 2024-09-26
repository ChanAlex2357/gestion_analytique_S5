package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.DetailCharge;
import gestion.analytique.pc.model.Nature;
import gestion.analytique.pc.model.Rubrique;
import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.model.Charge;
import gestion.analytique.pc.model.CoutCentre;
import gestion.analytique.pc.service.DetailChargeService;
import gestion.analytique.pc.service.RubriqueService;
import gestion.analytique.pc.service.CentreService;
import gestion.analytique.pc.service.ChargeFinaleService;
import gestion.analytique.pc.service.CoutCentreService;
import gestion.analytique.pc.service.NatureService;

import java.util.List;

@RestController
@RequestMapping("/detailcharge")
public class DetailChargeController {
    private final DetailChargeService detailChargeService;
    private final RubriqueService rubriqueService;
    private final CentreService centreService;
    private final ChargeFinaleService chargeFinaleService;
    private final CoutCentreService coutCentreService;
    private final NatureService natureService;

    @Autowired
    public DetailChargeController(DetailChargeService detailChargeService,
            RubriqueService rubriqueService,
            CentreService centreService,
            ChargeFinaleService chargeFinaleService, CoutCentreService CoutCentreService, NatureService natureService) {
        this.detailChargeService = detailChargeService;
        this.rubriqueService = rubriqueService;
        this.centreService = centreService;
        this.chargeFinaleService = chargeFinaleService;
        this.coutCentreService = CoutCentreService;
        this.natureService = natureService;
    }

    @GetMapping
    public List<DetailCharge> getAll() {
        return detailChargeService.getAll();
    }

    @PostMapping
    public ResponseEntity<DetailCharge> create(@RequestBody DetailCharge detailCharge) {
        DetailCharge savedDetailCharge = detailChargeService.save(detailCharge);
        return ResponseEntity.ok(savedDetailCharge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        detailChargeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadDetails(@RequestBody List<List<Object>> detailCharges) {
        // Initialization of the data that will be used
        double sum_montant = 0;
        Rubrique idrubrique_used = new Rubrique();

        // Insertion of the detailscharge
        for (List<Object> detail : detailCharges) {
            int idRubrique = (int) detail.get(0);
            int idCentre = (int) detail.get(1);
            double montant = (double) detail.get(2);

            Rubrique rubrique = rubriqueService.getById(idRubrique)
                    .orElseThrow(() -> new RuntimeException("Rubrique not found"));
            Centre centre = centreService.getById(idCentre)
                    .orElseThrow(() -> new RuntimeException("Centre not found"));

            // Déclaration du détail de la charge qui sera inséré
            DetailCharge charge = new DetailCharge();
            charge.setRubrique(rubrique);
            charge.setCentre(centre);
            charge.setMontant(montant);

            // Insertion dans la table coutcentre
            Nature nature = natureService.getById(rubrique.getId_rubrique())
                    .orElseThrow(() -> new RuntimeException("Nature not found"));
            CoutCentre coutCentre = new CoutCentre(nature, montant);
            coutCentreService.save(coutCentre);

            // Insertion du détail de charge
            detailChargeService.save(charge);

            // Calcul de la somme totale des montants
            sum_montant = detailChargeService.sumMontantByRubriqueId(rubrique.getId_rubrique());
            idrubrique_used = rubrique;
        }

        // Insertion dans la table chargefinale
        Charge chargeFinale = new Charge(idrubrique_used, sum_montant);
        chargeFinaleService.save(chargeFinale);

        return ResponseEntity.ok().build();
    }

}
