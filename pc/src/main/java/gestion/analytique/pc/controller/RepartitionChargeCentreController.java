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

    @GetMapping
    public List<RepartitionChargeCentre> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<RepartitionChargeCentre> create(@RequestBody RepartitionChargeCentre repartitionChargeCentre) {
        RepartitionChargeCentre savedRepartitionChargeCentre = service.save(repartitionChargeCentre);
        return ResponseEntity.ok(savedRepartitionChargeCentre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
