package com.api.hotelmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
