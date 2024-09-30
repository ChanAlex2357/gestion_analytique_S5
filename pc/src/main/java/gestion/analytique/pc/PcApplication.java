package gestion.analytique.pc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Applique à toutes les requêtes
                        .allowedOrigins("http://localhost:5173","http://localhost:8080")  // Remplacez par l'origine de votre frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Méthodes autorisées
                        .allowedHeaders("*")  // Autorise tous les headers
                        .allowCredentials(true);  // Autorise les cookies et les informations d'identification
            }
        };
    }
}
