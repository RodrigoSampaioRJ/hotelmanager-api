package com.api.hotelmanager.modules.hotel.repository;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import com.api.hotelmanager.modules.room.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IHotelRepository {
    Optional<Hotel> findById(Long id);
    Page<Hotel> findAll(Pageable pageable);
    Hotel save(Hotel hotel);
    void delete(Long id);
}