package com.api.hotelmanager.modules.guest.repository;

import com.api.hotelmanager.modules.guest.entity.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGuestRepository {
    Optional<Guest> findById(String id);
    Page<Guest> findAll(Pageable pageable);
    Guest save(Guest guest);
    void delete(String id);
}