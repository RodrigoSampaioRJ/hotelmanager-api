package com.api.hotelmanager.modules.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.modules.room.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
