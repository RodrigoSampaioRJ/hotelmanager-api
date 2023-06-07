package com.api.hotelmanager.modules.profile.repository;

import com.api.hotelmanager.modules.profile.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProfileRepository {
    Optional<Profile> findById(Long id);
    Page<Profile> findAll(Pageable pageable);
    Profile save(Profile profile);
    void delete(Long id);
}