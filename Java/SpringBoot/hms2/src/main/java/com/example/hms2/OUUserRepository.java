package com.example.hms2;

//package com.example.demo.repository;
//
//import com.example.demo.entity.OUUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OUUserRepository extends JpaRepository<OUUser, Integer> {
    Optional<OUUser> findByOuseremailidAndOuserpassword(String email, String password);
    Optional<OUUser> findByOuseremailid(String email);
    
}
