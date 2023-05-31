package com.api.hotelmanager.repositories;

import com.api.hotelmanager.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}