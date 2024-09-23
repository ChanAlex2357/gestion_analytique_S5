package mg.pc.pc_webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gestion.analytique.pc.model.Centre;
import gestion.analytique.pc.service.CentreService;

import java.util.List;

@RestController
@RequestMapping("/centre")
public class CentreController {
    private final CentreService centreService;

    @Autowired
    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    @GetMapping
    public List<Centre> getAll() {
        return centreService.getAll();
    }

    @PostMapping
    public ResponseEntity<Centre> create(@RequestBody Centre centre) {
        Centre savedCentre = centreService.save(centre);
        return ResponseEntity.ok(savedCentre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        centreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
