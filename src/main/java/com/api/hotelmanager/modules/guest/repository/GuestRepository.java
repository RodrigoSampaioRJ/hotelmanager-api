package com.api.hotelmanager.modules.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.modules.guest.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, String>{

}
