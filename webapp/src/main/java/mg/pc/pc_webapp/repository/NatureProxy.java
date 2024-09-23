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
import mg.pc.pc_webapp.model.Nature;

@Slf4j
@Component
public class NatureProxy {
    @Autowired
    private ProxyProperties proxyProperties;

    public Iterable<Nature> getNatures() {
        String apiUrl = proxyProperties.getApiUrl();
        String getNaturesUrl = apiUrl + "/nature";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Nature>> response = restTemplate.exchange(
            getNaturesUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<Nature>>() {}
        );
        log.debug("Get Nature call: " + response.getStatusCode().toString());
        return response.getBody();
    }

    public Nature createNature(Nature nature) {
        String apiUrl = proxyProperties.getApiUrl();
        String createNatureUrl = apiUrl + "/nature";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Nature> request = new HttpEntity<>(nature);
        ResponseEntity<Nature> response = restTemplate.exchange(
            createNatureUrl,
            HttpMethod.POST,
            request,
            Nature.class
        );
        log.debug("Create Nature call: " + response.getStatusCode().toString());
        return response.getBody();
    }
}
