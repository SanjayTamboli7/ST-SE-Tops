package com.example.hms2;

//package com.example.demo.service;
//
//import com.example.demo.entity.OUUser;

//package com.example.hms2;

import com.example.hms2.OUUser;
import java.util.Optional;

public interface OUUserService {

    // Login: match email + password
    Optional<OUUser> login(String email, String password);

    // Change password using email
    boolean changePassword(String email, String newPassword);

    // Fetch user using only email (used in forgot-password)
    Optional<OUUser> findByEmail(String email);
}

