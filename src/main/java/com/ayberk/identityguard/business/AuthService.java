package com.ayberk.identityguard.business;

import com.ayberk.identityguard.dataAccess.RoleRepository;
import com.ayberk.identityguard.dataAccess.UserRepository;
import com.ayberk.identityguard.dto.LoginRequest;
import com.ayberk.identityguard.dto.RegisterRequest;
import com.ayberk.identityguard.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ayberk.identityguard.entities.Role;
import java.util.Set;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest registerRequest) {

        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            return "Hata: Bu kullanıcı adı zaten alınmış";
        }
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return "Hata: Bu email adresi zaten kullanımda!";
        }

        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());

        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Hata: Veritabanında ROLE_USER bulunumadı!"));

        user.setRoles(new HashSet<>());
        user.getRoles().add(userRole);

        userRepository.save(user);

        return "Kullanıcı başarıyla kaydedildi!";
    }

    public String login(LoginRequest loginRequest) {

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunumadı!"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Şifre Hatalı!");
        }
        return jwtService.generateToken(user);
    }
}