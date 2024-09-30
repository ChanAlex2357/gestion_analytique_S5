package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.TypeCentre;
import gestion.analytique.pc.service.TypeCentreService;

import java.util.List;

@RestController
@RequestMapping("/typecentre")
public class TypeCentreController {
    private final TypeCentreService service;

    @Autowired
    public TypeCentreController(TypeCentreService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeCentre> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<TypeCentre> create(@RequestBody TypeCentre typeCentre) {
        TypeCentre savedTypeCentre = service.save(typeCentre);
        return ResponseEntity.ok(savedTypeCentre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCentre> update(@PathVariable int id, @RequestBody TypeCentre typeCentre) {
        TypeCentre updatedTypeCentre = service.update(id, typeCentre);
        if (updatedTypeCentre != null) {
            return ResponseEntity.ok(updatedTypeCentre);
        } else {
            return ResponseEntity.notFound().build(); // Retourne un 404 si l'entité n'existe pas
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
