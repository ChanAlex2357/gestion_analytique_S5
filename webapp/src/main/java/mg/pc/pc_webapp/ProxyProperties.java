package mg.pc.pc_webapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "mg.gestion.webapp")
@Data
public class ProxyProperties {
    private String apiUrl;
}
