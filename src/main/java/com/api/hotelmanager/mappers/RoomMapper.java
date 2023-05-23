package com.api.hotelmanager.mappers;

import org.mapstruct.Mapper;

import com.api.hotelmanager.dtos.RoomRequest;
import com.api.hotelmanager.dtos.RoomResponse;
import com.api.hotelmanager.entities.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
	
	Room roomRequestToRoom(RoomRequest roomRequest);
	RoomResponse roomToRoomResponse(Room room);
}
