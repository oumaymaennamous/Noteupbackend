package ensa.gestionnotes.projet_jee.config;

import ensa.gestionnotes.projet_jee.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Charger l'utilisateur par email
        ensa.gestionnotes.projet_jee.Entity.User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email));

        // Convertir le rôle en GrantedAuthority
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

        // Retourner un objet UserDetails
        return new User(
                user.getEmail(),
                user.getPassword(),
                user.isActive(), // enabled
                true,            // accountNonExpired
                true,            // credentialsNonExpired
                true,            // accountNonLocked
                List.of(authority)
        );
    }
}
