package com.example.hms2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OtherUserRepository extends JpaRepository<OtherUser, Integer>, JpaSpecificationExecutor<OtherUser> {
    // No implementation here — keep it clean
}
