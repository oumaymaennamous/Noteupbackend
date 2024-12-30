package ensa.gestionnotes.projet_jee.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // Générer une clé secrète sécurisée de 256 bits pour HS256
    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Générer un token JWT en ajoutant le rôle
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role) // Ajouter le rôle comme claim
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expire dans 10 heures
                .signWith(SECRET_KEY)
                .compact();
    }

    // Extraire le nom d'utilisateur du token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Extraire le rôle du token
    public String extractRole(String token) {
        return (String) extractAllClaims(token).get("role"); // Extraire le rôle du token
    }

    // Vérifier si le token est valide
    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
