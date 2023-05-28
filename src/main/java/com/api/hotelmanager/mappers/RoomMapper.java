package com.api.hotelmanager.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.hotelmanager.dtos.RoomRequest;
import com.api.hotelmanager.dtos.RoomResponse;
import com.api.hotelmanager.entities.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
	
	@Mapping(target = "id", ignore = true)
	Room roomRequestToRoom(RoomRequest roomRequest);
	RoomResponse roomToRoomResponse(Room room);
}
