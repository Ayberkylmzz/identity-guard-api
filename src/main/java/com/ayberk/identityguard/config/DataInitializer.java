package com.ayberk.identityguard.config;

import com.ayberk.identityguard.model.Role;
import com.ayberk.identityguard.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        saveRoleIfNotFound("ROLE_USER");
        saveRoleIfNotFound("ROLE_ADMIN");
    }

    private void saveRoleIfNotFound(String roleName) {
        if (roleRepository.findByName(roleName).isEmpty()) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
        }
    }
}