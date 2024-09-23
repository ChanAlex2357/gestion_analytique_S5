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
import mg.pc.pc_webapp.model.Rubrique;

@Slf4j
@Component
public class RubriqueProxy {
    @Autowired
    private ProxyProperties proxyProperties;

    public Iterable<Rubrique> getRubriques() {
        String apiUrl = proxyProperties.getApiUrl();
        String getRubriquesUrl = apiUrl + "/rubrique";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Rubrique>> response = restTemplate.exchange(
            getRubriquesUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<Rubrique>>() {}
        );
        log.debug("Get Rubrique call: " + response.getStatusCode().toString());
        return response.getBody();
    }

    public Rubrique createRubrique(Rubrique rubrique) {
        String apiUrl = proxyProperties.getApiUrl();
        String createRubriqueUrl = apiUrl + "/rubrique";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Rubrique> request = new HttpEntity<>(rubrique);
        ResponseEntity<Rubrique> response = restTemplate.exchange(
            createRubriqueUrl,
            HttpMethod.POST,
            request,
            Rubrique.class
        );
        log.debug("Create Rubrique call: " + response.getStatusCode().toString());
        return response.getBody();
    }
}
