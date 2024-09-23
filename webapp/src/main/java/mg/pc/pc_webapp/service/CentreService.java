package mg.pc.pc_webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import mg.pc.pc_webapp.model.Centre;
import mg.pc.pc_webapp.repository.CentreProxy;

@Data
@Service
public class CentreService {
    @Autowired
    private CentreProxy centreProxy;
    
    public Iterable<Centre> getCentres(){
        return centreProxy.getCentres();
    }

    public void deleteCentre(){

        
    }
}
