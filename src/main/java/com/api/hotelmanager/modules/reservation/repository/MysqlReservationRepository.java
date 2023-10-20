package com.api.hotelmanager.modules.reservation.repository;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.api.hotelmanager.modules.reservation.entity.Reservation;

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
        return this.reservationRepository.save(reservation);
    }

    @Override
    public void delete(Long id) {
        this.reservationRepository.deleteById(id);
    }
}
