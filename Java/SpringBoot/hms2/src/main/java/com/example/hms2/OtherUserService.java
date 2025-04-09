package com.example.hms2;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class OtherUserService {
    @Autowired
    private OtherUserRepository repository;

    public Page<OtherUser> getAllUsers(String search, Pageable pageable) {
        Specification<OtherUser> spec = (root, query, cb) -> {
            if (search != null && !search.isEmpty()) {
                String like = "%" + search.toLowerCase() + "%";
                return cb.or(
                    cb.like(cb.lower(root.get("ousername")), like),
                    cb.like(cb.lower(root.get("ouseremailid")), like)
                );
            }            
            return cb.conjunction();
        };
        return repository.findAll(spec, pageable);
    }

    public OtherUser saveUser(OtherUser user) {
        user.setLasteditdatetime(LocalDateTime.now());
        return repository.save(user);
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    public Optional<OtherUser> getUser(int id) {
        return repository.findById(id);
    }
    
    public OtherUserService(OtherUserRepository otherUserRepository) {
        this.repository = otherUserRepository;
    }

    public Page<OtherUser> searchUsers(String keyword, Pageable pageable) {
        Specification<OtherUser> spec = (root, query, cb) -> {
            String likePattern = "%" + keyword.toLowerCase() + "%";
            return cb.or(
                cb.like(cb.lower(root.get("ousername")), likePattern),
                cb.like(cb.lower(root.get("ouseremailid")), likePattern),
                cb.like(cb.lower(root.get("ousercontactno")), likePattern),
                cb.like(cb.lower(cb.function("CAST", String.class, root.get("ouserstatus"))), likePattern)
            );
        };
        return repository.findAll(spec, pageable);
    }    
}

