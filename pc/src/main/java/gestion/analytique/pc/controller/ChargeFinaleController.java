package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.Charge;
import gestion.analytique.pc.service.ChargeFinaleService;

import java.util.List;

@RestController
@RequestMapping("/chargefinale")
public class ChargeFinaleController {
    private final ChargeFinaleService service;

    @Autowired
    public ChargeFinaleController(ChargeFinaleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Charge> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Charge> create(@RequestBody Charge chargeFinale) {
        Charge savedChargeFinale = service.save(chargeFinale);
        return ResponseEntity.ok(savedChargeFinale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
