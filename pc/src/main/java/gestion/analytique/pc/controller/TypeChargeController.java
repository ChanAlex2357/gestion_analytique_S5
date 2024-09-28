package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.TypeCharge;
import gestion.analytique.pc.service.TypeChargeService;

import java.util.List;

@RestController
@RequestMapping("/type_charge")
public class TypeChargeController {

    private final TypeChargeService service;

    @Autowired
    public TypeChargeController(TypeChargeService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeCharge> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<TypeCharge> create(@RequestBody TypeCharge typeCharge) {
        TypeCharge savedTypeCharge = service.save(typeCharge);
        return ResponseEntity.ok(savedTypeCharge);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
