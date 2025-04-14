package com.example.hms2;

//package com.yourpackage.repository;
//
//import com.yourpackage.entity.OUUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OUUserRepository extends JpaRepository<OUUser, Integer> {
    Optional<OUUser> findByOuseremailid(String ouseremailid);
}
