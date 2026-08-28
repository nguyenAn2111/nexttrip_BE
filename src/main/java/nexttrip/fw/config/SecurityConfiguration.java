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

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@CrossOrigin
@RequiredArgsConstructor
public class SecurityConfiguration {


    private final TokenProvider tokenProvider;
    private final SecurityProblemSupport securityProblemSupport;


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http
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
                .antMatchers(HttpMethod.POST, "/api/v1.0/auth/forgot-password").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1.0/auth/refresh-token").permitAll()
//                .antMatchers("/api/v1.0/cms/config/**").permitAll()
                .antMatchers("/v3/api-docs/**", "/v3/api-docs", "/swagger-ui/**").permitAll()
                .antMatchers("/private/api/v1.0/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(new JwtOncePerRequestFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}

