package pe.demo.reto.utils;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	@Value("${security.jwt.secret}")
	private String secret;

	@Value("${security.jwt.expiration}")
	private String expirationTime;

	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey(secret)).build().parseClaimsJws(token).getBody();
	}
	
	public String getUsernameFromToken(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
//	public String generateToken(Userdata user) {
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("role", user.getRoles());
//		return doGenerateToken(claims, user.getEmail());
//	}

	public String generateToken(String username) {
		Long expirationTimeLong = Long.parseLong(expirationTime); //in second
		
		final Date createdDate = new Date();
		final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);
		return Jwts.builder()
//				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(createdDate)
				.setExpiration(expirationDate)
				.signWith(getKey(secret))
				.compact();
	}
	
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
	
    private Key getKey(String secret) {
        byte[] secretBytes = Decoders.BASE64URL.decode(secret);
        return Keys.hmacShaKeyFor(secretBytes);
    }
}
