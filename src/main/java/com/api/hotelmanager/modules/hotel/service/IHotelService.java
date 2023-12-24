package com.api.hotelmanager.modules.hotel.service;

import com.api.hotelmanager.modules.hotel.dto.HotelRequest;
import com.api.hotelmanager.modules.hotel.dto.HotelResponse;
import com.api.hotelmanager.modules.hotel.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHotelService {
    Hotel save(HotelRequest hotelRequest);
    Page<HotelResponse> findAll(Pageable pageable);
    HotelResponse findById(Long id);
    void delete(Long id);
    HotelResponse update(Long id, HotelRequest hotelRequest);
}
