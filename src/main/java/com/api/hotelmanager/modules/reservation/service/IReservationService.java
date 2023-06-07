package com.api.hotelmanager.modules.reservation.service;

import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReservationService {
    Reservation save(ReservationRequest reservationRequest);
    Page<ReservationResponse> findAll(Pageable pageable);
    ReservationResponse findById(Long id);
    void delete(Long id);
}
