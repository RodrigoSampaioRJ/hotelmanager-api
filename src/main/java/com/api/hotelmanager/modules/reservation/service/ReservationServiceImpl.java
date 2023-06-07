package com.api.hotelmanager.modules.reservation.service;

import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import com.api.hotelmanager.modules.reservation.mapper.ReservationMapper;
import com.api.hotelmanager.modules.reservation.repository.IReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;
    private final ReservationMapper mapper;

    public ReservationServiceImpl(IReservationRepository reservationRepository, ReservationMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
    }

    @Override
    public Reservation save(ReservationRequest reservationRequest) {
        return reservationRepository.save(mapper.mapToReservation(reservationRequest));
    }

    @Override
    public Page<ReservationResponse> findAll(Pageable pageable) {
        Page<Reservation> reservationPage = reservationRepository.findAll(pageable);
        return reservationPage.map(mapper::mapToReservationResponse);
    }

    @Override
    public ReservationResponse findById(Long id) {
        return mapper.mapToReservationResponse(reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rservation not found")));
    }

    @Override
    public void delete(Long id) {
        reservationRepository.delete(id);
    }
}

