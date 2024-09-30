package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.ViewCoutCentre;
import gestion.analytique.pc.service.CoutCentreService;

import java.util.List;

@RestController
@RequestMapping("/coutcentre")
public class CoutCentreController {
    private final CoutCentreService service;

    @Autowired
    public CoutCentreController(CoutCentreService service) {
        this.service = service;
    }

    @GetMapping
    public List<ViewCoutCentre> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        // service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
