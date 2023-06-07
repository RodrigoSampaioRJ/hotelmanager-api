package com.api.hotelmanager.modules.reservation.repository;

import com.api.hotelmanager.modules.reservation.entity.Reservation;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MysqlReservationRepository implements IReservationRepository{

    private final SpringDataMysqlReservationRepository reservationRepository;

    public MysqlReservationRepository(SpringDataMysqlReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return this.reservationRepository.findById(id);
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return this.reservationRepository.findAll(pageable);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return this.save(reservation);
    }

    @Override
    public void delete(Long id) {
        this.reservationRepository.deleteById(id);
    }
}
