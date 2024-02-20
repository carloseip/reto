package pe.demo.reto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import pe.demo.reto.utils.JWTUtil;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {
	
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.just(authentication)
                .map(auth -> jwtUtil.getAllClaimsFromToken(auth.getCredentials().toString()))
                .log()
                .onErrorResume(e -> Mono.empty())
                .map(claims -> new UsernamePasswordAuthenticationToken(
                        claims.getSubject(),
                        null,
                        null
                ));
	}

}
