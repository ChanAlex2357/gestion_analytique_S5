package mg.pc.pc_webapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import mg.pc.pc_webapp.ProxyProperties;
import mg.pc.pc_webapp.model.ChargeFinale;

@Slf4j
@Component
public class ChargeFinaleProxy {
    @Autowired
    private ProxyProperties proxyProperties;
    
    public Iterable<ChargeFinale> getChargeFinales(){
        String apiUrl = proxyProperties.getApiUrl();
        String getChargeFinalesUrl = apiUrl + "/chargeFinale";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<ChargeFinale>> response = restTemplate.exchange(
            getChargeFinalesUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<ChargeFinale>>(){}
        );
        log.debug(("Get Center call" + response.getStatusCode().toString()));
        return response.getBody();
    }

    public ChargeFinale createChargeFinale(ChargeFinale chargeFinale){
        String apiUrl = proxyProperties.getApiUrl();
        String createCeterUrl = apiUrl  + "/chargeFinale";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ChargeFinale> request = new HttpEntity<ChargeFinale>(chargeFinale);
        ResponseEntity<ChargeFinale> response = restTemplate.exchange(
            createCeterUrl,
            HttpMethod.POST,
            request,
            ChargeFinale.class
        );
        log.debug("Create ChargeFinale call "+ response.getStatusCode().toString());
        return response.getBody();
    }
}
