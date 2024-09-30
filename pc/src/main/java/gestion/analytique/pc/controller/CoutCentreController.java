package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gestion.analytique.pc.model.AdminCoutCentre;
import gestion.analytique.pc.model.ViewCoutCentre;
import gestion.analytique.pc.service.AdminCoutCentreService;
import gestion.analytique.pc.service.CoutCentreService;

import java.util.List;

@RestController
@RequestMapping("/coutcentre")
public class CoutCentreController {
    private final CoutCentreService service;
    private final AdminCoutCentreService coutCentreService;

    @Autowired
    public CoutCentreController(CoutCentreService service) {
        this.service = service;
        coutCentreService = new AdminCoutCentreService(service);
    }

    // @GetMapping
    public List<ViewCoutCentre> getAll() {
        return service.getAll();
    }
    @GetMapping
    public AdminCoutCentre gCoutCentres(){
        return coutCentreService.getAdminCoutCentre();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        // service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
