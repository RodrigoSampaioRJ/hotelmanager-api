package com.api.hotelmanager.modules.guest.service;

import com.api.hotelmanager.modules.guest.dto.GuestRequest;
import com.api.hotelmanager.modules.guest.dto.GuestResponse;
import com.api.hotelmanager.modules.guest.entity.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGuestService {
    Guest save(GuestRequest guestRequest);
    Page<GuestResponse> findAll(Pageable pageable);
    GuestResponse findById(String id);
    void delete(String id);
}
