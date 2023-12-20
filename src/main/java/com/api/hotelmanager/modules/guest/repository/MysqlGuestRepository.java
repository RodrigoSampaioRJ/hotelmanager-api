package com.api.hotelmanager.modules.guest.repository;

import com.api.hotelmanager.modules.guest.entity.Guest;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MysqlGuestRepository implements IGuestRepository{

    private final SpringDataMysqlGuestRepository guestRepository;

    public MysqlGuestRepository(SpringDataMysqlGuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }

    @Override
    public Optional<Guest> findById(Long id) {
        return this.guestRepository.findById(id);
    }

    @Override
    public Page<Guest> findAll(Pageable pageable) {
        return this.guestRepository.findAll(pageable);
    }

    @Override
    public Guest save(Guest guest) {
        return this.guestRepository.save(guest);
    }

    @Override
    public void delete(Long id) {
        this.guestRepository.deleteById(id);
    }

    @Override
    public Optional<Guest> findByEmail(String email) {
        return this.guestRepository.findByEmail(email);
    }
}
