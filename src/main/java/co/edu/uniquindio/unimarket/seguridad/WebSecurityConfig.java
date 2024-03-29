package co.edu.uniquindio.unimarket.seguridad;

import co.edu.uniquindio.unimarket.seguridad.config.JwtAuthenticationEntryPoint;
import co.edu.uniquindio.unimarket.seguridad.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jaf;
    private final JwtAuthenticationEntryPoint jaep;
    private final AuthenticationProvider ap;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.cors();
        http.authorizeHttpRequests()
                .requestMatchers("/api/auth/**", "/api/producto/obtener/**", "/api/producto/productos/**", "/api/subasta/subastas/**")
                .permitAll()
                .requestMatchers("/api/moderador/**", "/api/producto/moderador/**")
                .hasAuthority("MODERADOR")
                .anyRequest()
                .authenticated();
        http.exceptionHandling().authenticationEntryPoint(jaep);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authenticationProvider(ap);
        http.addFilterBefore(jaf, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}