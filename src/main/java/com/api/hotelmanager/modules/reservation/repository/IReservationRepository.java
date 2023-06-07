package com.api.hotelmanager.modules.reservation.repository;

import com.api.hotelmanager.modules.reservation.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IReservationRepository {
    Optional<Reservation> findById(Long id);
    Page<Reservation> findAll(Pageable pageable);
    Reservation save(Reservation reservation);
    void delete(Long id);
}