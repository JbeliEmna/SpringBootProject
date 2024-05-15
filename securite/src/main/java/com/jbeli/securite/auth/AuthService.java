package com.jbeli.securite.auth;

import com.jbeli.securite.config.JwtService;
import com.jbeli.securite.email.EmailService;
import com.jbeli.securite.email.EmailTemplateName;
import com.jbeli.securite.role.RoleRepository;
import com.jbeli.securite.token.ConfirmationToken;
import com.jbeli.securite.token.ConfirmationTokenRepository;
import com.jbeli.securite.user.User;
import com.jbeli.securite.user.UserRepository;
import com.jbeli.securite.user.UserService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthService {

    private AuthMapper mapper;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authManager;
    private JwtService jwtService;
    private  UserService userService;
    private EmailService emailService;
    private  RoleRepository roleRepository;
    private UserRepository userRepository;
    private  ConfirmationTokenRepository tokenRepository;
    public String activationUrl;
    //@Value("${application.mailing.frontend.activation-url}")


    public void register(RegisterRequest request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("ROLE USER was not initialized"));
        var user = User.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .email(request.getEmail())
                .DateNaissance(request.getDateNaissance())
                .motDePasse(passwordEncoder.encode(request.getMotDePasse()))
                .enabled(false)
                .locked(false)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);
        sendValidationEmail(user);
    }
    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        emailService.sendEmail(user.getEmail(),user.FullName(), EmailTemplateName.ACTIVATE_ACCOUNT , activationUrl , "Account Activation", newToken );
    }
    private String generateAndSaveActivationToken(User user){
        String generateToken = generateActivationCode(6);
        var token = ConfirmationToken.builder()
                .token(generateToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generateToken;
    }
    private String generateActivationCode(int length){
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for(int i=0; i< length; i++){
            int randomIndex =secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();

    }

    public AuthResponse authenticate(AuthRequest request) {
        var auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMotDePasse()
                )
        );
        var claims = new HashMap<String, Object>();
        var user = ((User) auth.getPrincipal());
        claims.put("fullName", user.FullName());
        var jwtToken = jwtService.generateToken(claims, user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Transactional
    public void activateAccount(String token) throws MessagingException{
        ConfirmationToken savedToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())){
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired . A new token has been sent to the same email address");
        }
        var user = userRepository.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setEnabled(true);
        userRepository.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }

}
