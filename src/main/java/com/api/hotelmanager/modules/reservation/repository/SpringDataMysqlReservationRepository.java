package com.api.hotelmanager.modules.reservation.repository;

import com.api.hotelmanager.modules.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMysqlReservationRepository extends JpaRepository<Reservation, Long> {
}
