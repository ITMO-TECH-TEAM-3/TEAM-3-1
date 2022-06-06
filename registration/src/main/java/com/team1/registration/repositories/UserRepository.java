package com.team1.registration.repositories;

import com.team1.registration.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    Optional<User> findById(UUID userId);

    boolean existsById(UUID userId);
}
