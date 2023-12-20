package com.api.hotelmanager.modules.guest.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.hotelmanager.modules.guest.entity.Guest;

public interface IGuestRepository {
    Optional<Guest> findById(Long id);
    Page<Guest> findAll(Pageable pageable);
    Guest save(Guest guest);
    void delete(Long id);
    Optional<Guest> findByEmail(String email);
}