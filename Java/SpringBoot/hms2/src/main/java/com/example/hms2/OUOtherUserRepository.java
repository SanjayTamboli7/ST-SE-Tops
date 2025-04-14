package com.example.hms2;

//package com.example.demo.repository;
//
//import com.example.demo.entity.OUOtherUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OUOtherUserRepository extends JpaRepository<OUOtherUser, Integer> {
    Optional<OUOtherUser> findByOuseremailidAndOuserpassword(String ouseremailid, String ouserpassword);
    Optional<OUOtherUser> findByOuseremailid(String ouseremailid);
}
