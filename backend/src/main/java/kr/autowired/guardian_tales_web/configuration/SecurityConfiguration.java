package kr.autowired.guardian_tales_web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain (final HttpSecurity httpSecurity, final CorsConfigurationSource corsConfigurationSource) throws Exception {
        return httpSecurity.
                cors((httpSecurityCorsConfigurer) -> {
                    httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource);
                }).
                csrf(AbstractHttpConfigurer::disable).
                authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) -> {
                    authorizationManagerRequestMatcherRegistry.requestMatchers("/test/**").permitAll();
                }).
                build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource () {
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return urlBasedCorsConfigurationSource;
    }

}
