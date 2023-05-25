package com.java.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.java.entity.User;

import com.java.repository.UserRepository;

@Component
public class AdminInitializer {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

    @PostConstruct
    public void init() {
        if (!isAdminEntryExists()) {
            createAdminEntry();
        }
    }

    private boolean isAdminEntryExists() {
        return !userRepository.findAllByRole("ROLE_ADMIN").isEmpty();
    }

    private void createAdminEntry() {
        User admin = new User();
        admin.setLoginId("admin");
        admin.setPassword(encoder.encode("admin"));
        admin.setRole("ROLE_ADMIN");
        userRepository.save(admin);
    }
}

