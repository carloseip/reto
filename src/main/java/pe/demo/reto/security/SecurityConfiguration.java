package pe.demo.reto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;

    @Bean
    SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
		return http
                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint((swe, e) -> {
                            return Mono.fromRunnable(() -> {
                                swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            });
                        }).accessDeniedHandler((swe, e) -> {
                    return Mono.fromRunnable(() -> {
                        swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                    });
                }))
                .csrf(csrf -> csrf.disable()
                .formLogin(login -> login.disable()
                .httpBasic(basic -> basic.disable()
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(HttpMethod.OPTIONS).permitAll()
                        .pathMatchers("/api/usuario/login").permitAll()
                        .anyExchange().authenticated())))).build();
	}
}
