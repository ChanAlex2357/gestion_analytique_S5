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
import mg.pc.pc_webapp.model.DetailCharge;

@Slf4j
@Component
public class DetailChargeProxy {
    @Autowired
    private ProxyProperties proxyProperties;

    public Iterable<DetailCharge> getDetailCharges() {
        String apiUrl = proxyProperties.getApiUrl();
        String getDetailChargesUrl = apiUrl + "/detail-charge";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<DetailCharge>> response = restTemplate.exchange(
            getDetailChargesUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Iterable<DetailCharge>>() {}
        );
        log.debug("Get DetailCharge call: " + response.getStatusCode().toString());
        return response.getBody();
    }

    public DetailCharge createDetailCharge(DetailCharge detailCharge) {
        String apiUrl = proxyProperties.getApiUrl();
        String createDetailChargeUrl = apiUrl + "/detail-charge";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<DetailCharge> request = new HttpEntity<>(detailCharge);
        ResponseEntity<DetailCharge> response = restTemplate.exchange(
            createDetailChargeUrl,
            HttpMethod.POST,
            request,
            DetailCharge.class
        );
        log.debug("Create DetailCharge call: " + response.getStatusCode().toString());
        return response.getBody();
    }
}
