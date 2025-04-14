package com.example.hms2;

//package com.example.demo.service;
//
//import com.example.demo.entity.OUOtherUser;
import java.util.Optional;

public interface OUOtherUserService {
    Optional<OUOtherUser> login(String email, String password);
    boolean changePassword(String email, String newPassword);
}

