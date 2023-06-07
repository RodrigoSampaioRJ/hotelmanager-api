package com.api.hotelmanager.modules.room.repository;

import com.api.hotelmanager.modules.room.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IRoomRepository {
    Optional<Room> findById(Long id);
    Page<Room> findAll(Pageable pageable);
    Room save(Room room);
    void delete(Long id);
}