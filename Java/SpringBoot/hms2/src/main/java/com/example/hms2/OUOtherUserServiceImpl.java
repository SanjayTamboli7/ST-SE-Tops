package com.example.hms2;

//package com.example.demo.service.impl;
//
//import com.example.demo.entity.OUOtherUser;
//import com.example.demo.repository.OUOtherUserRepository;
//import com.example.demo.service.OUOtherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OUOtherUserServiceImpl implements OUOtherUserService {

    @Autowired
    private OUOtherUserRepository repository;

    @Override
    public Optional<OUOtherUser> login(String email, String password) {
        return repository.findByOuseremailidAndOuserpassword(email, password);
    }

    @Override
    public boolean changePassword(String email, String newPassword) {
        Optional<OUOtherUser> userOpt = repository.findByOuseremailid(email);
        if (userOpt.isPresent()) {
            OUOtherUser user = userOpt.get();
            user.setOuserpassword(newPassword);
            user.setLasteditdatetime(LocalDateTime.now());
            repository.save(user);
            return true;
        }
        return false;
    }
}

