package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.Nature;
import gestion.analytique.pc.service.NatureService;

import java.util.List;

@RestController
@RequestMapping("/nature")
public class NatureController {
    private final NatureService service;

    @Autowired
    public NatureController(NatureService service) {
        this.service = service;
    }

    @GetMapping
    public List<Nature> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Nature> create(@RequestBody Nature nature) {
        Nature savedNature = service.save(nature);
        return ResponseEntity.ok(savedNature);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Nature> update(@PathVariable int id, @RequestBody Nature nature) {
        Nature updatedNature = service.update(id, nature);
        if (updatedNature != null) {
            return ResponseEntity.ok(updatedNature);
        } else {
            return ResponseEntity.notFound().build(); // Cas où l'entité n'existe pas
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
