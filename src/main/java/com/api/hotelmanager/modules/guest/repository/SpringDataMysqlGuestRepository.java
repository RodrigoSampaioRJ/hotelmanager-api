package com.api.hotelmanager.modules.guest.repository;

import com.api.hotelmanager.modules.guest.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMysqlGuestRepository extends JpaRepository<Guest, String> {
}
