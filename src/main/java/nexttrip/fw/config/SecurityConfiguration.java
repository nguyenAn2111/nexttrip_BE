package nexttrip.fw.config;

import lombok.RequiredArgsConstructor;
import nexttrip.fw.security.JwtOncePerRequestFilter;
import nexttrip.fw.security.SecurityProblemSupport;
import nexttrip.fw.security.jwt.TokenProvider;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@CrossOrigin
@RequiredArgsConstructor
public class SecurityConfiguration {


    private final TokenProvider tokenProvider;
    private final SecurityProblemSupport securityProblemSupport;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(
                List.of("http://localhost:5173")
        );

        configuration.setAllowedMethods(
                List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
        );

        configuration.setAllowedHeaders(
                List.of("Authorization", "Content-Type", "Accept")
        );

        configuration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http

                .cors().configurationSource(corsConfigurationSource())
                .and()

                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(securityProblemSupport)
                .accessDeniedHandler(securityProblemSupport)
                .and()
//                .cors().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/health/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/user").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/auth/login").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/v1.0/auth/forgot-password").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/auth/refresh-token").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1.0/user/list_all").permitAll()
//                .antMatchers("/api/v1.0/cms/config/**").permitAll()
                .antMatchers("/v3/api-docs/**", "/v3/api-docs", "/swagger-ui/**").permitAll()
                .antMatchers("/private/api/v1.0/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(new JwtOncePerRequestFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}

