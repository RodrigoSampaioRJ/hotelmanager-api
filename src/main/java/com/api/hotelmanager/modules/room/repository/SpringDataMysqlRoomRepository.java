package com.api.hotelmanager.modules.room.repository;

import com.api.hotelmanager.modules.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMysqlRoomRepository extends JpaRepository<Room, Long> {
}
