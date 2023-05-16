package com.api.hotelmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
