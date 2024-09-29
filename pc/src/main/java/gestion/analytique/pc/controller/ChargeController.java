package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.Charge;
import gestion.analytique.pc.model.DetailCharge;
import gestion.analytique.pc.model.RepartitionChargeCentre;
import gestion.analytique.pc.service.ChargeService;
import gestion.analytique.pc.service.DetailChargeService;

import java.util.List;

@RestController
@RequestMapping("/charge")
public class ChargeController {

    private final ChargeService service;
    private DetailChargeService dc_service;

    @Autowired
    public ChargeController(ChargeService service) {
        this.service = service;
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
            details.setCles_repartition(repartitionChargeCentre.getPourcentage()+"");
            details.setDate_charge(charge.getDate_charge());
            details.setMontant(charge.getTotal_montant() * repartitionChargeCentre.getPourcentage() /100 + ""); 
            details.setNature(charge.getRubrique().getNature());
            dc_service.save(details);
        }

        return false;
    }
}
