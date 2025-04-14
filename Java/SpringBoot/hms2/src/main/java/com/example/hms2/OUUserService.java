package com.example.hms2;

//package com.yourpackage.service;
//
//import com.yourpackage.dto.OUUserStatusResponse;

import java.util.Optional;

public interface OUUserService {
    Optional<OUUserStatusResponse> getUserStatusByEmail(String email);
    void changePassword(String email, String newPassword);
}
