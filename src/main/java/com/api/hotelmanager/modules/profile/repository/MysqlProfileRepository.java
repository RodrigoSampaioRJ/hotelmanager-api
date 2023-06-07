package com.api.hotelmanager.modules.profile.repository;

import com.api.hotelmanager.modules.profile.entity.Profile;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MysqlProfileRepository implements IProfileRepository {

    private final SpringDataMysqlProfileRepository profileRepository;

    public MysqlProfileRepository(SpringDataMysqlProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> findById(Long id) {
        return this.profileRepository.findById(id);
    }

    @Override
    public Page<Profile> findAll(Pageable pageable) {
        return this.profileRepository.findAll(pageable);
    }

    @Override
    public Profile save(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    public void delete(Long id) {
        this.profileRepository.deleteById(id);
    }
}