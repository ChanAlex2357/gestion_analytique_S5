package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.TypeCharge;
import gestion.analytique.pc.service.TypeChargeService;

import java.util.List;

@RestController
@RequestMapping("/api/typecharge")
@CrossOrigin(origins = "http://localhost:5173")
public class TypeChargeController {

    private final TypeChargeService service;

    @Autowired
    public TypeChargeController(TypeChargeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<TypeCharge> getAll() {
        return service.getAll();
    }

    @PostMapping("/insert")
    public ResponseEntity<TypeCharge> create(@RequestBody TypeCharge typeCharge) {
        TypeCharge savedTypeCharge = service.save(typeCharge);
        return ResponseEntity.ok(savedTypeCharge);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCharge> update(@PathVariable int id, @RequestBody TypeCharge typeCharge) {
        TypeCharge updatedTypeCharge = service.update(id, typeCharge);
        if (updatedTypeCharge != null) {
            return ResponseEntity.ok(updatedTypeCharge);
        } else {
            return ResponseEntity.notFound().build(); // Retourne 404 si l'élément n'existe pas
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
