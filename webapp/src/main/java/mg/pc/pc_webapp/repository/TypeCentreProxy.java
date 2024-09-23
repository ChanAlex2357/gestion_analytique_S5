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
import mg.pc.pc_webapp.model.TypeCentre;

@Slf4j
@Component
public class TypeCentreProxy {
    @Autowired
    private ProxyProperties proxyProperties;

    public Iterable<TypeCentre> getTypeCentres() {
        String apiUrl = proxyProperties.getApiUrl();
        String getTypeCentresUrl = apiUrl + "/type-centre";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<TypeCentre>> response = restTemplate.exchange(
            getTypeCentresUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<TypeCentre>>() {}
        );
        log.debug("Get TypeCentre call: " + response.getStatusCode().toString());
        return response.getBody();
    }

    public TypeCentre createTypeCentre(TypeCentre typeCentre) {
        String apiUrl = proxyProperties.getApiUrl();
        String createTypeCentreUrl = apiUrl + "/type-centre";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<TypeCentre> request = new HttpEntity<>(typeCentre);
        ResponseEntity<TypeCentre> response = restTemplate.exchange(
            createTypeCentreUrl,
            HttpMethod.POST,
            request,
            TypeCentre.class
        );
        log.debug("Create TypeCentre call: " + response.getStatusCode().toString());
        return response.getBody();
    }
}
