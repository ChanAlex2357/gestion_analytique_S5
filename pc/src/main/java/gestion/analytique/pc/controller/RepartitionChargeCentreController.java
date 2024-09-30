package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.RepartitionChargeCentre;
import gestion.analytique.pc.service.RepartitionChargeCentreService;

import java.util.List;

@RestController
@RequestMapping("/repartition-charge-centre")
public class RepartitionChargeCentreController {

    private final RepartitionChargeCentreService service;

    @Autowired
    public RepartitionChargeCentreController(RepartitionChargeCentreService service) {
        this.service = service;
    }

    // Retrieve all repartition charge centres
    @GetMapping
    public List<RepartitionChargeCentre> getAll() {
        return service.getAll();
    }

    // Create a new repartition charge centre
    @PostMapping
    public ResponseEntity<RepartitionChargeCentre> create(@RequestBody RepartitionChargeCentre repartitionChargeCentre) {
        RepartitionChargeCentre savedRepartitionChargeCentre = service.save(repartitionChargeCentre);
        return ResponseEntity.ok(savedRepartitionChargeCentre);
    }

    // Update an existing repartition charge centre
    @PutMapping("/{id}")
    public ResponseEntity<RepartitionChargeCentre> update(@PathVariable int id, @RequestBody RepartitionChargeCentre repartitionChargeCentre) {
        repartitionChargeCentre.setId_repartition_charge_centre(id); // Assuming there's a setId method to set the ID
        RepartitionChargeCentre updatedRepartitionChargeCentre = service.save(repartitionChargeCentre);
        return ResponseEntity.ok(updatedRepartitionChargeCentre);
    }

    // Delete a repartition charge centre by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
