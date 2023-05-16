package com.api.hotelmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
