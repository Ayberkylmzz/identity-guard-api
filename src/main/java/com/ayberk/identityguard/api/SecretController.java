package com.ayberk.identityguard.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@EnableMethodSecurity
public class SecretController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Tebrikler! Güvenlik duvarını geçtin ve gizli veriye ulaştın.");
    }
}
