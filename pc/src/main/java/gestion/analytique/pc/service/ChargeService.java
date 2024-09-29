package gestion.analytique.pc.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import gestion.analytique.pc.model.Charge;
import gestion.analytique.pc.model.RepartitionChargeCentre;
import gestion.analytique.pc.repository.ChargeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChargeService {

    private final ChargeRepository repository;
    private final RepartitionChargeCentreService chargeCentreService;

    @Autowired
    public ChargeService(ChargeRepository repository,RepartitionChargeCentreService chargeCentreService) {
        this.repository = repository;
        this.chargeCentreService = chargeCentreService;
    }

    public List<Charge> getAll() {
        return (List<Charge>) repository.findAll();
    }

    public Optional<Charge> getById(int id) {
        return repository.findById(id);
    }

    public Charge save(Charge charge) {
        return repository.save(charge);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<RepartitionChargeCentre> get_repartition_charge_par_centre(Charge charge){
        List<RepartitionChargeCentre> list = new ArrayList<RepartitionChargeCentre>();
        for (RepartitionChargeCentre repartitionChargeCentre : chargeCentreService.getAll()) {
            if(charge.getRubrique().getId_rubrique() ==  repartitionChargeCentre.getRubrique().getId_rubrique()){
                list.add(repartitionChargeCentre);
            }
        }
        return list;
    }
}
