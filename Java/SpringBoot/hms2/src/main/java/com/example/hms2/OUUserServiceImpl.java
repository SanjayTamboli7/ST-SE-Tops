package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OUUserServiceImpl implements OUUserService {

    @Autowired
    private OUUserRepository ouUserRepository;

    @Override
    public Optional<OUUser> login(String email, String password) {
        return ouUserRepository.findByOuseremailidAndOuserpassword(email, password);
    }

    @Override
    public boolean changePassword(String email, String newPassword) {
        Optional<OUUser> userOpt = ouUserRepository.findByOuseremailid(email);
        if (userOpt.isPresent()) {
            OUUser user = userOpt.get();
            user.setOuserpassword(newPassword);
            user.setLasteditdatetime(LocalDateTime.now());
            ouUserRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public Optional<OUUser> findByEmail(String email) {
        return ouUserRepository.findByOuseremailid(email);
    }
}
