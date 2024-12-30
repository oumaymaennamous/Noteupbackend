package ensa.gestionnotes.projet_jee.contoller;

import ensa.gestionnotes.projet_jee.Entity.User;
import ensa.gestionnotes.projet_jee.config.JwtUtil;
import ensa.gestionnotes.projet_jee.dto.UserDto;
import ensa.gestionnotes.projet_jee.repository.UserRepository;
import ensa.gestionnotes.projet_jee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
/*
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password,
                           @RequestParam String cin, @RequestParam String role) {
        if (userService.registerUser(email, password, cin, role)) {
            return "Inscription réussie. Un email de validation a été envoyé.";
        } else {
            return "Professeur déjà inscrit.";
        }
    }

    @PostMapping("/validate")
    public String validate(@RequestParam String email, @RequestParam String validationCode) {
        if (userService.validateUser(email, validationCode)) {
            return "Votre inscription a été validée.";
        } else {
            return "Code de validation incorrect.";
        }
    }
    @PostMapping("/login")
    public String Login(@RequestBody UserDto userDto){
        if(userService.LoginUser(userDto)){
            return "Hello "+userDto.getEmail();
        }
        return "connexion invalide";
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login2")
    public ResponseEntity<?> login(@RequestBody UserDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");
        }

        // Retourne les informations utilisateur (rôle inclus)
        Map<String, String> response = new HashMap<>();
        response.put("role", user.getRole());
        response.put("email", loginRequest.getEmail());
        return ResponseEntity.ok(response);
    }
*/
private final AuthenticationManager authenticationManager;
private final JwtUtil jwtUtil;
private final UserRepository userRepository;

private final PasswordEncoder passwordEncoder;
private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        String role= userService.findUserByEmail(authRequest.getEmail()).getRole();
        String token = jwtUtil.generateToken(authRequest.getEmail(),role);
        return ResponseEntity.ok(token);
    }
    @GetMapping("/login1")
    public String adminDashboard() {
        return "Bienvenue dans le tableau de bord admin";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto registerRequest) {
        // Vérifier si l'utilisateur existe déjà
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email déjà utilisé.");
        }

        // Créer et enregistrer un nouvel utilisateur
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setRole("ROLE_Professeur"); // Définir un rôle par défaut

        userRepository.save(newUser);

        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }
}