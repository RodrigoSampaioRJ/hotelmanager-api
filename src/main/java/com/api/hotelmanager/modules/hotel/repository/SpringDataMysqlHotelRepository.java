package com.api.hotelmanager.modules.hotel.repository;

import com.api.hotelmanager.modules.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMysqlHotelRepository extends JpaRepository<Hotel, Long> {
}
