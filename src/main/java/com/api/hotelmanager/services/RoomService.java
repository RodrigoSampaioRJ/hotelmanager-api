package com.api.hotelmanager.services;

import org.springframework.stereotype.Service;

import com.api.hotelmanager.dtos.RoomRequest;
import com.api.hotelmanager.dtos.RoomResponse;
import com.api.hotelmanager.entities.Room;
import com.api.hotelmanager.mappers.RoomMapper;
import com.api.hotelmanager.repositories.RoomRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

	private final RoomRepository roomRepository;
	private final RoomMapper mapper;
	
	public RoomResponse getRoom(Long id) {
		
		RoomResponse roomResponse = mapper.roomToRoomResponse(roomRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Room not found")));
		
		return roomResponse;
	}
	
	public Room createRoom(RoomRequest roomRequest) {

		Room room = roomRepository.save(mapper.roomRequestToRoom(roomRequest));	
		
		return room;
	}
	
}
