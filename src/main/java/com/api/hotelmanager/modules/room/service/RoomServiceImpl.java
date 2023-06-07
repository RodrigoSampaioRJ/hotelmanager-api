package com.api.hotelmanager.modules.room.service;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.mapper.RoomMapper;
import com.api.hotelmanager.modules.room.repository.IRoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RoomServiceImpl implements  IRoomService{

    private final IRoomRepository roomRepository;
    private final RoomMapper mapper;

    public RoomServiceImpl(IRoomRepository roomRepository, RoomMapper mapper){
        this.mapper = mapper;
        this.roomRepository = roomRepository;
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
        RoomResponse roomResponse = mapper.mapToRoomResponse(roomRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Room not found")));
        return roomResponse;
    }

    @Override
    public void delete(Long id) {
        roomRepository.delete(id);
    }
}
