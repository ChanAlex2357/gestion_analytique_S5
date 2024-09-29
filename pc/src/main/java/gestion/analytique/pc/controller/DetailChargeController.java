package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.DetailCharge;
import gestion.analytique.pc.service.DetailChargeService;

import java.util.List;

@RestController
@RequestMapping("/detail-charge")
public class DetailChargeController {

    private final DetailChargeService service;

    @Autowired
    public DetailChargeController(DetailChargeService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetailCharge> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<DetailCharge> create(@RequestBody DetailCharge detailCharge) {
        DetailCharge savedDetailCharge = service.save(detailCharge);
        return ResponseEntity.ok(savedDetailCharge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
