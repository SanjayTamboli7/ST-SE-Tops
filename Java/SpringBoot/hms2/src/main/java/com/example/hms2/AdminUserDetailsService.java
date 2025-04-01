package com.example.hms2;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailsService {

    @Autowired
    private AdminUserDetailsRepository repository;

    public Optional<AdminUserDetails> getUserDetailsByEmail(String email) {
        return repository.findUserDetailsByEmail(email);
    }
}
