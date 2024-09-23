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
import mg.pc.pc_webapp.model.Centre;

@Slf4j
@Component
public class CentreProxy {
    @Autowired
    private ProxyProperties proxyProperties;

    public Iterable<Centre> getCentres(){
        String apiUrl = proxyProperties.getApiUrl();
        String getCentresUrl = apiUrl + "/centre";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Centre>> response = restTemplate.exchange(
            getCentresUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<Centre>>(){}
        );
        log.debug(("Get Center call" + response.getStatusCode().toString()));
        return response.getBody();
    }

    public Centre createCentre(Centre centre){
        String apiUrl = proxyProperties.getApiUrl();
        String createCeterUrl = apiUrl  + "/centre";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Centre> request = new HttpEntity<Centre>(centre);
        ResponseEntity<Centre> response = restTemplate.exchange(
            createCeterUrl,
            HttpMethod.POST,
            request,
            Centre.class
        );
        log.debug("Create Centre call "+ response.getStatusCode().toString());
        return response.getBody();
    }
}
