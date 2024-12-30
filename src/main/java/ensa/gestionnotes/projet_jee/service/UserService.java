package ensa.gestionnotes.projet_jee.service;

import ensa.gestionnotes.projet_jee.Entity.User;
import ensa.gestionnotes.projet_jee.dto.UserDto;

public interface UserService {
    public boolean registerUser(String email, String password, String cin, String role);
    public boolean validateUser(String email, String validationCode);
    public boolean LoginUser(UserDto userDto);
    public boolean LogoutUser();
    public boolean ChangePassword(String email,String password);
    public boolean ForgetPassword(String email);
    public User findUserByEmail(String email);
}
