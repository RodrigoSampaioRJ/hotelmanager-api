package com.api.hotelmanager.modules.room.service;

import com.api.hotelmanager.modules.room.dto.RoomRequest;
import com.api.hotelmanager.modules.room.dto.RoomResponse;
import com.api.hotelmanager.modules.room.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;

public interface IRoomService {
    Room save(RoomRequest roomRequest);
    Page<RoomResponse> findAll(Pageable pageable);
    RoomResponse findById(Long id);
    void delete(Long id);
    boolean isAvailable(Instant checkin, Instant checkout);
}
