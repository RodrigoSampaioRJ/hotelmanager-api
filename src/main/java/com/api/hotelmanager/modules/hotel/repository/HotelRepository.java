package com.api.hotelmanager.modules.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.modules.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
