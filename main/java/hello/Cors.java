package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class Cors {

    private UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource;

    Cors (UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource){
        this.urlBasedCorsConfigurationSource = urlBasedCorsConfigurationSource;
    }

    @Bean
    public Cors corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("OPTIONS");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("PATCH");

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new Cors(urlBasedCorsConfigurationSource);
    }
}
