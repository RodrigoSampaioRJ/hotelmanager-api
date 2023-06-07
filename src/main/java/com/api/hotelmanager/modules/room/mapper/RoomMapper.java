package com.api.hotelmanager.modules.room.mapper;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface RoomMapper {
	
	@Mapping(target = "id",ignore = true)
	Room mapToRoom(RoomRequest roomRequest);
	RoomResponse mapToRoomResponse(Room room);
}
