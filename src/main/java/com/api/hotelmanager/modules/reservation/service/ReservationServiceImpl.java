package com.api.hotelmanager.modules.reservation.service;

import com.api.hotelmanager.modules.guest.entity.Guest;
import com.api.hotelmanager.modules.guest.repository.IGuestRepository;
import com.api.hotelmanager.modules.guest.service.IGuestService;
import com.api.hotelmanager.modules.reservation.dto.ReservationRequest;
import com.api.hotelmanager.modules.reservation.dto.ReservationResponse;
import com.api.hotelmanager.modules.reservation.entity.Reservation;
import com.api.hotelmanager.modules.reservation.mapper.ReservationMapper;
import com.api.hotelmanager.modules.reservation.repository.IReservationRepository;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.repository.IRoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class ReservationServiceImpl implements IReservationService {

    private final IGuestRepository guestRespository;
    private final IRoomRepository roomRepository;
    private final IReservationRepository reservationRepository;
    private final ReservationMapper mapper;

    public ReservationServiceImpl(IGuestRepository guestRespository,IRoomRepository roomRepository, IReservationRepository reservationRepository, ReservationMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
        this.guestRespository = guestRespository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Reservation save(ReservationRequest reservationRequest) {
        Optional<Guest> guest = guestRespository.findById(reservationRequest.guest().getId());
        Optional<Room> room = roomRepository.findById(reservationRequest.room().getId());
        Reservation reservation = mapper.mapToReservation(reservationRequest);
        if(guest.isPresent() && room.isPresent()){
            reservation.setRoom(room.get());
            reservation.setGuest(guest.get());
        }
        return reservationRepository.save(reservation);
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

