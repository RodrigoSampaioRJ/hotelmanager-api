package com.api.hotelmanager.modules.guest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.modules.guest.entity.Guest;


public interface SpringDataMysqlGuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByEmail(String email);
}
