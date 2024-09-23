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
import mg.pc.pc_webapp.model.UnitOeuvre;

@Slf4j
@Component
public class UnitOeuvreProxy {
    @Autowired
    private ProxyProperties proxyProperties;

    public Iterable<UnitOeuvre> getUnitOeuvres() {
        String apiUrl = proxyProperties.getApiUrl();
        String getUnitOeuvresUrl = apiUrl + "/unite-oeuvre";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<UnitOeuvre>> response = restTemplate.exchange(
            getUnitOeuvresUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<UnitOeuvre>>() {}
        );
        log.debug("Get UnitOeuvre call: " + response.getStatusCode().toString());
        return response.getBody();
    }

    public UnitOeuvre createUnitOeuvre(UnitOeuvre unitOeuvre) {
        String apiUrl = proxyProperties.getApiUrl();
        String createUnitOeuvreUrl = apiUrl + "/unite-oeuvre";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UnitOeuvre> request = new HttpEntity<>(unitOeuvre);
        ResponseEntity<UnitOeuvre> response = restTemplate.exchange(
            createUnitOeuvreUrl,
            HttpMethod.POST,
            request,
            UnitOeuvre.class
        );
        log.debug("Create UnitOeuvre call: " + response.getStatusCode().toString());
        return response.getBody();
    }
}
