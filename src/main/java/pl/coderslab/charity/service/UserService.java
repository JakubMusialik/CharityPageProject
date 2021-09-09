package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.ConfirmationToken;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepo;
import pl.coderslab.charity.repository.UserRepo;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND_MESSAGE = "Nie znaleziono użytkownika o podanym adresie email : %s";
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MESSAGE, email)));
    }

    public String signUpUser(User user){
        boolean checkIfUserExists = userRepo.findByEmail(
                user.getEmail())
                .isPresent();

        if(checkIfUserExists && user.isEnabled()){
            throw new IllegalStateException("Użytkownik o takim adresie email już istnieje");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        Role userRole = roleRepo.findByName("USER");
        user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));

        userRepo.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(60),
                user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableUser(String email) {
        return userRepo.enableUser(email);
    }

    public int blockUser(String email){
        return userRepo.blockUser(email);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
