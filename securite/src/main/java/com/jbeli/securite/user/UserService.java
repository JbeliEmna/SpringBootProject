package com.jbeli.securite.user;

import com.jbeli.securite.token.ConfirmationToken;
import com.jbeli.securite.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

@NoArgsConstructor
public class UserService  implements UserDetailsService {
@Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private  ConfirmationTokenService confirmationTokenService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(User :: new)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email));
    }

    public String signUpUser(User user){
        boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExist){
            throw new IllegalStateException("email déja existe");
        }
        user.setMotDePasse(passwordEncoder.encode(user.getMotDePasse()));
        userRepository.save(user);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public User getOneUser(String name) {
        return userRepository.findByName(name).orElse(null);
    }


    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
}