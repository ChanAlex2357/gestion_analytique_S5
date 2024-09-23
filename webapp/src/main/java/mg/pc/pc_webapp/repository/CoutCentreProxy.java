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
import mg.pc.pc_webapp.model.CoutCentre;

@Slf4j
@Component
public class CoutCentreProxy {
    @Autowired
    private ProxyProperties proxyProperties;
    
    public Iterable<CoutCentre> getCoutCentres(){
        String apiUrl = proxyProperties.getApiUrl();
        String getCoutCentresUrl = apiUrl + "/coutCentre";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<CoutCentre>> response = restTemplate.exchange(
            getCoutCentresUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<CoutCentre>>(){}
        );
        log.debug(("Get Center call" + response.getStatusCode().toString()));
        return response.getBody();
    }

    public CoutCentre createCoutCentre(CoutCentre coutCentre){
        String apiUrl = proxyProperties.getApiUrl();
        String createCeterUrl = apiUrl  + "/coutCentre";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CoutCentre> request = new HttpEntity<CoutCentre>(coutCentre);
        ResponseEntity<CoutCentre> response = restTemplate.exchange(
            createCeterUrl,
            HttpMethod.POST,
            request,
            CoutCentre.class
        );
        log.debug("Create CoutCentre call "+ response.getStatusCode().toString());
        return response.getBody();
    }
}
