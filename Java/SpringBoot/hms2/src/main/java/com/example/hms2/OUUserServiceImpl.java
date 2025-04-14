package com.example.hms2;

//package com.example.hms2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OUUserServiceImpl implements OUUserService {

    @Autowired
    private OUUserRepository ouUserRepository;

    @Override
    public Optional<OUUserStatusResponse> getUserStatusByEmail(String email) {
        Optional<OUUser> userOpt = ouUserRepository.findByOuseremailid(email);
        return userOpt.map(user -> new OUUserStatusResponse(
            user.getOuserid(),
            user.getOuserdeptid(),
            user.getOuserdesignationid(),
            user.getOuserstatus()
        ));
    }

    @Override
    public void changePassword(String email, String newPassword) {
        Optional<OUUser> optionalUser = ouUserRepository.findByOuseremailid(email);
        if (optionalUser.isPresent()) {
            OUUser user = optionalUser.get();
            user.setOuserpassword(newPassword);
            user.setLasteditdatetime(LocalDateTime.now());
            ouUserRepository.save(user);
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }
}
