package com.api.hotelmanager.modules.room.service;

import java.time.Instant;
import java.util.Optional;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.hotel.repository.IHotelRepository;
import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.repository.IRoomRepository;

import jakarta.persistence.EntityNotFoundException;

public class RoomServiceImpl implements  IRoomService{

    private final IHotelRepository hotelRepository;
    private final IRoomRepository roomRepository;
    private final ModelMapper mapper;

    public RoomServiceImpl(IRoomRepository roomRepository, IHotelRepository hotelRepository, ModelMapper mapper){
        this.mapper = mapper;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Room save(RoomRequest roomRequest) {
        Room room = roomRepository.save(mapper.map(roomRequest, Room.class));
        return room;
    }

    @Override
    public Page<RoomResponse> findAll(Pageable pageable) {
        Page<Room> roomPage = roomRepository.findAll(pageable);
        Page<RoomResponse> roomResponsePage = roomPage.map(new Function<Room,RoomResponse>() {
            @Override
            public RoomResponse apply(Room room){
                return new ModelMapper().map(room, RoomResponse.class);
            }
        });
        return roomResponsePage;
    }

    @Override
    public RoomResponse findById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Room not found"));

        Optional<Hotel> hotel = hotelRepository.findById(room.getHotel().getId());
        hotel.ifPresent(room::setHotel);
        RoomResponse roomResponse = mapper.map(room, RoomResponse.class);
        return roomResponse;
    }

    @Override
    public void delete(Long id) {
        roomRepository.delete(id);
    }

    @Override
    public boolean isAvailable(Long id, Instant checkin, Instant checkout) {
        if (checkin.isAfter(checkout)) {
            //throw new ReservationDateNotValidExceptionDto("Check-in date must be before check-out");
        }
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()){
            return room.get().isAvailable(checkin,checkout);
        }
        return false;
    }


}
