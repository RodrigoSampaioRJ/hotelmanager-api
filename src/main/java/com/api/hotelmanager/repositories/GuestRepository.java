package com.api.hotelmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.hotelmanager.entities.Guest;

public interface GuestRepository extends JpaRepository<Guest, String>{

}
