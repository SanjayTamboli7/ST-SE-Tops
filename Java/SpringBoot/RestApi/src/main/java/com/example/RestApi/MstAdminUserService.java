package com.example.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MstAdminUserService {

    @Autowired
    private MstAdminUserRepository userRepository;

    public MstAdminUser saveUser(MstAdminUser user) {
        return userRepository.save(user);
    }
}
