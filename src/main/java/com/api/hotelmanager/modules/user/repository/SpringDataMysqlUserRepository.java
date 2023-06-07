package com.api.hotelmanager.modules.user.repository;

import com.api.hotelmanager.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataMysqlUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
