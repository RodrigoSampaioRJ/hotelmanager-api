package com.api.hotelmanager.repositories;

import com.api.hotelmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.login like ?1")
    Optional<User> findByLogin(String login);
}