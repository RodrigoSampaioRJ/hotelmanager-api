package com.api.hotelmanager.modules.room.service;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.hotel.repository.IHotelRepository;
import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.mapper.RoomMapper;
import com.api.hotelmanager.modules.room.repository.IRoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.Optional;

public class RoomServiceImpl implements  IRoomService{

    private final IHotelRepository hotelRepository;
    private final IRoomRepository roomRepository;
    private final RoomMapper mapper;

    public RoomServiceImpl(IRoomRepository roomRepository, RoomMapper mapper, IHotelRepository hotelRepository){
        this.mapper = mapper;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Room save(RoomRequest roomRequest) {
        Room room = roomRepository.save(mapper.mapToRoom(roomRequest));
        return room;
    }

    @Override
    public Page<RoomResponse> findAll(Pageable pageable) {
        Page<Room> roomPage = roomRepository.findAll(pageable);
        return roomPage.map(mapper::mapToRoomResponse);
    }

    @Override
    public RoomResponse findById(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Room not found"));

        Optional<Hotel> hotel = hotelRepository.findById(room.getHotel().getId());
        hotel.ifPresent(room::setHotel);
        RoomResponse roomResponse = mapper.mapToRoomResponse(room);
        return roomResponse;
    }

    @Override
    public void delete(Long id) {
        roomRepository.delete(id);
    }

    @Override
    public boolean isAvailable(Long id, Instant checkin, Instant checkout) {
        System.out.println(id);
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()){
            return room.get().isAvailable(checkin,checkout);
        }
        return false;
    }


}
