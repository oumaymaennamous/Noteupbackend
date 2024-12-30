package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.Professeur;
import ensa.gestionnotes.projet_jee.Entity.User;
import ensa.gestionnotes.projet_jee.dto.UserDto;
import ensa.gestionnotes.projet_jee.repository.ProfesseurRepository;

import ensa.gestionnotes.projet_jee.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private ProfesseurRepository professueRepository;
    private UserRepository userRepository;
    private EmailService emailService;

    public UserServiceImpl(UserRepository userRepository, ProfesseurRepository professueRepository,EmailService emailService) {
        this.userRepository = userRepository;
        this.professueRepository = professueRepository;
        this.emailService=emailService;
    }

    @Override
    public boolean registerUser(String email, String password, String cin, String role) {
        Optional<Professeur> existingProfesseur =professueRepository.findByCIN(cin);
        if(existingProfesseur.isPresent()){
            Optional<User> existingUser = userRepository.findByEmail(email);
            if (existingUser.isPresent()) {
                return false; // Professeur déjà inscrit
            }

            // Créer un nouvel utilisateur
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setCin(cin);
            user.setRole(role);
            user.setActive(true);
            user.setValidated(false);
            String validationCode = emailService.generateValidationCode();
            user.setValidationCode(validationCode);


            userRepository.save(user);

            // Envoyer un email de validation
            emailService.sendValidationEmail(email, validationCode);

            return true;


        }
        return false;
    }

    @Override
    public boolean validateUser(String email, String validationCode) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getValidationCode().equals(validationCode)) {
            user.get().setValidated(true);
            userRepository.save(user.get());
            return true; // Validation réussie
        }
        return false; // Code de validation incorrect

    }

    @Override
    public boolean LoginUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent() && user.get().getPassword().equals(userDto.getPassword()) && user.get().isActive()){
            return true;
        }

        return false;
    }


    @Override
    public boolean LogoutUser() {
        return false;
    }

    @Override
    public boolean ChangePassword(String email, String password) {
        return false;
    }

    @Override
    public boolean ForgetPassword(String email) {
        return false;
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user=userRepository.findByEmail(email);
        return user.get() ;
    }
}
