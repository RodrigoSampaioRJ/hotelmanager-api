package com.api.hotelmanager.modules.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.modules.reservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
