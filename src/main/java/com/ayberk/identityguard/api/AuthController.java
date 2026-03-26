package com.ayberk.identityguard.api;

import com.ayberk.identityguard.business.AuthService;
import com.ayberk.identityguard.dto.AuthResponse;
import com.ayberk.identityguard.dto.LoginRequest;
import com.ayberk.identityguard.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
        String result = authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(result));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}