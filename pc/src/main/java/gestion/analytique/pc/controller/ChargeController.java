package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.Charge;
import gestion.analytique.pc.model.DetailCharge;
import gestion.analytique.pc.model.RepartitionChargeCentre;
import gestion.analytique.pc.service.ChargeService;
import gestion.analytique.pc.service.DetailChargeService;
import gestion.analytique.pc.service.RubriqueService;

import java.util.List;

@RestController
@RequestMapping("/charge")
public class ChargeController {

    private final ChargeService service;
    private final DetailChargeService dc_service; // Change this to final
    private final RubriqueService n_service; // Change this to final

    // Use constructor injection for both services
    @Autowired
    public ChargeController(ChargeService service, DetailChargeService dc_service, RubriqueService n_service) {
        this.service = service;
        this.dc_service = dc_service; // Initialize here
        this.n_service = n_service;
    }

    @GetMapping
    public List<Charge> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Charge> create(@RequestBody Charge charge) {
        Charge savedCharge = service.save(charge);
        return ResponseEntity.ok(savedCharge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add")
    public boolean insertCharge(@RequestBody Charge charge) {
        // Insertion of the charge
        service.save(charge);

        // Get all the ChargeCentre
        List<RepartitionChargeCentre> chargeCentres = service.get_repartition_charge_par_centre(charge);

        // Loop to insert the DetailsCharge
        for (RepartitionChargeCentre repartitionChargeCentre : chargeCentres) {
            DetailCharge details = new DetailCharge();
            details.setCentre(repartitionChargeCentre.getCentre());
            details.setCharge(charge);
            details.setCles_repartition(String.valueOf(repartitionChargeCentre.getPourcentage()));
            double montant = charge.getTotal_montant() * repartitionChargeCentre.getPourcentage() / 100;
            details.setMontant(String.valueOf(montant));
            details.setDate_charge(charge.getDate_charge());
            details.setNature((this.n_service.getById(charge.getRubrique().getId_rubrique())).get().getNature());
            dc_service.save(details); 
        }

        return true;
    }
}
