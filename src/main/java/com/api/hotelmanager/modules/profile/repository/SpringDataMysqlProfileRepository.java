package com.api.hotelmanager.modules.profile.repository;

import com.api.hotelmanager.modules.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMysqlProfileRepository extends JpaRepository<Profile, Long> {
}
