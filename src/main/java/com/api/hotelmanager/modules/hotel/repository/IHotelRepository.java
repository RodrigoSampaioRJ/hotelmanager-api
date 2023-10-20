package com.api.hotelmanager.modules.hotel.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.hotelmanager.modules.hotel.entity.Hotel;

public interface IHotelRepository {
    Optional<Hotel> findById(Long id);
    Page<Hotel> findAll(Pageable pageable);
    Hotel save(Hotel hotel);
    void delete(Long id);
}