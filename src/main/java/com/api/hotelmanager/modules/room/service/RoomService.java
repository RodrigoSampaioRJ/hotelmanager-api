package com.api.hotelmanager.modules.room.service;

import org.springframework.stereotype.Service;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import com.api.hotelmanager.modules.room.mapper.RoomMapper;
import com.api.hotelmanager.modules.room.repository.RoomRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper mapper;

    public RoomResponse getRoom(Long id) {

        RoomResponse roomResponse = mapper.roomToRoomResponse(roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Room not found")));

        return roomResponse;
    }

    public Room createRoom(RoomRequest roomRequest) {

        Room room = roomRepository.save(mapper.roomRequestToRoom(roomRequest));

        return room;
    }

}
