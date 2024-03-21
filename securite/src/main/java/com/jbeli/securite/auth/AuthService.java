package com.jbeli.securite.auth;

import com.jbeli.gestion.utilisateurs.utilisateur.UtilisateurRepository;
import com.jbeli.securite.config.JwtService;
import com.jbeli.securite.user.RoleRepository;
import com.jbeli.securite.user.Role;
import com.jbeli.securite.user.RoleEnum;
import com.jbeli.securite.user.User;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void register(RegisterRequest request) {
        var utilisateur = mapper.toUtilisateur(request);
        var encryptedPassword = passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(encryptedPassword);
        Role utilisateurRole = roleRepository.findByName(RoleEnum.ROLE_ADMININSTRATEUR)
                .orElseGet(() -> {
                    var newUtilisateurRole = Role.builder()
                            .name(RoleEnum.ROLE_ADMININSTRATEUR)
                            .build();
                    return roleRepository.save(newUtilisateurRole);
                }
                );

        utilisateur.setRoles(List.of(utilisateurRole));

        utilisateurRepository.save(utilisateur);
    }

    public AuthResponse authenticate(AuthRequest request) {
        Authentication authenticatedUser = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getMotDePasse()
                )
        );
        var userDetails = (User) authenticatedUser.getPrincipal();
        HashMap<String, Object> claims = new HashMap<>();
        var authorities = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        claims.put("firstname", userDetails.getNom());
        claims.put("authorities", authorities);
        var jwtToken = jwtService.generateToken(claims, userDetails);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
