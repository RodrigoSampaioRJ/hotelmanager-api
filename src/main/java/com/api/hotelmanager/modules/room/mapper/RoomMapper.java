package com.api.hotelmanager.modules.room.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Room roomRequestToRoom(RoomRequest roomRequest);

    RoomResponse roomToRoomResponse(Room room);
}
