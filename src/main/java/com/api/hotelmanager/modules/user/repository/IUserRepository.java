package com.api.hotelmanager.modules.user.repository;

import com.api.hotelmanager.modules.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserRepository{
    Optional<User> findById(Long id);
    Page<User> findAll(Pageable pageable);
    Optional<User> findByLogin(String login);
    User save(User user);
    void delete(Long id);
    boolean existsByEmail(String email);
}